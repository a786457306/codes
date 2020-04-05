package com.zzw.algorithm.sort;

/**
 * InsertSort
 *
 * 默认左边元素都是排好序的，将未排序的第一个元素插到左边合适位置
 * 比较对象：比如人名，compareTo
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 *
 * @author Daydreamer
 * @date 2018/3/22 18:42
 */
public class InsertSort {
    public static void insertSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        for (int i = 1; i < arr.length; i++){//一个一个往后换
            for (int j = i - 1; j >= 0 && arr[j] > arr[j+1]; j--){//j为排好序部分的最终位置（分界线）
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
            }
        }
    }
}
