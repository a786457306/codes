package com.zzw.algorithm.jianzhi_offer.day03;

import com.zzw.algorithm.jianzhi_offer.day01.ListNode;

/**
 * ReverseLinkedList
 *
 * 题目：
 * 定义一个函数，输入一个链表的头结点，
 * 反转该链表并输出反转后链表的头结点。
 *
 * @author Daydreamer
 * @date 2018/8/22 20:24
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode second = new ListNode();
        ListNode third = new ListNode();
        ListNode forth = new ListNode();
        head.next = second;
        second.next = third;
        third.next = forth;
        head.data = 1;
        second.data = 2;
        third.data = 3;
        forth.data = 4;
        ReverseLinkedList test = new ReverseLinkedList();
        ListNode resultListNode = test.reverseList(head);
        System.out.println(resultListNode.data);
    }

    public ListNode reverseList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode nex = null;

        while (cur.next != null){
            nex = cur.next;
            nex.next = pre;
            pre = cur;
            cur = nex;
        }
        return cur;
    }

}
