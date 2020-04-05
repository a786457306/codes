package com.zzw.algorithm.linkedlist_stack_queue;

/**
 * PrintCommonPart
 * 【题目】
 * 给定两个有序链表的头指针head1和head2，打印两个链表的公共部分。
 * 【思路】
 * 两个指针指向两个链表，哪个元素小哪个后移，相等时输出并同时后移。
 *
 * @author Daydreamer
 * @date 2018/3/30 18:59
 */
public class PrintCommonPart {
    public class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void printCommonPart(Node head1, Node head2) {
        while (head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                head1 = head1.next;
            } else if (head1.value > head2.value) {
                head2 = head2.next;
            } else {
                System.out.println(head1.value);
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        System.out.println();
    }
}
