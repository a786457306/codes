package com.zzw.algorithm.university.DongTaiGuiHua04;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * GongGong
 *
 * 最长公共子序列
 * 我们称序列Z = < z1, z2, ..., zk >是序列X = < x1, x2, ..., xm >的子序列
 * 当且仅当存在严格上升的序列< i1, i2, ..., ik >，使得对j = 1, 2, ... ,k,
 * 有xij = zj。比如Z = < a, b, f, c > 是X = < a, b,c, f, b, c >的子序列。
 * 现在给出两个序列X和Y，找到X和Y的最大公共子序列，也就是说要找到一个最长的序列Z，
 * 使得Z既是X的子序列也是Y的子序列。
 *
 * @author Daydreamer
 * @date 2017/10/23 20:22
 */
public class GongGong {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()){
            String str = scan.nextLine();
            Pattern p = Pattern.compile("\\s+");
            Matcher m = p.matcher(str);
            str = m.replaceAll(" ");
            String[] strs = str.split(" ");
            char[] x = strs[0].toCharArray();
            char[] y = strs[1].toCharArray();
            System.out.println(lcsLength(x, y));
        }
    }

    public static int lcsLength(char[] x, char[] y){

        int m = x.length;
        int n = y.length;
        int[][] c = new int[200][200];
        for (int i = 0; i < m; i++) c[i][0] = 0;
        for (int j = 0; j <= n; j++) c[0][j] = 0;
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++) {
                if (x[i-1] == y[j-1]) {
                    c[i][j] = c[i-1][j-1] + 1;
                }
                else {
                    if (c[i][j-1] >= c[i-1][j]) {
                        c[i][j] = c[i][j-1];
                    } else {
                        c[i][j] = c[i-1][j];
                    }
                }
            }
        return c[m][n];
    }
}
