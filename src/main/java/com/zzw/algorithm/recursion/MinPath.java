package com.zzw.algorithm.recursion;

import java.util.HashMap;

/**
 * MinPath
 *
 * @author Daydreamer
 * @date 2018/4/10 17:50
 */
public class MinPath {

//    public static int minPath(int[][] arr){
//        int m = arr.length;//行
//        int n = arr[0].length;//列
//        int i = 0;
//        int j = 0;
//        int res = 0;
//        while (i < m && j < n){
//            res += arr[i+1][j] >= arr[i][j+1] ? arr[++i][j] : arr[i][++j];
//        }
//        return res;
//    }

    public static int minPath(int[][] matrix){
        return process(matrix, 0, 0);
        //i,j为出发位置。返回值作为最小路径和的一部分
    }

    public static int process(int[][] arr, int i, int j){
        if (i == arr.length - 1 && j == arr[0].length - 1){
            return arr[i][j];//起点即终点
        }
        //到了最后一行，但还没到最后一列
        if (i == arr.length - 1){
            return arr[i][j] + process(arr, i, j + 1);
        }
        //到了最后一列，但还没到最后一行
        if (j == arr[0].length - 1){
            return arr[i][j] + process(arr, i + 1, j);
        }
        return arr[i][j] + Math.min(process(arr, i, j+1), process(arr, i+1, j));
    }

    //缓存方法，不关心依赖，相同状态都可以代表，就不用暴力
    static HashMap<String, Integer> cache = new HashMap<>();

    //之前算过就不递归了，直接取值，没算过再算。
    //将已经算过的答案记录到cache里面去。
    public static int process2(int[][] arr, int i, int j){
        int res = 0;
        if (i == arr.length - 1 && j == arr[0].length - 1){
            res = arr[i][j];//起点即终点
        }else if (i == arr.length - 1){
            int next = 0;
            //下一步取 i,j+1
            String nextKey = String.valueOf(i) + "_" + String.valueOf(j+1);
            if (cache.containsKey(nextKey)){
                //说明之前算过，直接取值
                next = cache.get(nextKey);
            } else {
                //否则就是没算过，去算
                next = process2(arr, i, j+1);
            }
            //res就等于当前值+next
            res = arr[i][j] + next;
        } else if (j == arr[0].length - 1){
            int next = 0;
            String nextKey = String.valueOf(i+1) + "_" + String.valueOf(j);
            if (cache.containsKey(nextKey)){
                next = cache.get(nextKey);
            } else {
                next = process2(arr, i+1, j);
            }
            res = arr[i][j] + next;
        }
        //否则要查两回
        else {
            int downNext = 0;
            String downNextKey = String.valueOf(i+1) + "_" + String.valueOf(j);
            if (cache.containsKey(downNextKey)){
                downNext = cache.get(downNextKey);
            } else {
                downNext = process2(arr, i+1, j);
            }
            res = arr[i][j] + downNext;

            int rightNext = 0;
            String rightNextKey = String.valueOf(i) + "_" + String.valueOf(j+1);
            if (cache.containsKey(rightNextKey)){
                downNext = cache.get(rightNextKey);
            } else {
                downNext = process2(arr, i, j+1);
            }
            res = arr[i][j] + Math.min(downNext, rightNext);
        }
        String key = String.valueOf(i) + "_" + String.valueOf(j);
        //把结果放到cache中去再返回
        cache.put(key, res);
        return res;
    }
}
