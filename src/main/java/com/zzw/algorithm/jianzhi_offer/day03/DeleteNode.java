package com.zzw.algorithm.jianzhi_offer.day03;

import com.zzw.algorithm.jianzhi_offer.day01.ListNode;

/**
 * DeleteNode
 *
 * @author Daydreamer
 * @date 2018/8/22 22:09
 */
public class DeleteNode {
    public static void main(String[] args) {
        ListNode head=new ListNode();
        ListNode second=new ListNode();
        ListNode third=new ListNode();
        head.next=second;
        second.next=third;
        head.data=1;
        second.data=2;
        third.data=3;
        DeleteNode p13=new DeleteNode();
        p13.deleteNode(head, second);
        System.out.println(head.next.data);
    }
    public void deleteNode(ListNode head, ListNode deListNode){
        if(deListNode==null||head==null){
            return;
        }
        if(head==deListNode){//删除头结点
            head=null;
        }else{
            if(deListNode.next==null){//删除尾结点
                ListNode pointListNode=head;
                while(pointListNode.next.next!=null){
                    pointListNode=pointListNode.next;
                }
                pointListNode.next=null;
            }else{
                deListNode.data=deListNode.next.data;
                deListNode.next=deListNode.next.next;
            }
        }
    }

}
