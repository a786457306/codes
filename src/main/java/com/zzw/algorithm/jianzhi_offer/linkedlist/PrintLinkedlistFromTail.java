package com.zzw.algorithm.jianzhi_offer.linkedlist;

import com.zzw.algorithm.jianzhi_offer.day01.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
public class PrintLinkedlistFromTail {

    /**
     * 第一种方法：
     * 利用栈先进后出特点
     *
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHeadUsingStack(ListNode listNode) {

        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> tempStack = new Stack<>();

        while (listNode != null) {
            tempStack.push(listNode.data);
            listNode = listNode.next;
        }

        while (!tempStack.isEmpty()) {
            result.add(tempStack.pop());
        }

        return result;

    }

    /**
     * 第二种方法：
     * 使用递归
     * 找到最后一个节点时，存入数组，递归返回，挨个存储。
     *
     * @param listNode
     * @return
     */
    ArrayList<Integer> result = new ArrayList<>();

    public ArrayList<Integer> printListFromTailToHeadRecurrence(ListNode listNode) {

        if (listNode != null) {
            printListFromTailToHeadRecurrence(listNode.next);
            result.add(listNode.data);
        }

        return result;
    }
}

/**
 *    public class ListNode {
 *        int val;
 *        ListNode next = null;
 *
 *        ListNode(int val) {
 *            this.val = val;
 *        }
 *    }
 *
 */
