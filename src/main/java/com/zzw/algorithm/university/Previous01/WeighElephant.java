package com.zzw.algorithm.university.Previous01;

/**
 * WeighElephant
 * 曹冲称象：实际就是求一堆数的和
 *
 * @author Daydreamer
 * @date 2017/9/21 21:44
 */

import java.util.Scanner;

public class WeighElephant {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int num = scan.nextInt();
            int[] each = new int[num];
            int sum = 0;
            for(int i = 0;i < num;i++){
                each[i] = scan.nextInt();
                sum = sum + each[i];
            }
            System.out.println(sum);
        }
    }
}