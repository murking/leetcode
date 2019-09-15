package tc58;

import java.util.*;

public class p002 {
    public static int sovle(List<Integer> arr){
        int result = 0;
        if (arr==null)
            return 0;
        int tem[] = new int[arr.size()];
        Arrays.fill(tem,1);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i)>arr.get(i-1)){
                tem[i]=tem[i-1]+1;
            }
        }
        for (int i = arr.size()-1; i >0 ; i--) {
            result += tem[i];
            if (arr.get(i)<arr.get(i-1)&&tem[i]>=tem[i-1])
                tem[i-1]=tem[i]+1;
        }
        result+=tem[0];
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        System.out.println(sovle(arr));
    }
}
