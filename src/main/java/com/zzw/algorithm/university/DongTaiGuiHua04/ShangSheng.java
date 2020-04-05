package com.zzw.algorithm.university.DongTaiGuiHua04;

import java.util.Scanner;

/**
 * ShangSheng
 *
 * 最长上升子序列
 * 一个数的序列bi，当b1 < b2 < ... < bS的时候，我们称这个序列是上升的。
 * 对于给定的一个序列(a1, a2, ..., aN)，我们可以得到一些上升的子序列
 * (ai1, ai2, ..., aiK)，这里1 <= i1 < i2 < ... <iK <= N。
 * 比如，对于序列(1, 7, 3, 5, 9, 4, 8)，有它的一些上升子序列，
 * 如(1, 7), (3, 4, 8)等等。这些子序列中最长的长度是4，比如子序列(1, 3, 5, 8).
 * 对于给定的序列，求出最长上升子序列的长度。
 *
 * @author Daydreamer
 * @date 2017/10/22 10:20
 */
public class ShangSheng {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()){
            int n = scan.nextInt();
            int[] input = new int[n];
            for (int i = 0;i < n;i++){
                input[i] = scan.nextInt();
            }
            System.out.println(seq(input));
        }
    }

    public static int seq(int[] input){
        int max = 0;//最大长度
        int n = input.length;
        int[] sequence = new int[n];

        for (int i = 0; i < n; i++){
            sequence[i] = 1;
        }

        for (int i = 0; i < n; i++){
//            max = 0;
            for (int j = 0; j <= i; j++){
                if (input[i] > input[j] && sequence[i] < sequence[j]+1){//发现上升元素且长度比原来小，则长度+1
                    sequence[i] = sequence[j] + 1;
                    max = sequence[i];//最大值为sequence[i]
                }
            }
        }
        return max;
    }
}
