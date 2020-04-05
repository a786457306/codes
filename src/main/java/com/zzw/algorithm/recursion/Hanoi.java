package com.zzw.algorithm.recursion;

/**
 * Hanoi
 *
 * @author Daydreamer
 * @date 2018/4/12 11:08
 */
public class Hanoi {

    public static void hanoi(int n){
        if (n > 0){
            func(n, "left", "right", "mid");
        }
    }

    //把1到n从from移动到to上去，中间需要help协助
    public static void func(int n, String from, String to, String help){
        if (n == 1){ // basecase
            System.out.println("move " + 1 + " from " + from + " to " + to);
        } else {
            func(n - 1, from, help, to);//1到n-1从from挪到help上去，借助to，再挪n
            System.out.println("move " + n + " from " + from + " to " + to);//把n单独从from挪到to
            func(n - 1, help, to, from);//1到n-1从help挪到to上，中间借助from
        }
    }

    public static void main(String[] args) {
        hanoi(3);
    }
}
