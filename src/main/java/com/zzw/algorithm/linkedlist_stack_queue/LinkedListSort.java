package com.zzw.algorithm.linkedlist_stack_queue;

/**
 * LinkedListSort
 * 单向链表按某值划分成左边小、中间相等、右边大的形式
 *
 * @author Daydreamer
 * @date 2018/3/31 15:36
 */
public class LinkedListSort {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node listParititon1(Node head, int pivot){//pivot:中心点，枢纽
        if (head == null){
            return head;
        }
        int i = 0;
        Node cur = head;
        while (cur != null){
            i++;
            cur = cur.next;
        }
        Node[] nodes = new Node[i];
        i = 0;
        cur = head;
        for (; i < nodes.length; i++){
            nodes[i] = cur;
            cur = cur.next;
        }
        arrPartition(nodes, pivot);
        for (i = 1; i < nodes.length; i++){
            nodes[i - 1].next = nodes[i];
        }
        nodes[i - 1].next = null;
        return nodes[0];
    }

    public static void arrPartition(Node[] arr, int pivot){
        int small = -1;
        int big = arr.length;
        int index = 0;
        while (index != big){//未越界
            if (arr[index].value < pivot){
                swap(arr, ++small, index++);
            } else if (arr[index].value == pivot){
                index++;
            } else {
                swap(arr, --big, index);
            }
        }
    }

    public static void swap(Node[] arr, int a, int b){
        Node temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static Node listPartition2(Node head, int pivot){
        Node sH = null;//small Head
        Node sT = null;//small tail
        Node eH = null;
        Node eT = null;
        Node bH = null;
        Node bT = null;
        Node next = head;
        while (head != null){
            next = head.next;
            head.next = null;
            if (head.value < pivot){
                if (sH == null){
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;//往后移
                }
            } else if (head.value == pivot){
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
        return sH != null ? sH : eH != null ? eH : bH;
    }
}
