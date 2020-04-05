package com.zzw.algorithm.jianzhi_offer.day01;

/**
 * ReplaceBlank
 *
 * 题目：请实现一个函数，把字符串中的每个空格替换成“%20”。
 *
 * 思路：用StringBuffer
 *
 * @author Daydreamer
 * @date 2018/8/20 21:55
 */
public class ReplaceBlank {
    public static void main(String args[]){
        String s="We are happy.";
        System.out.println(replaceBlank(s));
    }

    public static String replaceBlank(String str){
        if (str == null || str == ""){
            return str;
        }
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == ' '){
                res.append("%");
                res.append("2");
                res.append("0");
            }else {
                res.append(String.valueOf(str.charAt(i)));
            }
        }
        return res.toString();
    }
}
