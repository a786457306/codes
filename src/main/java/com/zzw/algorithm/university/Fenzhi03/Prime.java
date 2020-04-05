package com.zzw.algorithm.university.Fenzhi03;

import java.util.Scanner;

/**
 * Prime
 * 半素数
 * 素数的定义：对于一个大于１的正整数，如果除了１和它本身没有其他的正约数了，那么这个数就称为素数。
 * 半素数的定义：对于一个大于1的正整数，如果它可以被分解成2个素数的乘积，则称该数为半素数。
 * 判断一个数是否是半素数。
 *
 * @author Daydreamer
 * @date 2017/10/7 23:02
 */

public class Prime{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long m = 0;
        while(sc.hasNext()){
            m = sc.nextLong();
            if(isSemiPrime(m))
                System.out.println("Yes");
            else
                System.out.println("No");
        }
        sc.close();
    }

    public static boolean isPrime(long num){
        for(int i = 2; i <= Math.sqrt((double)num); i++){//判断num是不是素数，找它的因子
            if(num % i == 0)
                return false;
        }
        return true;
    }

    public static boolean isSemiPrime(long m){
        for(int i = 2; i <= Math.sqrt((double)m); i++){
            if(m % i == 0){
                long t = m/i;
                return isPrime(i)&&isPrime(t);
            }
        }
        return false;
    }
}