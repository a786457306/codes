package com.zzw.algorithm.sort;

/**
 * MinSumTest
 * 求小和问题
 * 每个数左边比它小的数都求和，求最终的和。
 * 修改归并排序,因为左右分别排好序，不会重复，不会漏算。每次跟右边更大的合起来算。
 *
 * @author Daydreamer
 * @date 2018/3/27 16:03
 */
public class MinSumTest {
    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return mergeSort(arr, 0, arr.length - 1);
    }

    public static int mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return mergeSort(arr, l, mid) + mergeSort(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    public static int merge(int[] arr, int l ,int m, int r){
        int res = 0;
        int i = 0;
        int[] help = new int[r - l + 1];
        int p1 = l;
        int p2 = m + 1;
        while (p1 <= m && p2 <= r){
            res += arr[p1] < arr[p2] ? arr[p1] * (r-p2+1) : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
        return res;
    }
}