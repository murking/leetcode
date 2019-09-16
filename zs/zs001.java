package zs;

import java.util.Scanner;

public class zs001 {
    public static void main(String[] args) {
        String str = new String();
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine().toString();
        int len = str.length();
        int []nums = new int[len];
        char []arr = new char[len];

        for (int i = 0; i < len; i++) {
            arr[i] = str.charAt(i);
            nums[i] = 1;
        }
        int[] tem = new int[len];
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < len; j++) {
                tem[j]=0;
            }
            for (int j = 0; j < len; j++) {
                if (arr[j]=='R')
                    tem[j+1]+=nums[j];
                else if (arr[j]=='L')
                    tem[j-1]+=nums[j];

            }
            for (int j = 0; j < len; j++) {
                nums[j]=tem[j];
            }
        }
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i]+" ");
        }
    }
}
