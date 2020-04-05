package com.zzw.algorithm.recursion;

/**
 * Cow
 *
 * @author Daydreamer
 * @date 2018/4/12 16:34
 */
public class Cow {
    public static int cowNum(int n){
        if (n <= 0){
            return 0;
        }
        if (n == 1 || n == 2 || n == 3){
            return n;
        }
        return cowNum(n - 1) + cowNum(n - 3);
    }
}
