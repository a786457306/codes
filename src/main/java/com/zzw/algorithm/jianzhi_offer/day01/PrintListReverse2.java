package com.zzw.algorithm.jianzhi_offer.day01;

/**
 * PrintListReverse2
 * 递归
 *
 * @author Daydreamer
 * @date 2018/8/20 22:13
 */
public class PrintListReverse2 {

    public static void printListReverse(ListNode headNode){
        if (headNode != null) {
            if (headNode.next != null) {
                printListReverse(headNode.next);
            }
        }
        System.out.println(headNode.data);
    }
}
