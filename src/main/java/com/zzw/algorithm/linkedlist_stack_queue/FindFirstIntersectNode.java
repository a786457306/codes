package com.zzw.algorithm.linkedlist_stack_queue;

import java.util.HashSet;

/**
 * FindFirstIntersectNode
 * 两个单链表相交的一系列问题（很难）
 * 【题目】
 * 在本题中，单链表可能有环，也可能无环。给定两个单链表的头节点head1
 * 和head2，这两个链表可能相交，也可能不相交。请实现一个函数，如果两
 * 个链表相交，请返回相交的第一个节点；如果不相交，返回null即可。
 * 【要求】
 * 如果链表1的长度为N，链表2的长度为M，时间复杂度请达到O(N+M)，额外
 * 空间复杂度请达到O(1)。
 *
 * @author Daydreamer
 * @date 2018/4/3 19:41
 */
public class FindFirstIntersectNode {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node getIntersectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        }
        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, loop1, head2, loop2);
        }
        return null;
    }

    public static Node getFirstLoopNode(Node head) {
        HashSet<Node> set = new HashSet<Node>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }

    public static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node slow = head.next;
        Node fast = head.next.next;
        while (slow != fast) {//还未相遇时
            if (fast.next.next == null || fast.next == null) {//快指针已经走到空了
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = head;//相遇后fast返回头结点
        while (slow != fast) {//fast一次走一步，再次相遇时即为入环节点
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    //用hash表的方法
    public static Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;//有一个为空则不相交
        }
        Node cur1 = head1;
        Node cur2 = head2;
        HashSet<Node> set = new HashSet<Node>();
        while (cur1 != null) {
            set.add(cur1);
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            if (set.contains(cur2)) {
                return cur2;
            }
            cur2 = cur2.next;
        }
        return null;
    }

    //不用hash表的方法
    //找两个链表长度之差与它们的最后一个节点，如果相等则相交，否则不相交
    //若相交，长链表先走差值长度，之后两个一起走，相等的时候是第一个相交的节点
    public static Node noLoop2(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        if (cur1 != cur2) {
            return null;
        }
        cur1 = n > 0 ? head1 : head2;//靠前的那个
        cur2 = cur1 == head1 ? head2 : head1;//短链表的头结点
        n = Math.abs(n);
        while (n > 0) {
            cur1 = cur1.next;
            n--;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node cur1 = null;
        Node cur2 = null;
        if (loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            cur1 = loop1.next;
            while (cur1 != loop1) {
                cur1 = cur1.next;
                if (cur1 == loop2) {
                    return loop2;
                }
            }
            return null;
        }
    }
}