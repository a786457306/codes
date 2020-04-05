package com.zzw.algorithm.jianzhi_offer.day03;

/**
 * Order
 * 调整数组顺序使奇数位于偶数前面
 *
 * @author Daydreamer
 * @date 2018/8/22 22:05
 */
public class Order {
    public void reOrderArray(int [] array) {
        int n = array.length;
        int[] jArray = new int[n];
        int[] oArray = new int[n];
        int kj = 0;
        int ko = 0;
        for(int i = 0 ; i < n ; i++) {
            if( (array[i] - 1) % 2 == 0 )
                jArray[kj++] = array[i];
            else
                oArray[ko++] = array[i];
        }
        for(int i = 0 ; i < kj ; i++) {
            array[i] = jArray[i];
        }
        for(int i = kj ; i < n ; i ++) {
            array[i] = oArray[i - kj];
        }
    }
}
