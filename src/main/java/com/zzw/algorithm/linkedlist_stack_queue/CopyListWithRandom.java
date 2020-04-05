package com.zzw.algorithm.linkedlist_stack_queue;

import java.util.HashMap;

/**
 * CopyListWithRandom
 * 复制含有随机指针节点的链表
 * 【题目】
 * 一种特殊的链表节点类描述如下：
 * public class Node {
 * public int value;
 * public Node next;
 * public Node rand;
 * public Node(int data) {
 * this.value = data;
 * }
 * }
 * Node类中的value是节点值，next指针和正常单链表中next指针的意义一样，
 * 都指向下一个节点，rand指针是Node类中新增的指针，这个指针可能指向链表
 * 中的任意一个节点，也可能指向null。给定一个由Node节点类型组成的无环单
 * 链表的头节点head，请实现一个函数完成这个链表中所有结构的复制，并返回
 * 复制的新链表的头节点。
 *
 * @author Daydreamer
 * @date 2018/4/3 18:24
 */
public class CopyListWithRandom {
    public static class Node {
        public int value;
        public Node next;
        public Node rand;

        public Node(int data) {
            this.value = data;
        }
    }

    //用hash表存，存每个节点对应的拷贝节点
    public static Node copyList1(Node head) {
        HashMap<Node, Node> map = new HashMap<Node, Node>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.value));//向表中添加cur与它的拷贝节点
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);//赋值，cur的复制节点的next是cur.next的复制节点
            map.get(cur).rand = map.get(cur.rand);//赋值，cur的复制节点的random是cur.rand的复制节点
            cur = cur.next;//继续
        }
        return map.get(head);//返回复制节点链表的头结点
    }

    public static Node copyList2(Node head) {
        if (head == null) {
            return head;
        }
        Node cur = head;
        Node next = null;
        while (cur != null) {//将复制节点插入链表
            next = cur.next;//暂存cur的下一个节点
            cur.next = new Node(cur.value);//让cur的next指针指向复制节点
            cur.next.next = next;//复制节点的next指针指向原next节点
            cur = next;//继续往下执行
        }
        cur = head;
        Node curCopy = null;
        while (cur != null) {//连接每个节点的random指针
            next = cur.next.next;//原链表内的下一个节点
            curCopy = cur.next;//现节点的复制节点
            curCopy.rand = cur.rand != null ? cur.rand.next : null;//给复制节点的random赋值
            cur = next;
        }
        Node res = head.next;
        cur = head;
        while (cur != null) {//分离两个链表
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next != null ? next.next : null;
            cur = next;
        }
        return res;
    }
}
