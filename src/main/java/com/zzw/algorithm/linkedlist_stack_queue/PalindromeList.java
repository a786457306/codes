package com.zzw.algorithm.linkedlist_stack_queue;

import java.util.Stack;

/**
 * PalindromeList
 * 判断是不是回文串
 * 【题目】
 * 给定一个链表的头节点head，请判断该链表是否为回文结构。
 * 例如：
 * 1->2->1，返回true。
 * 1->2->2->1，返回true。
 * 15->6->15，返回true。
 * 1->2->3，返回false。
 * 【思路】
 * 准备一个栈，把链表元素全加入栈里再弹出，相当于逆序。如果相等就是。
 * 把元素全部加入栈中，然后从头遍历链表，同时栈弹元素。全部相等则true。
 *
 * @author Daydreamer
 * @date 2018/3/30 19:15
 */
public class PalindromeList {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    //额外n个空间
    public static boolean isPalindromeList(Node head) {
        //将链表内容全存入栈
        Stack<Node> stack = new Stack<Node>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        //遍历链表同时弹栈，看二者是否相等
        while (head != null) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    //额外空间为n/2
    public static boolean isPalindromeList2(Node head) {
        if (head == null || head.next == null) {//0个或1个确实为回文
            return true;
        }
        Node slow = head;
        Node quick = head;
        //停止条件
        while (quick.next != null && quick.next.next != null) {//奇数、偶数情况都要考虑
            slow = slow.next;//慢指针一次走一步
            quick = quick.next.next;//快指针一次走两步
        }
        Stack<Node> stack = new Stack<Node>();
        while (slow != null) {//后半部分入栈
            stack.push(slow);
            slow = slow.next;
        }
        while (!stack.isEmpty()) {//弹栈，与前半部分比较，看是否相等
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    //额外空间为O(1)
    public static boolean isPalindromeList3(Node head) {
        if (head == null || head.next == null) {//0个或1个确实为回文
            return true;
        }
        Node slow = head;
        Node fast = head;
        while (fast.next != null) {//慢指针指向中点，快指针指向结尾。然后倒序
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;//快指针回到中点下一位置，让它逆序
        slow.next = null;//成三角状，中点指向空，后半部分全倒序指向中点
        Node help = null;//记录fast的下一个节点位置，否则就找不着了
        while (fast != null) {//开始逆序
            help = fast.next;//记录快指针的下一个节点
            fast.next = slow;//将快指针指向slow（逆序）
            slow = fast;//这里逆序好了，继续往下逆序，slow往后走
            fast = help;//fast也往后走。当fast到最后一个时，此时help和fast都为空，再判断就可跳出循环
        }
        help = slow;//保存最后一个节点
        fast = head;//回到第一个
        boolean res = true;
        //开始两边一起走，判断是否回文
        while (slow != null && fast != null) {//还没到中点.奇偶数兼顾，任意为空都停
            if (slow.value != fast.value) {//不是回文，false，跳出循环
                res = false;
                break;
            }
            slow = slow.next;//从右往中间走
            fast = fast.next;//从左往中间走
        }
        //找完了恢复链表
        slow = help.next;//倒数第二个节点
        help.next = null;//最后一个节点逆序应该指向空
        while (slow != null) {//还没到中点时
            fast = slow.next;//保存slow前一个节点
            slow.next = help;//让这个节点指向后一个（逆序）
            help = slow;//逆序完毕，往前走，继续逆序
            slow = fast;
        }
        return res;
    }
}
