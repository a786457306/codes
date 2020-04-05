package com.zzw.algorithm.jianzhi_offer.day02;

/**
 * Fibonacci
 *
 * 题目描述：
 * 写一个函数，输入n，求斐波那契数列的第n项。
 *
 * 思路：
 * 用递归很慢，求第100项需要把前面99项都求出来，所以可以直接算数。
 *
 * @author Daydreamer
 * @date 2018/8/20 23:03
 */
public class Fibonacci {

    public int fibonacci(int n){
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public long fibonacci1(int n){
        long result = 0;
        //前两项
        long preOne = 0;
        long preTwo = 1;

        if (n == 0){
            return preOne;
        }
        if (n == 1){
            return preTwo;
        }
        for (int i = 2; i < n; i++){
            result = preOne + preTwo;
            preOne = preTwo;
            preTwo = result;
        }
        return result;
    }
}
