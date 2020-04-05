package com.zzw.algorithm.university.Previous01;

/**
 * Square
 * 平方和有几种表示方法
 *
 * @author Daydreamer
 * @date 2017/9/21 21:42
 */

import java.util.Scanner;

public class Square {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();// num：输入样例个数
        for (int i = 0; i < num; i++) {
            System.out.println(input(sc.nextInt()));
        }
    }

    /**
     * 从大数往小数遍历，
     * i到k从大到小。
     * i = 0, j = 0, k = 3, g = 4
     * i = 1, j = 2, k = 3, g = 4
     * i = 5, j = 0, k = 0, g = 0
     *
     * @param m
     * @return
     */

    public static int input(int m) {// m：输入的数字
        int limit = (int) Math.sqrt(m) + 1;//最大不超过limit
        int count = 0;
        for (int i = 0; i < limit; i++){
            for (int j = i; j < limit; j++){
                for (int k = j; k < limit; k++){//从头遍历
                    int h = m - i * i - j * j - k * k;
                    int g = (int)(Math.sqrt(h));//剩下的数是整数的平方
                    if(g * g == h && g >= k) {//该数大于等于k则不会出现重复数据
                         count++;
                    }
                }
            }
        }
        return count;
    }
}