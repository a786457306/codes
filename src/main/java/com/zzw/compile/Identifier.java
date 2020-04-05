package com.zzw.compile;

import java.util.Scanner;

public class Identifier {
    public static void main(String[] args){
        System.out.println("输入字符串：");
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String str = scan.nextLine();
            System.out.println(loop(str));
        }
        scan.close();
    }

    static String loop(String input) {
        int state = 1;//初始状态为1
        int i = 0;
        String str = input;//输入的字符串
        char a;//字符
        int length = str.length();//输入字符串长度
        if (i < length) {
            a = str.charAt(i);
            i++;
            if (a >= 'a' && a <= 'z') {//state1处是字母
                state = 2;
            } else {
                state = 4;
            }
        }

        while (state == 2){
            if (i < length) {
                a = str.charAt(i);
                i++;
                if (a >= 'a' && a <= 'z' || a >= '0' && a <= '9') {//state2是字母或数字
                    state = 3;
                } else {
                    state = 4;
                }
            }

        }
        if (state == 3){
            return "输入正确！";
        }else if (state == 4){
            return "输入错误！";
        }
        return "输入正确！";
    }

}
