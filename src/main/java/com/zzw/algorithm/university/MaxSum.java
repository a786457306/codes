package com.zzw.algorithm.university;

import java.util.Scanner;

/**
 * MaxSum
 *
 * ���ȣ��ö�ά����������������.
 * Ȼ����D( r, j) ����ʾ��r�е� j ������(r,j��1��ʼ��)
 * ��MaxSum(r, j)��ʾ��D(r,j)���ױߵĸ���·���У����·��������֮�͡�
 * ��ˣ��������������ͱ������ MaxSum(1,1)
 * �����ǿ��������Ŀ��ʱ�������뵽�ľ��ǿ����ü򵥵ĵݹ�������
 * D(r, j)��������һ��ֻ����D(r+1,j)����D(r+1, j+1)��
 * N�е�������.
 *
 * Author�� Daydreamer
 * Date: 2017/10/24
 * Time: 16:10
 */

public class MaxSum {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int r = 0; r < n; r++){
            for (int j = 0; j < r; j++){

            }
        }
    }

    public static int maxSum(int i, int j){
        int[][] D = new int[10][10];
        int n = 0;
        if (i == n)
            return D[i][j];
        int x = maxSum(i+1,j);
        int y = maxSum(i+1,j+1);
        return max(x,y)+D[i][j];
    }

    public static int max(int x, int y){
        if (x >= y){
            return x;
        }else
            return y;
    }
}
