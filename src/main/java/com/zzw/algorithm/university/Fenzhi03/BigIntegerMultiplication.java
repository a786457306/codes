package com.zzw.algorithm.university.Fenzhi03;

import java.util.Scanner;

/**
 * BigIntegerMultiplication
 * 大整数乘法
 * 求两个不超过200位的非负整数的积。
 * 有两行，每行是一个不超过200位的非负整数，没有多余的前导0。
 * 输出一行，即相乘后的结果。结果里不能有多余的前导0，即如果结果是342，那么就不能输出为0342。
 *
 * @author Daydreamer
 * @date 2017/10/6 20:06
 */
public class BigIntegerMultiplication {

        public static void main(String[] args){
            Scanner scan = new Scanner(System.in);
            while(scan.hasNext()) {
                String a = scan.nextLine();
                String b = scan.nextLine();
                System.out.println(calculate(a, b));
            }
        }

        public static String calculate(String a, String b){
            //字符串转成数组
            char[] chara = a.toCharArray();
            char[] charb = b.toCharArray();
            //存放结果与乘积的int型数组
            int[] ca = new int[chara.length];
            int[] cb = new int[charb.length];
            int[] res = new int[chara.length + charb.length];
            //char转成int数组
            for (int i = 0; i < chara.length; i++){
                ca[i] = chara[i] - '0';//把大整数a存入int数组中
            }
            for (int i = 0; i < charb.length; i++){
                cb[i] = charb[i] - '0';//把大整数b存入int数组中
            }

            for (int i = 0; i < ca.length; i++){
                for (int j = 0; j < cb.length; j++){
                    res[i+j] += ca[i]*cb[j];
                }
            }
            for (int i = res.length-1; i > 0; i--){
                    res[i-1] += (res[i] / 10);
                    res[i] = res[i] % 10;
            }

            String result = "";
            boolean f = false;
            for (int i = 0; i < res.length - 1; i++) {
                if (res[i] != 0) {
                    f = true;
                }
                if (!f){
                    result = "0";
                    return result;
                }
                if (f){
                    result += "" + res[i];
                }
            }
            return result;
        }

    }

//import java.utils.Scanner;
//
//public class Main{
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            System.out.println(execute(sc.nextLine(),sc.nextLine()));
//        }
//    }
//    public static String execute(String bigNum1,String bigNum2){
//
//        if(bigNum1=="0"||bigNum2=="0"){
//            return "0";
//        }
//
//        char[] num1 =new StringBuffer(bigNum1).reverse().toString().toCharArray();
//        char[] num2 =new StringBuffer(bigNum2).reverse().toString().toCharArray();
//
//        int resultLen = num1.length+num2.length;
//        int[] result = new int[resultLen];
//
//        for(int j=0;j<num1.length;j++){
//            for(int i=0;i<num2.length;i++){
//                result[i+j] += (int)(num1[j]-'0')*(int)(num2[i]-'0');
//            }
//        }
//
//        for(int i=0;i<resultLen-1;i++){
//            result[i+1] += result[i]/10;
//            result[i] = result[i]%10;
//        }
//
//        StringBuffer resultStr = new StringBuffer();
//        for(int i=resultLen-1;i>=0;i--){
//            resultStr.append(result[i]);
//        }
//
//        return resultStr.toString();
//    }
//}
