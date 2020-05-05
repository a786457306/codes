package com.zzw.algorithm.jianzhi_offer.array;

import java.util.Hashtable;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class FindFirstDuplicateNum {

    /**
     * 第一种解法：
     * 通过boolean数组记录是否有重复数字
     *
     * @param numbers an array of integers
     * @param length the length of array numbers
     * @param duplication(Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
     * @return 返回任意重复的一个，赋值duplication[0]. true if the input is valid, and there are some duplications in the array number, otherwise false
     */
    public boolean duplicateSetBoolean(int numbers[], int length, int[] duplication) {
        boolean[] flag = new boolean[length];
        for (int i = 0; i < length; i++) {
            if (flag[numbers[i]]) {
                duplication[0] = numbers[i];
                return true;
            }
            flag[numbers[i]] = true;
        }
        return false;
    }

    /**
     * 第二种解法：
     * 使用Hashtable记录该数字是否被访问
     *
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicateUsingHashTable(int numbers[], int length, int[] duplication) {
        Hashtable<Integer, Integer> flag = new Hashtable<>();
        for (int i = 0; i < length; i++) {
            if (flag.get(numbers[i]) != null) {
                duplication[0] = numbers[i];
                return true;
            }
            flag.put(numbers[i], 1);
        }
        return false;
    }

    /**
     * 第三种解法：
     * 在数组中对值做标记，不用额外的空间复杂度，时间复杂度为O(n)
     * 1. 每访问一个数字，就在它对应的位置上+n
     * 2. 当索引值>n时，说明取索引值的位置已经被访问过，-n就能知道原来数字是什么，得到对应索引
     * 3. 若根据索引找到的数组中对应位置实际数字已经>n，说明它已经被访问过
     * 4. 将index代表的数字直接返回即可。
     *
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicateSetAddN(int numbers[], int length, int[] duplication) {
        int index;
        for (int i = 0; i < length; i++) {

            // 索引指向该值在数组中对应位置
            index = numbers[i];

            // 这个值已经被访问过，> length，得到原值 - length
            if (index >= length) {
                index -= length;
            }

            // 该值已经被访问过，指向对应的数字时发现已经加过length了，直接返回
            if (numbers[index] > length) {
                duplication[0] = index;
                return true;
            }
            // 索引指向的值第一次被访问，标记，+length
            numbers[index] += length;
        }
        duplication[0] = -1;
        return false;
    }
}
