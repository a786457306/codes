package com.zzw.algorithm.university.Digui02;

/**
 * BinaryTree
 *
 * @author Daydreamer
 * @date 2017/9/21 21:57
 */
import java.util.Scanner;

public class BinaryTree {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()){
            int x = scan.nextInt();
            int y = scan.nextInt();
            System.out.println(calculate(x,y));
        }
    }

    public static int calculate(int x,int y){

        if (x == y)
            return x;
        else if(x < y)
            return calculate(x,y/2);
        else
            return calculate(x/2,y);
    }
}