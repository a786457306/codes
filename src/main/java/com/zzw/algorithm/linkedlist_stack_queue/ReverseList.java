package com.zzw.algorithm.linkedlist_stack_queue;

/**
 * ReverseList
 * 反转单向和双向链表
 * 【题目】
 * 分别实现反转单向链表和反转双向链表的函数。
 * 【要求】
 * 如果链表长度为N，时间复杂度要求为O(N)，额外空间复杂度要求为O(1)
 *
 * @author Daydreamer
 * @date 2018/4/5 21:01
 */
public class ReverseList {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node reverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node next = null;
        Node pre = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static class DoubleNode {
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int data) {
            this.value = data;
        }
    }

    public static DoubleNode doubleReverse(DoubleNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.last = next;
            head.next = pre;
            pre = head.last;
            head = next;
        }
        return pre;
    }
}
