package com.zzw.algorithm.recursion;

/**
 * Factorial
 *
 * @author Daydreamer
 * @date 2018/4/10 17:14
 */
public class Factorial {

    public static int getMin(int[] arr, int L, int R){
        if (L == R){
            return arr[L];
        }
        int mid = (L + R) / 2;
        int leftMin = getMin(arr, L, mid);
        int rightMin = getMin(arr, mid+1, R);
        return Math.min(leftMin, rightMin);
    }

    public static long getFactorial(int n){
        //basecase：终止条件
        if (n == 1){
            return 1L;
        }
        //决策条件
        return (long) n * getFactorial(n - 1);
    }

    public static long getFactorial2(int n){
        long res = 1;
        for (int i = 1; i <= n; i++){
            res *= i;
        }
        return res;
    }
}
