package com.zzw.algorithm.jianzhi_offer.day02;

/**
 * RectCover
 *
 * 题目：
 * 我们可以用 2*1 的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用 n 个 2*1 的小矩形无重叠地覆盖一个 2*n 的大矩
 * 形，总共有多少种方法？
 *
 * @author Daydreamer
 * @date 2018/8/22 21:27
 */
public class RectCover {
    public int RectCover(int target) {
        if(target == 0)
            return 0;
        if(target == 1)
            return 1;
        if(target == 2)
            return 2;
        int n0 = 1;
        int n1 = 2;
        int ret = 0;
        for(int i = 3 ; i <= target ; i++) {
            ret = n0 + n1;
            n0 = n1;
            n1 = ret;
        }
        return ret;
    }
}
