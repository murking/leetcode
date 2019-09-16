package zs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class zs02 {
    public static int n =0;
    public static void dfs(int x,int dp[][],int[] result){
        for (int i = x+1; i < n; i++) {
            if (dp[x][i]!=1000000001){
                dfs(i,dp,result);
                result[x] = Math.max(result[x],result[i]+dp[x][i]);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] dp = new int[n+1][n+1];
        for (int[] i: dp)
            Arrays.fill(i,1000000001);
        int[] result = new int[n+1];
        Arrays.fill(result,0);
        for (int i = 0; i < n-1; i++) {
            int j = sc.nextInt();
            int z = sc.nextInt();
            dp[j][z] = sc.nextInt();
        }
        for (int i = 1; i < n; i++) {
            dfs(i,dp,result);
        }
        for (int i=1;i<result.length;i++){
            System.out.println(result[i]);
        }
    }
}
/*
5
1 2 -3
1 3 2
2 4 6
2 5 -3
*/
