package com.zzw.algorithm.jianzhi_offer.day03;

import com.zzw.algorithm.jianzhi_offer.day01.BinaryTreeNode;

/**
 * Problem18
 *
 * @author Daydreamer
 * @date 2018/8/22 21:05
 */
public class Problem18 {
    public static void main(String args[])
    {
        BinaryTreeNode root1=new BinaryTreeNode();
        BinaryTreeNode node1=new BinaryTreeNode();
        BinaryTreeNode node2=new BinaryTreeNode();
        BinaryTreeNode node3=new BinaryTreeNode();
        BinaryTreeNode node4=new BinaryTreeNode();
        BinaryTreeNode node5=new BinaryTreeNode();
        BinaryTreeNode node6=new BinaryTreeNode();
        root1.leftNode=node1;
        root1.rightNode=node2;
        node1.leftNode=node3;
        node1.rightNode=node4;
        node4.leftNode=node5;
        node4.rightNode=node6;
        root1.value=8;
        node1.value=8;
        node2.value=7;
        node3.value=9;
        node4.value=2;
        node5.value=4;
        node6.value=7;
        BinaryTreeNode root2=new BinaryTreeNode();
        BinaryTreeNode a=new BinaryTreeNode();
        BinaryTreeNode b=new BinaryTreeNode();
        root2.leftNode=a;
        root2.rightNode=b;
        root2.value=8;
        a.value=9;
        b.value=2;
        Problem18 test=new Problem18();
        System.out.println(test.hasSubtree(root1, root2));
    }

    public boolean hasSubtree(BinaryTreeNode root1, BinaryTreeNode root2) {
        boolean result = false;
        if (root1 == null || root2 == null){
            return false;
        }
        return isSubtreeWithRoot(root1, root2) || hasSubtree(root1.leftNode, root2) || hasSubtree(root1.rightNode, root2);
    }

    private boolean isSubtreeWithRoot(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.value != root2.value){
            return false;
        }
        return isSubtreeWithRoot(root1.leftNode, root2.leftNode) && isSubtreeWithRoot(root1.rightNode, root2.rightNode);
    }

}
