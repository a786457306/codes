package com.zzw.algorithm.jianzhi_offer.string;

public class MatchPattern {

    public static boolean match(char[] str, char[] pattern)
    {
        if (str == null || pattern == null) {
            return false;
        }
        int strLen = str.length;
        int patternLen = pattern.length;
        if (strLen == 0 && patternLen == 0) {
            return true;
        }
        if (strLen == 0 || patternLen == 0) {
            return false;
        }
        int i = strLen - 1;
        int j = patternLen - 1;
        while(i >= 0 && j >= 0) {
            if (str[i] == pattern[j]) {
                i--;
                j--;
                continue;
            } else if (pattern[j] == '.') {
                i--;
                j--;
                continue;
            } else if (pattern[j] == '*') {
                j--;
                while (str[i] == pattern[j]) {
                    i--;
                }
                j--;
                continue;
            }
            if (str[i] != pattern[j]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[] str = "aaa".toCharArray();
        char[] pattern = "ab*ac*a".toCharArray();
        match(str, pattern);
    }
}
