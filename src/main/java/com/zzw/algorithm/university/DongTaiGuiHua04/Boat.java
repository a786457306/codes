package com.zzw.algorithm.university.DongTaiGuiHua04;

import java.util.Scanner;

/**
 * Boat
 *
 * 租用游艇
 * 长江游艇俱乐部在长江上设置了n个游艇出租站1,2，...，n。
 * 游客可在这些游艇出租站租用游艇，并在下游的任何一个游艇出租站归还游艇。
 * 游艇出租站i到游艇出租站j之间的租金为r(i,j),1<=i<j<=n。
 * 计算从游艇出租站1到游艇出租站n所需的最少租金。
 *
 * @author Daydreamer
 * @date 2017/10/23 22:35
 */

public class Boat{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[][] arr = new int[n+1][n+1];
            for (int i = 1; i < n; i++) {
                for (int j = i + 1; j <= n; j++)
                    arr[i][j] = sc.nextInt();
            }
            System.out.println(execute(n, arr));
        }
    }
    public static int execute(int n, int[][] arr) {
        for(int k = 2; k < n; k++){
            for(int i = 1;i <= n-k; i++){
                int j = i+k;
                for(int z = i+1; z <= j; z++){
                    int temp = arr[i][z] + arr[z][j];
                    if(arr[i][j] > temp)
                        arr[i][j] = temp;
                }
            }
        }
        return arr[1][n];
    }
}
