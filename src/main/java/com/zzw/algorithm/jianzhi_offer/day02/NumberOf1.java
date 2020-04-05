package com.zzw.algorithm.jianzhi_offer.day02;

/**
 * Problem10
 *
 * 题目：请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。例如
 * 把9表示成二进制是1001；有2位是1，因此如果输入9，函数输出2.
 *
 * @author Daydreamer
 * @date 2018/8/21 17:36
 */

public class NumberOf1 {
    public static void main(String[] args) {
        NumberOf1(9);
    }

    public static int NumberOf1(int n) {
        int cnt = 0;
        int value = 1;
        for(int i = 0; i < 32; i++){
            if((value & n) == value){
                cnt++;
            }
            value = value << 1;
        }
        return cnt;
    }
}
