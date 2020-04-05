package com.zzw.algorithm.recursion;

/**
 * MoneyProblem
 * 给你一个数组arr，和一个整数aim。如果可以任意选择arr中的数字，
 * 能不能累加得到aim，返回true或者false。
 *
 * @author Daydreamer
 * @date 2018/4/11 13:07
 */
public class MoneyProblem {

    public static boolean money1(int[] arr, int aim) {
        return process1(arr, 0, 0, aim);
    }

    //递归
    public static boolean process1(int[] arr, int i, int sum, int aim) {
        // 从i位置开始，之后数字能够任意选择的话，能不能得到aim
        // 从0到i-1位置会选数字，选出来的数字的和是sum。
        // i到n-1位置的数字任意选，能不能得到剩下差值的数

        //basecase
        if (i == arr.length){ // 到了最后一个位置
            return sum == aim; // 返回当前和等不等于目标数
        }
        //要或者不要当前数。有一条成立就说明可以。
        //递归展开就是一棵树
        return (process1(arr, i+1, sum, aim) || process1(arr, i+1, sum + arr[i], aim));
    }

    //推动态规划：第i，sum位置的数依赖第i+1，sum的位置或第i+1, sum+arr[i]的位置
    public static boolean money2(int[] arr, int aim){
        boolean[][] dp = new boolean[arr.length + 1][aim + 1];//行号为i，列号为sum
        for (int i = 0; i < dp.length; i++){
            //数值正确那一列全变成true
            dp[i][aim] = true;
        }
        for (int i = arr.length - 1; i >= 0; i++){
            for (int j = aim - 1; j >= 0; j++){
                if (j + arr[i] <= aim){
                    dp[i][j] = dp[i+1][j] || dp[i+1][j+arr[i]];
                }
            }
        }
        return dp[0][0];
    }
}
