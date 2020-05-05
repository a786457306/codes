package com.zzw.algorithm.jianzhi_offer.linkedlist;

import com.zzw.algorithm.jianzhi_offer.day01.ListNode;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点。
 * 重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * 2,3,3,发现第二个3==第一个3，第一个3的next=4；发现第一个3和它的next不相等，则2的next是4；
 */
public class DeleteDuplicateNode {

    /**
     * 新建两个节点，一个用于保存最后一个确认不重复的节点，一个用于向后搜索
     * 新增一个头节点，均从头节点开始，保证第一个节点就重复时也可以计算
     *
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode realHead = new ListNode(0);
        realHead.next = pHead;
        ListNode temp = realHead;
        ListNode tempFast = realHead.next;
        while (tempFast != null) {
            // tempFast和它下一个节点值相同
            if (tempFast.next != null && tempFast.data == tempFast.next.data) {
                // 找到所有相等值
                while (tempFast.next != null && tempFast.data == tempFast.next.data) {
                    tempFast = tempFast.next;
                }
                temp.next = tempFast.next;
                tempFast = tempFast.next;
            } else {
                temp = temp.next;
                tempFast = tempFast.next;
            }
        }
        return realHead.next;
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