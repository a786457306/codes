package com.zzw.algorithm.jianzhi_offer.day02;

/**
 * Problem11
 *
 * 给定一个double类型的浮点数base和int类型的整数exponent。
 * 求base的exponent次方。
 *
 * @author Daydreamer
 * @date 2018/8/22 21:52
 */
public class Problem11 {
    public double solution(double base , int exponent) {
        boolean f = exponent < 0 ? true : false;
        if( (exponent = Math.abs(exponent) ) == 0 )
            return 1.0;
        if(base == 0)
            return 0;
        double ret = solution(base , exponent / 2);
        ret = exponent % 2 == 0 ? ret * ret : ret * ret * base;
        return f ? 1.0 / ret : ret;
    }
}
