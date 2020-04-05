package com.zzw.algorithm.jianzhi_offer.day01;

import java.util.Stack;

/**
 * PrintListReverse1
 *
 * 从尾到头打印链表--非递归，栈
 *
 * @author Daydreamer
 * @date 2018/8/20 22:06
 */
public class PrintListReverse1 {

    public static void printListReverse(ListNode headNode){
        Stack<ListNode> stack = new Stack<>();
        while (headNode != null){
            stack.push(headNode);
            headNode = headNode.next;
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop().data);
        }
    }
}
