package com.zzw.algorithm.recursion;

/**
 * PrintAllSubsequences
 * 打印字符串的全部子序列，包括空串
 *
 * @author Daydreamer
 * @date 2018/4/12 14:47
 */
public class PrintAllSubsequences {

    public static void printAllSub(String str){
        char[] chs = str.toCharArray();
        f(chs, 0, "");
        System.out.println("");
    }

    //pre：已经形成的字符串.
    //index：当前字符，可选可不选，index之后的随意选
    public static void f(char[] chs, int index, String pre){
        if (index == chs.length){
            if (!pre.equals("")){
                System.out.println(pre);//第一步到这时打印abc
            }
            return;
        }
        f(chs, index + 1, pre + String.valueOf(chs[index]));//打印pre加后面任意一个字符
        f(chs, index + 1, pre);//打印pre
    }

    public static void main(String[] args) {
        printAllSub("abc");
    }
}
