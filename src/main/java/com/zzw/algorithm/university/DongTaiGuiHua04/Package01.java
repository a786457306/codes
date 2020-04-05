package com.zzw.algorithm.university.DongTaiGuiHua04;

/**
 * Package01
 *
 * 某工厂预计明年有A、B、C、D四个新建项目，每个项目的投资额Wk及其投资后的收益Vk如下表所示，
 * 投资总额为30万元，如何选择项目才能使总收益最大？
 * Project   Wk   Vk
 *   A       15   12
 *   B       10   8
 *   C       12   9
 *   D       8    5
 *
 * @author Daydreamer
 * @date 2017/12/23 9:40
 */
public class Package01 {
    static int N = 150;
    static int[] v = {0,12,8,9,5};
    static int[] w = {0,15,10,12,8};
    static int[] x;
    static int[] m[][];
    static int c = 30;
    static int n = 4;

    public static void main(String[] args){

    }

    public static void traceback(){
        for (int i = n; i >= 0; i--){
            if (m[i][c] == m[i-1][c]){
                x[i] = 0;
            }else{
                x[i] = 0;
                c -= w[i];
            }
        }
//        x[1]=((m[1][c]) > 0)?1:0;
    }
}
