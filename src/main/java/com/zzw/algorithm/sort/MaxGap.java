package com.zzw.algorithm.sort;

/**
 * MaxGap
 * 求数组内最大差值
 *
 * 先找数组内最大值，最小值，依组内数据个数安排桶数（length+1）
 * 设置三个数组放桶信息，是否有元素，最值是啥
 * 给元素求桶号，每个桶里只存最值。
 * 遍历桶，求上一个桶最大值与当前桶最小值差值的最大值。
 *
 * @author Daydreamer
 * @date 2018/3/28 16:20
 */
public class MaxGap {
    public static int maxGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++){
            min = Math.min(nums[i], min);
            max = Math.max(nums[i], max);
        }
        if (max == min){//最值相等说明只有一种数，差值为0
            return 0;
        }
        boolean[] hasNum = new boolean[len + 1];//每个桶里是否有元素
        int[] maxs = new int[len + 1];//每个桶里最大元素
        int[] mins = new int[len + 1];//每个桶里最小元素
        int bid = 0;//桶号
        for (int i = 0; i < len; i++){
            bid = bucket(nums[i], len, min, max);
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], nums[i]) : nums[i];
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], nums[i]) : nums[i];
            hasNum[bid] = true;
        }
        int res = 0;
        int lastMax = maxs[0];//上一个最大值
        int i = 1;
        for (; i < len; i++){
            if (hasNum[i]){
                res = Math.max(res, mins[i] - lastMax);//当前桶的最小值与上个桶的最大值作差，最大的为结果
                lastMax = maxs[i];
            }
        }
        return res;
    }

    public static int bucket(long num, long len, long min, long max){//判断元素在哪个桶
        return (int)((num - min) * len / (max - min));//(max - min)/len（一个桶里几个数） = (num - min)/桶号
    }
}
