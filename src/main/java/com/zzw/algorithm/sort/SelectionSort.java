package com.zzw.algorithm.sort;

/**
 * SelectionSort
 *
 * 选择排序：每次选最小的放在起始位置。
 * 不稳定。
 *
 * 时间复杂度：O(n^2)
 *
 * @author Daydreamer
 * @date 2018/3/23 17:22
 */
public class SelectionSort {
    public static void selectionSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        //每次从排好的元素之后开始找，所以每次i+1.找小的与第一个元素交换
        for (int i = 0; i < arr.length - 1; i++){//每次往后移一个元素，没有更小的自动后移
            int minIndex = i;
            //从当前元素后面开始找，找最小的与未排序元素交换
            for (int j = i + 1; j < arr.length; j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
