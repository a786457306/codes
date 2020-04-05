package com.zzw.algorithm.sort;

/**
 * BucketSort
 * 桶排序
 * 用桶作为容器装
 * 计数排序
 *
 * @author Daydreamer
 * @date 2018/3/28 14:47
 */
public class BucketSort {
    public static void bucketSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
        }
        int[] bucket = new int[max + 1];
        for (int i = 0; i < arr.length; i++){
            bucket[arr[i]]++;
        }
        int i = 0;
        for (int j = 0; j < bucket.length; j++){
            while (bucket[j]-- > 0){//放入后删除元素
                arr[i++] = bucket[j];
            }
        }
    }
}
