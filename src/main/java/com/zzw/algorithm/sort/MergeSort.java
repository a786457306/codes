package com.zzw.algorithm.sort;

/**
 * MergeSort
 * 数组分左右，左右分别排好序后合并
 * 左边第一个右边第一个一起看，哪个小填那个并指针后移一个
 * 左右两边排序复杂度分别是T(N/2),把数组拷贝回去复杂度为O(N)
 * 总复杂度为2T(N/2) + O(N)
 *
 * 求小和问题（右边比当前元素大的元素个数）
 * 求降序对（右边比当前元素小的元素个数）
 *
 * @author Daydreamer
 * @date 2018/3/23 18:39
 */
public class MergeSort {
    public static void mergeSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        sortProcess(arr, 0, arr.length - 1);
    }

    public static void sortProcess(int[] arr, int L, int R){//左右两边分别排序，递归过程
        if (L == R){//数组规模到了什么程度的时候不用再划分，递归的终止条件
            return;//L，R表示数组位置
        }
        int mid = L + (R - L)>>1;//L + (R - L) / 2
        //熟悉以后用递归应该是宏观过程，下面两个函数就表示左右都排好，不用细抠过程。
        sortProcess(arr, L, mid);//排左边
        sortProcess(arr, mid + 1, R);//排右边
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int l, int m, int r){//合并两个数组
        int[] help = new int[r - l + 1];//要被merge的两个数组长度之和
        int i = 0;//哪个数小就依次把数填在help的该位置上
        int p1 = l;//p1p2指向两个数组起始位置
        int p2 = m + 1;
        while (p1 <= m && p2 <= r){//两个数组都不越界的时候
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];//在数组中存小的那个数
        }
        //p1p2一定有一个越界，下面两个循环发生一个。
        while (p1 <= m){//p2越界
            help[i++] = arr[p1++];
        }
        while(p2 <= r){//p1越界
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++){
            arr[l + i] = help[i];//拷贝回那个数组.l + i表示的是范围。比如help数组表示的0到8，arr里是10到18
        }
    }
}
