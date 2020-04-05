package com.zzw.algorithm.university.Digui02;

/**
 * Bolan
 *
 * 波兰表达式是一种把运算符前置的算术表达式，
 * 例如普通的表达式2 + 3的波兰表示法为+ 2 3。
 * 波兰表达式的优点是运算符之间不必有优先级关系，也不必用括号改变运算次序，
 * 例如(2 + 3) * 4的波兰表示法为* + 2 3 4。
 * 本题求解波兰表达式的值，其中运算符包括+ - * /四个。
 *
 * 输入为一行，其中运算符和运算数之间都用空格分隔，运算数是浮点数
 * 输出为一行，表达式的值
 *
 * @author Daydreamer
 * @date 2017/9/21 21:51
 */


import java.text.DecimalFormat;
import java.util.Scanner;

public class Bolan {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        while (sc.hasNext()){
            float a = calculate();
            DecimalFormat decimalFormat = new DecimalFormat(".000000");
            String res = decimalFormat.format(a);
            System.out.println(res);
        }
    }

    public static float calculate(){
        String input = sc.next();//用空格分开
        if (input.equals("+")){
            return calculate() + calculate();
        }else if (input.equals("-")){
            return calculate() - calculate();
        }else if (input.equals("*")){
            return calculate() * calculate();
        }else if (input.equals("/")){
            return calculate() / calculate();
        }else
            return Float.valueOf(input);
    }
}