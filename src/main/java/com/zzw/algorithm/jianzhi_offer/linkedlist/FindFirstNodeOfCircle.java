package com.zzw.algorithm.jianzhi_offer.linkedlist;

import com.zzw.algorithm.jianzhi_offer.day01.ListNode;

/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null
 */
public class FindFirstNodeOfCircle {

    /**
     * 开始：
     * 设置一个快指针（一次两步）和一个慢指针（一次一步），若有环，则两指针会相遇
     * 到达相遇点：
     * 一个指针从相遇点出发，一个指针从头节点出发，同样速度走
     * 再次相遇的位置即为环入口点。
     *
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {

        if (pHead == null || pHead.next == null || pHead.next.next == null) {
            return null;
        }

        ListNode slow = pHead.next;
        ListNode fast = pHead.next.next;

        while (fast != slow) {
            if (slow != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            } else {
                return null;
            }
        }
        slow = pHead;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

}

/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/