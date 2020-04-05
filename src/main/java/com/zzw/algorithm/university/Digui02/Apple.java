package com.zzw.algorithm.university.Digui02;

/**
 * Apple
 *
 * 放苹果
 * 把M个同样的苹果放在N个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的分法（用K表示）？
 * 注意：5，1，1和1，5，1 是同一种分法。
 *
 * 第一行是测试数据的数目t（0 <= t <= 20）。以下每行均包含二个整数M和N，以空格分开。1<=M，N<=10。
 * 对输入的每组数据M和N，用一行输出相应的K。
 *
 * Author： Daydreamer
 * Date: 2017/9/22
 * Time: 9:32
 */

import java.util.Scanner;

public class Apple {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        for (int t = 0; t < scan.nextInt(); t++){
            int M = scan.nextInt();
            int N = scan.nextInt();
            System.out.println(calculate(M,N));
        }
    }

    public static int calculate(int m, int n){
        //不对呗
        if(m < 0){
            return 0;
        }
        //0个苹果或者1个盘子：只有一种方法
        if (m == 0 || n == 1){
            return 1;
        }
        //m>n：m个苹果放入n个盘子与m-n个苹果放入n个盘子方法数相同。calculate(m-n, n)
        //有空盘子，则m个苹果放入n个盘子与m个苹果放入n-1个盘子结果相同，calculate(m, n-1)
        return calculate(m - n, n) + calculate(m, n - 1);
    }
}