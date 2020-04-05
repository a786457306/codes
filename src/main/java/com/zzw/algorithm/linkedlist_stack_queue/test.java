package com.zzw.algorithm.linkedlist_stack_queue;

import java.util.Stack;

/**
 * test
 *
 * @author Daydreamer
 * @date 2018/4/3 15:32
 */
public class test {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    //额外n个空间
    public static boolean isPandomList(Node head){
        Stack<Node> stack = new Stack<Node>();
        Node cur = head;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        while (!stack.isEmpty()){
            if (head.next.value != stack.pop().value){
                return false;
            }
        }
        return true;
    }
    //额外n/2空间
    public static boolean isPandomList2(Node head){
        if (head == null || head.next == null){
            return true;
        }
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Stack<Node> stack = new Stack<Node>();
        while (slow != null){
            stack.push(slow);
            slow = slow.next;
        }
        while (!stack.isEmpty()){
            if (head.value != stack.pop().value){
                return false;
            }head = head.next;

        }
        return true;
    }
}
