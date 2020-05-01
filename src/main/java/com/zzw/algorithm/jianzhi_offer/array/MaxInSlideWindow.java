package com.zzw.algorithm.jianzhi_offer.array;

import java.util.ArrayList;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class MaxInSlideWindow {

    /**
     * 第一种解法：遍历元素取最大值
     *
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> solutionTranversal(int[] num, int size) {

        ArrayList<Integer> result = new ArrayList<>();

        if (num == null || num.length <= 0 || size <= 0 || num.length < size) {
            return result;
        }

        // 结果数组的长度
        int length = num.length - size + 1;
        for (int i = 0; i < length; i++) {
            int max = 0;
            for (int j = i; j < i + size; j++) {
                max = compare(max, num[j]);
            }
            result.add(max);
        }
        return result;
    }

    public int compare(int max, int value) {
        if(max < value) {
            max = value;
        }
        return max;
    }
}
