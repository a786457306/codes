package com.zzw.algorithm.jianzhi_offer.day02;

/**
 * JumpFloor
 *
 * 跳台阶
 * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。
 * 求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * @author Daydreamer
 * @date 2018/8/22 21:36
 */
public class JumpFloor {
    public int JumpFloor(int n){
        if (n == 0 || n == 1 || n == 2){
            return n;
        }
        int pre1 = 1;
        int pre2 = 2;
        int res = 0;
        for (int i = 2; i < n; i++){
            res = pre1 + pre2;
            pre1 = pre2;
            pre2 = res;
        }
        return res;
    }
}
