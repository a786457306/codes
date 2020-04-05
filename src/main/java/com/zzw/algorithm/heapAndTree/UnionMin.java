package com.zzw.algorithm.heapAndTree;

/**
 * UnionMin
 *
 * @author Daydreamer
 * @date 2018/4/7 14:04
 */
public class UnionMin {
    public static int findUnionMin(int[] arr){
        int n = arr.length;
        if (arr[0] < arr[1]){
            return 0;
        }
        if (arr[n - 1] < arr[n - 2]){
            return n - 1;
        }
        int low = 0;
        int high = n - 1;
        while (low <= high){
            int mid = low + (high - low) / 2;
            if (arr[mid] < arr[mid + 1] && arr[mid] < arr[mid - 1]){
                return mid;
            }
            //如果mid不是局部最小，则两边一定都有（盆地），随便找一个就行
            else {
                low = mid + 1;
            }
        }
        return 0;
    }
}
