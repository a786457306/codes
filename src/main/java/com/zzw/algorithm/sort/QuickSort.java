package com.zzw.algorithm.sort;

/**
 * QuickSort
 * 算法效率取决于划分值在排序后数组中位置。
 * 随机快速排序最常用
 *
 * @author Daydreamer
 * @date 2018/3/27 18:33
 */
public class QuickSort {
    public static void qsort(int[] arr, int L, int R){//随机选数排序就是快排
        //将选到的划分值放到最后一个，按照刚刚的方法排序
        if (L < R) {
            swap(arr, R, L + (int) (Math.random() * (R - L + 1)));
            int[] p = partition(arr, L, R);
            qsort(arr, L, p[0] - 1);//小于区排序
            qsort(arr, p[1] + 1, R);//大于区排序
        }
    }

//    public static void partition1(int[] arr, int L, int R){
//        int p = arr[R];//最后一个数作划分值
//        int less = L - 1;//小于等于区的边界
//        for (int i = L; i <= R; i++){
//            if (arr[i] <= p){
//                swap(arr, ++less, i);
//            }
//        }
//    }

    public static int[] partition(int[] arr, int L, int R){
        int less = L - 1;
        int more = R;
        while (L < more){//省一个变量，用L遍历（？？
            if (arr[L] < arr[R]){//arr[L]是当前数，当前数小于划分值
                swap(arr, ++less, L++);//最小区往右范围扩1，
            }
            else if (arr[L] > arr[R]){//当前数大于划分值
                swap(arr, --more, L);//当前数与最大区左边第一个数交换，交换后再检查这个数
            }
            else {
                L++;//当前数与划分值相等时不处理，直接看下一个，把相等的放中间。
            }
        }
        swap(arr, more, R);//大于区第一个数和划分值交换，把它放到中间去
        return new int[]{less + 1, more};//返回等于区的左右边界
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}