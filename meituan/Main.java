package meituan;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
class PrizePool {

    public void send(String input) {

        System.out.print(input);

    }

}

class ReviewEncourage {
    private int n;
    private AtomicInteger number = new AtomicInteger(0);
    private Lock lock = new ReentrantLock();
    private Condition ca = lock.newCondition();
    private Condition cb = lock.newCondition();
    private Condition cc = lock.newCondition();


    public ReviewEncourage(int n) {
        this.n=n;
    }      // 构造函数,n为中奖用户数



    public void bonus(PrizePool prizePool) {
        lock.lock();
        try {
            while (number.get()%2!=1){
                ca.await();
            }
            prizePool.send("A");
            number.getAndIncrement();

            cb.signal();
            cc.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }  // 仅能打印A，表示发放积分

    public void coupon(PrizePool prizePool) {
        lock.lock();
        try{
            while ((number.get()/2)%2!=1&&number.get()%2!=0){
                cb.await();
            }
            prizePool.send("B");
            number.getAndIncrement();
            ca.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }  // 仅能打印B，表示发放优惠券

    public void contribution(PrizePool prizePool) {
        lock.lock();
        try {
            while ((number.get()/2)%2!=0&&number.get()%2!=0){
                cc.await();
            }
            prizePool.send("C");
            number.getAndIncrement();
            ca.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }  // 仅能打印C，表示发放贡献值
}

public class Main{

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ReviewEncourage reviewEncourage = new ReviewEncourage(n);
        PrizePool prizePool = new PrizePool();
        int num =0;
        new Thread(()->{
            for (int i=0;i<n;i++){
                reviewEncourage.bonus(prizePool);
            }
        },"111").start();


        new Thread(()->{
            for (int i=0;i<n;i++){
                reviewEncourage.coupon(prizePool);
            }
        },"222").start();
        new Thread(()->{
            for (int i=0;i<n;i++){
                reviewEncourage.contribution(prizePool);
            }
        },"333").start();
    }
}
