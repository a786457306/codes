package com.zzw.algorithm.jianzhi_offer.string;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class ReplaceSpace {

    /**
     * 第一种方法：
     * 使用额外StringBuffer替换空格
     *
     * @param str
     * @return
     */
    public static String replaceSpaceUseExtraBuffer(StringBuffer str) {
        if (str == null) {
            return "";
        }
        StringBuffer temp = new StringBuffer();
        int length = str.toString().length();
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) != ' ') {
                temp.append(str.charAt(i));
            } else {
                temp.append("%20");
            }
        }
        return temp.toString();
    }

    /**
     * 第二种解法：
     * 不使用额外数据结构，单纯移动字符
     * 从后往前移动，这样移动元素的次数更少
     * 1. 找空格个数，计算替换后的字符串长度
     * 2. 从后往前替换空格
     *
     * @param str
     * @return
     */
    public static String replaceSpaceMovingElement(StringBuffer str) {
        if (str == null) {
            return "";
        }
        int spaceNum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                spaceNum++;
            }
        }
        int indexOld = str.length() - 1;
        int length = str.length() + spaceNum * 2 ;
        int indexNew = length - 1;
        str.setLength(length);
        for (; indexOld >= 0 && indexOld < length; indexOld--) {
            if (str.charAt(indexOld) == ' ') {
                str.setCharAt(indexNew--, '0');
                str.setCharAt(indexNew--, '2');
                str.setCharAt(indexNew--, '%');
            } else {
                str.setCharAt(indexNew--, str.charAt(indexOld));
            }
        }
        return str.toString();
    }
}
