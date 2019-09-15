package qiyi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class p002 {

    public static int numSequence(String S) {
        int len = S.length();
        char[] chs = S.toCharArray();
        int[][] record = new int[len + 1][len + 1];
        record[0][0] = 1;
        int base = 1000000007;
        for(int i = 1; i < len + 1; i++) {
            char ch = chs[i - 1];
            for(int j = 0; j <= i; j++) {
                if(ch == '1') {
                    record[i][j] += record[i - 1][i - 1];
                    if(j != 0)
                        record[i][j] -= record[i - 1][j - 1];
                }
                else if(ch == '0') {
                    if(j != 0)
                        record[i][j] += record[i - 1][j - 1];
                }
                record[i][j] %= base;
                if(j > 0)
                    record[i][j] += record[i][j - 1];
                record[i][j] %= base;
            }
            if(i < len)
                record[i][i + 1] = record[i][i];
        }
        return (record[len][len] + base) % base;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int result = 0;
        int n = in.nextInt();
        StringBuffer s = new StringBuffer();
        List<Integer> pl = new ArrayList<>();
        for (int i = 0; i < n-1; i++) {
            s.append(String.valueOf(in.nextInt()));
        }
        System.out.println(numSequence(s.toString()));
    }
}
