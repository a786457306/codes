package com.zzw.algorithm.recursion;

/**
 * Knapsack
 * 背包问题
 * 给定两个数组w和v，两个数组长度相等，w[i]表示第i件商品的重量，
 * v[i]表示第i件商品的价值。再给定一个整数bag，要求你挑选商品
 * 的重量加起来一定不能超过bag，返回满足这个条件下，你能获得的
 * 最大价值。
 *
 * @author Daydreamer
 * @date 2018/4/11 19:53
 */
public class Knapsack {

    public static int process(int[] values, int[] weights,
                              int i, int alreadyWeight, int bag){
        //i之后的货物随意选，能形成的最好收益
        if (alreadyWeight > bag){
            return Integer.MIN_VALUE;//无效值，即这条路是不能用的
        }
        if (i == weights.length){
            return 0;
            // 所有货物都结束的时候，无法继续了。
            // 当前货物+后续，所以返回0是因为不算之前的货形成的收益
            // 因为之前的货在自己的函数中已经加过了
        }
        return Math.max(
                // 不放入当前货物
                process(values, weights, i+1, alreadyWeight, bag),
                // 放入当前货物，当前价值加上后续
                values[i] +
                process(values, weights, i+1, weights[i] + alreadyWeight, bag)
        );
    }

    public static int maxValue2(int[] w, int[] v, int bag){
        int[][] dp = new int[w.length + 1][bag + 1];//0到n，0到bag
        for (int i = w.length - 1; i >=0; i--){//填表
            for (int j = bag; j >= 0; j--){
                dp[i][j] = dp[i + 1][j];
                if (j + w[i] <= bag){//决策
                    dp[i][j] = Math.max(dp[i][j], v[i] + dp[i + 1][j + w[i]]);
                }
            }
        }
        return dp[0][0];//返回00位置
    }
}
