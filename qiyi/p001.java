package qiyi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class p001 {
    static List<List<Integer>> list = new ArrayList<>();
    public static void perm(int[] array,int start,int end) {
        if(start==end) {
        //System.out.println(Arrays.toString(array));
            List<Integer> temp=new ArrayList<>();
            for(int i : array){
                temp.add(i);
            }
            list.add(temp);
            return;
        } else {
            for (int i = start; i <= end; i++) {
                swap(array,start,i);
                perm(array,start+1,end);
                swap(array,start,i);
            }
        }
    }
    public static void swap(int[] array,int i,int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int result = 0;
        int n = in.nextInt();
        List<Integer> a = new ArrayList<>();
        List<Integer> pl = new ArrayList<>();
        for (int i = 0; i < n-1; i++) {
            a.add(in.nextInt());
        }
        for (int i=1;i<=n;i++){
            pl.add(i);
        }
        int[] d = new int[pl.size()];
        for (int i:pl)
            d[i]=pl.get(i);
        perm(d,0,n-1);
        for (List<Integer> l1 : list){
            //System.out.println(t.toString());
            int i=0;
            for (;i<n-1;i++){
                if (a.get(i)==0){
                    if (l1.get(i)<l1.get(i+1))
                        continue;
                    else
                        break;
                }
                if (a.get(i)==1){
                    if (l1.get(i)>l1.get(i+1))
                        continue;
                    else
                        break;
                }
            }
            if (i==n-1)
                result++;
        }
        result = result%1000000007;
        System.out.println(result);
    }
}
