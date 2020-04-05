package com.zzw.algorithm.linkedlist_stack_queue;

/**
 * ZigZagPrintMatrix
 * 之字形打印矩阵
 * 【题目】
 * 给定一个矩阵matrix，按照“之”字形的方式打印这个矩阵，例如：
 * 1 2 3 4
 * 5 6 7 8
 * 9 10 11 12
 * “之”字形打印的结果为：1，2，5，9，6，3，4，7，10，11，8，12
 * 【要求】
 * 额外空间复杂度为O(1)。
 *
 * @author Daydreamer
 * @date 2018/3/30 16:48
 */
public class ZigZagPrintMatrix {
    public static void printMatrixZigZag(int[][] matrix) {
        int r1 = 0;
        int r2 = 0;
        int c1 = 0;
        int c2 = 0;
        int endr = matrix.length - 1;
        int endc = matrix[0].length - 1;
        //刚开始是左下往右上
        boolean fromUp = false;
        //控制r1越界
        while (r1 != endr + 1) {
            printLevel(matrix, r1, r2, c1, c2, fromUp);
            //没越界则一直往左下走
            //c1到最后一列的时候r1增加
            r1 = c1 == endc ? r1 + 1 : r1;
            c1 = c1 == endc ? c1 : c1 + 1;
            c2 = r2 == endr ? c2 + 1 : c2;
            r2 = r2 == endr ? r2 : r2 + 1;
            fromUp = !fromUp;
        }
        System.out.println();
    }

    //fromUp变量控制方向，true则右上往左下移。
    // 打印对角线
    public static void printLevel(int[][] arr, int r1, int r2, int c1, int c2, boolean fromUp) {
        if (fromUp) {//右上往左下移
            while (r1 <= r2) {
                System.out.print(arr[r1++][c1--] + " ");
            }
        } else {//左下往右上移
            while (c2 < c1) {
                System.out.print(arr[r2--][c2++] + " ");
            }
        }
    }
}
