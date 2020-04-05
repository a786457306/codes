package com.zzw.algorithm.university.Previous01;

/**
 * AAddsB
 * 求A+B
 *
 * @author Daydreamer
 * @date 2017/9/21 21:45
 */
import java.util.Scanner;

public class AAddsB {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int a;
        int b;
        while(scan.hasNext()){
            a = scan.nextInt();
            b = scan.nextInt();
            System.out.println(a+b);
        }
    }
}


