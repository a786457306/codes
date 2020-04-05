package com.zzw.algorithm.linkedlist_stack_queue;

/**
 * SmallEqualBigger
 * 将单向链表按某值划分成左边小、中间相等、右边大的形式
 * 【题目】
 * 给定一个单向链表的头节点head，节点的值类型是整型，再给定一个整数pivot。
 * 实现一个调整链表的函数，将链表调整为左部分都是值小于pivot的节点，中间部
 * 分都是值等于pivot的节点，右部分都是值大于pivot的节点。除这个要求外，对
 * 调整后的节点顺序没有更多的要求。
 * 例如：链表9->0->4->5->1，pivot=3。
 * 调整后链表可以是1->0->4->9->5，也可以是0->1->9->5->4。总之，满足左部
 * 分都是小于3的节点，中间部分都是等于3的节点（本例中这个部分为空），右部分
 * 都是大于3的节点即可。对某部分内部的节点顺序不做要求。
 *
 * @author Daydreamer
 * @date 2018/4/3 16:42
 */
public class SmallEqualBigger {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    //将链表全部存入数组，排好序再链回来
    public static Node listPartition1(Node head, int pivot) {
        if (head == null) {
            return head;
        }
        Node cur = head;
        int i = 0;
        while (cur != null) {
            i++;
            cur = cur.next;
        }
        Node[] nodeArr = new Node[i];
        i = 0;
        cur = head;
        for (i = 0; i != nodeArr.length; i++) {
            nodeArr[i] = cur;
            cur = cur.next;
        }
        arrPartition(nodeArr, pivot);
        for (i = 1; i != nodeArr.length; i++) {
            nodeArr[i - 1].next = nodeArr[i];
        }
        nodeArr[i - 1].next = null;
        return nodeArr[0];
    }

    //给链表数组排序（分区），思想同快排
    public static void arrPartition(Node[] arr, int pivot) {
        int small = -1;
        int index = 0;
        int high = arr.length;
        while (index != high) {
            if (arr[index].value < pivot) {
                swap(arr, ++small, index++);
            } else if (arr[index].value > pivot) {
                swap(arr, --high, index);
            } else {
                index++;
            }
        }
    }

    public static void swap(Node[] nodeArr, int a, int b) {
        Node tmp = nodeArr[a];
        nodeArr[a] = nodeArr[b];
        nodeArr[b] = tmp;
    }

    //第二种方法，空间复杂度为O(1)
    public static Node listPartition2(Node head, int pivot) {
        Node sH = null; // small head
        Node sT = null; // small tail
        Node eH = null; // equal head
        Node eT = null; // equal tail
        Node bH = null; // big head
        Node bT = null; // big tail
        Node next = null; // save next node
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.value < pivot) {
                if (sH == null) {//为空时也要处理，万一没有节点连在上面
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }
            } else if (head.value == pivot) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = head;
                }
            } else {
                if (bH == null) {
                    bH = head;
                    bT = head;
                } else {
                    bT.next = head;
                    bT = head;
                }
            }
            head = next;
        }
        if (sT != null) {//小于和等于连起来
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        if (eT != null) {
            eT.next = bH;//等于和大于连起来
        }
        return sH != null ? sH : eH != null ? eH : bH;//为空的就不返回
    }
}
