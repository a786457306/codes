package com.zzw.algorithm.jianzhi_offer.array;

/**
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class FindNumInTwoDemensionalArray {

    /**
     * 第一种解法：
     * 找左下角或右上角，利用递增递减规律
     *
     * @param target
     * @param array
     * @return
     */
    public boolean FindInLeftBottomCorner(int target, int [][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }

        int width = array[0].length;
        int height = array.length;

        if (target < array[0][0] || target > array[height - 1][width - 1]) {
            return false;
        }

        if (target == array[0][0] || target == array[height - 1][width - 1]) {
            return true;
        }

        int row = height - 1, column = 0;
        while (0 <= row && row < width && 0 <= column && column < height) {
            if (target == array[row][column]) {
                return true;
            }
            if (target < array[row][column]) {
                row--;
                continue;
            }
            if (target > array[row][column]) {
                column++;
                continue;
            }
        }
        return false;
    }


}
