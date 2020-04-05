package com.zzw.algorithm.sort;

/**
 * ShellSort
 * 希尔排序
 * 增量排序，首先定义增量为总数/2，排序，再逐渐缩小增量。
 *
 * @author Daydreamer
 * @date 2018/3/26 19:11
 */
public class ShellSort {

    public void shellSort(){
        int[] arr = {1,2,5,8,7,4,2,9,7,0};
        int j = 0;
        int temp = 0;
        for (int incr = arr.length / 2; incr > 0; incr = incr / 2){
            System.out.println(incr);
            for (int i = incr; i < arr.length; i++){
                temp = arr[i];
                for (j = i - incr; j >= 0; j = j - incr){
                    if (arr[j] > temp){
                        arr[j + incr] = arr[j];
                    }
                    else
                        break;
                }
                arr[j + incr] = temp;
            }
        }
    }

}
