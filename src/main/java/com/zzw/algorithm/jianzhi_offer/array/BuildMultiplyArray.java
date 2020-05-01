package com.zzw.algorithm.jianzhi_offer.array;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素 B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * 注意：
 * 规定B[0] = A[1] * A[2] * ... * A[n-1]，
 * B[n-1] = A[0] * A[1] * ... * A[n-2];
 */
public class BuildMultiplyArray {

    /**
     * 第一种解法：
     * 比较傻，遍历相乘，把相等的元素跳过。
     *
     * @param A
     * @return
     */
    public int[] multiplyTraversal(int[] A) {
        if (A == null || A.length == 0) {
            return A;
        }
        int length = A.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            int res = 1;
            for (int j = 0; j < length; j++) {
                if (i == j) {
                    continue;
                }
                res *= A[j];
            }
            result[i] = res;
        }
        return result;
    }

    /**
     * 第二种解法：
     * 根据上下三角计算
     * A值为x轴，B值为y轴，画图得到，B值为除对称点外每行乘积
     * 上下三角分别计算得结果
     * 计算三角乘积时需先计算某一边乘积，再与已有结果相乘，否则只是一个值的乘积
     *
     * @param A
     * @return
     */
    public int[] multiplyTriangle(int[] A) {
        if (A == null || A.length == 0) {
            return A;
        }
        int length = A.length;
        int[] result = new int[length];
        // 下三角
        result[0] = 1;
        for (int i = 1; i < length; i++) {
            // 上一行的乘积 * 新值
            result[i] = result[i - 1] * A[i - 1];
        }
        // 上三角
        int temp = 1;
        for (int i = length - 2; i >= 0; i--) {
            temp *= A[i + 1];
            result[i] *= temp;
        }
        return result;
    }
}
