package com.zzw.compile;

import java.io.BufferedReader;
import java.io.FileReader;


public class C0{
	
    /**
     *  state=1:运算符
	 *  state=2:标识符
	 *  state=3:数字
	 *  state=4:保留字
	 *  state=5:界符
	 */

    //关键字
    private static String[] keyword = { "read", "write", "boolean", "byte", "char", "double", "false", "float", "int", "long",
                    "enums ", "short ", "signed", "struct", "union", "unsigned", "void ", "goto",
                    "case", "switch", "default", "continue", "break", "for", "do ", "return ",
                    "out", "system", "main"
            };

    //暂存数据
    static String string;

    //状态码
    static int state = 0;

    /**
     * 是否是数字
     * @param ch
     * @return
     */

    public static boolean isDigit(char ch){
        if (ch >= '0' && ch <= '9'){
            return true;
        } else
            return false;
    }

    /**
     * 是否是正整数
     * @param ch
     * @return
     */

    public static boolean isNZDigit(char ch){
        if (ch >'0' && ch <= '9'){
            return true;
        } else
            return false;
    }

    /**
     * 是否是字母
     * @param ch
     * @return
     */

    public static boolean isLetter(char ch){
        if ((ch >= 'a' && ch <= 'z') || (ch > +'A' && ch <= 'Z')){
            return true;
        } else
            return false;
    }

    /**
     * 是否是关键字
     * @param str
     * @return
     */

    public static boolean isKeyword(String str){
        int flag = 0;
        for (int i = 0; i < keyword.length; i++){
            if (str.equals(keyword[i])){
                flag = 1;
                break;
            }
        }
        if (flag == 1){
            return true;
        }
        return false;
    }

    /**
     * 是否是运算符
     * @param ch
     * @return
     */

    public static boolean isOperator(char ch){
        if (ch == '+' || ch == '-' || ch == '*' || ch == '/'
                || ch == '=' || ch == '>' || ch == '<' || ch == '!'
                || ch == '%' || ch == '|'){
            return true;
        } else
            return false;
    }

    public static void scanner() throws Exception{
        char ch;
        int i;
        String str = null;
        for (i = 0; i < string.length(); i++){
            switch (state){
                //初始状态
                case 0:
                    ch = string.charAt(i);
                    // 判断是否为运算符，是就存
                    if (isOperator(ch)){
                        str = "";
                        str += ch;
                        ch = string.charAt(i++);
                        // 对下一个字符进行判断，是否为运算符
                        if (ch == '+' || ch == '-' ||ch == '=' || ch == '&'|| ch == '|'){
                            str += ch;
                            state = 1;
                            i++;
                        } else {
                            ch = string.charAt(i - 1);
                            state = 1;
                        }
                    }
                    // 判断是否为界符
                    else if (ch == ';' || ch == ',' || ch == '(' || ch == ')'
                            || ch == '{' || ch == '}'){
                        System.out.println(" other " + " : " + ch);
                    }
                    // 判断是否为标识符
                    else if (isLetter(ch = string.charAt(i))){
                        str = "";
                        str += ch;
                        state = 2;
                    }
                    // 判断是否为数字
                    else if (isNZDigit((ch = string.charAt(i)))){
                        str = "";
                        str += ch;
                        state = 3;
                        i++;
                        if (isDigit((ch = string.charAt(i)))){
                            state = 3;
                            str += ch;
                        }else{
                            i--;
                            state = 3;
                        }
                    }
                    break;

                case 1:
                    i--;
                    System.out.println(" operator " + " : " + str);
                    state = 0;
                    break;

                case 2:
                    if (isLetter(ch = string.charAt(i))){
                        str += ch;
                        i++;
                        while (isDigit(ch = string.charAt(i)) || isLetter(ch = string.charAt(i))){
                            str += ch;
                            i++;
                        }
                        i--;
                        System.out.println(" identifier " + " : " + str );
                    } else {
                        if (isKeyword(str)){
                            System.out.println(" keyword " + " : " + str);
                        }
                        i--;
                        state = 0;
                    }
                    break;


                case 3:
                    i--;
                    System.out.println(" number " + " : " + str);
                    state = 0;
                    break;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader("F:\\text.txt");
        BufferedReader br = new BufferedReader(fr);
        while ((string = br.readLine()) != null){
            scanner();
        }
    }
}