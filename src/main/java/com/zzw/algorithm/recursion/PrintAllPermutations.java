package com.zzw.algorithm.recursion;

import java.util.HashSet;

/**
 * PrintAllPermutations
 *
 * @author Daydreamer
 * @date 2018/4/12 15:40
 */
public class PrintAllPermutations {
    //0到i-1位置的字符固定，i之后的字符自由变换
    public static void process1(char[] chs, int i){
        if (i == chs.length){
            System.out.println(String.valueOf(chs));
        }
        //每个当前字符都试验所有可能性
        for (int j = i; j < chs.length; j++){
            swap(chs, i, j);//自己跟自己换
            process1(chs, i+1);//i+1之后的字符自由变换
        }
    }

    public static void swap(char[] chs, int i, int j){
        char temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
    }

    public static void process2(char[] chs, int i){
        if (i == chs.length){
            System.out.println(String.valueOf(chs));
        }
        HashSet<Character> set = new HashSet<>();
        for (int j = i; j < chs.length; j++){
            if (!set.contains(chs[j])){
                set.add(chs[j]);
                swap(chs, i, j);
                process2(chs, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        String s = "acc";
        char[] c = s.toCharArray();
        process1(c, 0);
        process2(c, 0);
    }
}
