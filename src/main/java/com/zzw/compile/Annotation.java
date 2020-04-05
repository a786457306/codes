package com.zzw.compile;

import java.util.Scanner;

public class Annotation {

    public static void main(String[] args){
        System.out.println("输入字符串：");
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String str = scan.nextLine();
            System.out.println(check(str));
        }
        scan.close();
    }

    public static String check(String input){
        int state = 1;
        String str = input;
        int length = str.length();
        char[] c = new char[length];
        if (c == null){
            state = 6;
        }

        for (int i = 0; i < length; i ++){
            c[i] = str.charAt(i);
            if (state == 6){
                break;
            }
            switch (state){
                case 1:
                    if (c[i] == '/'){
                        state = 2;
                    }else {
                        state = 6;
                    }
                    break;
                case 2:
                    if (c[i] == '*'){
                        state = 3;
                    }else {
                        state = 6;
                    }
                    break;
                case 3:
                    if (c[i] == '*'){
                        state = 4;
                    }else {
                        state = 3;
                    }
                    break;
                case 4:
                    if (c[i] == '/'){
                        state = 5;
                    }else if (c[i] == '*'){
                        state = 4;
                    }else {
                        state = 3;
                    }
                    break;
            }
        }
        if (state == 5){
            return "输入的是注释！";
        }else{
            return "输入的不是注释！";
        }
    }
}
