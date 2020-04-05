package com.zzw.algorithm.jianzhi_offer.day02;

/**
 * JumpFloorII
 * 变态跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……
 * 它也可以跳上n级。求该青蛙跳上一个n级的台阶总
 * 共有多少种跳法。
 *
 * @author Daydreamer
 * @date 2018/8/22 21:47
 */
public class JumpFloorII {
    public int JumpFloorII(int n){
        if (n == 0){
            return 1;
        }
        int res = 1;
        for (int i = 1; i < n; i++){
            res *= 2;
        }
        return res;
    }
}
