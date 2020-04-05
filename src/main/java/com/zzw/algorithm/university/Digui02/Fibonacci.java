package com.zzw.algorithm.university.Digui02;

/**
 * Fibonaccci
 * 另一个斐波那契数列，F(0)=7,F(1)=11,F(n)=F(n-1)+F(n-2)，（n≥2）
 * 对输入文件中的每个整数n，如果F(n)能被3整除，输出yes，否则输出no
 *
 * @author Daydreamer
 * @date 2017/9/21 21:51
 */
import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int num = sc.nextInt();
            System.out.println(getRemainder(num));
        }
    }

    public static String getRemainder(int num) {
        int f = fibonacci(num);
        if (f % 3 == 0){
            return "yes";
        }else{
            return "no";
        }
    }

    public static int fibonacci(int num) {
        if (num == 0){
            return 7;
        } else if (num == 1){
            return 11;
        } else {
            return fibonacci(num - 1) + fibonacci(num - 2);
        }
    }
}

