package com.zzw.compile;

import java.util.Scanner;

/**
 * divide5
 *
 * @author Daydreamer
 * @date 2017/9/19 22:26
 */
public class Divide5 {

    public static void main(String[] args) {
        System.out.println("输入二进制数串：");
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String input = scan.nextLine();
            System.out.println(calculate(input));
        }
        scan.close();
    }

    public static String calculate(String str) {
        int state = 0;
        char c;
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            switch (state) {
                case 0:
                    if (c == '0') {
                        state = 0;
                        break;
                    } else if (c == '1') {
                        state = 1;
                        break;
                    } else {
                        state = -1;
                        break;
                    }

                case 1:
                    if (c == '0') {
                        state = 2;
                        break;
                    } else if (c == '1') {
                        state = 3;
                        break;
                    } else {
                        state = -1;
                        break;
                    }

                case 2:
                    if (c == '0') {
                        state = 4;
                        break;
                    } else if (c == '1') {
                        state = 0;
                        break;
                    } else {
                        state = -1;
                        break;
                    }

                case 3:
                    if (c == '0') {
                        state = 1;
                        break;
                    }else if(c == '1'){
                        state = 2;
                        break;
                    }else{
                        state = -1;
                        break;
                    }
                case 4:
                    if(c == '0'){
                        state = 3;
                        break;
                    }else if(c == '1'){
                        state = 4;
                        break;
                    }else{
                        state = -1;
                        break;
                    }
            }
        }

        if (state == 0) {
            return "可以被5整除";
        } else {
            return "不能被5整除";
        }
    }
}
