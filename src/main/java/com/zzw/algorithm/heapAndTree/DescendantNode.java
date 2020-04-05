package com.zzw.algorithm.heapAndTree;

/**
 * DescendantNode
 * 找后继节点
 *
 * @author Daydreamer
 * @date 2018/4/7 12:03
 */
public class DescendantNode {
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node getNextNode(Node node){
        if (node == null){
            return node;
        }
        if (node.right != null){//有右子树时后继为右子树的最左节点
            return getLeftMost(node);
        } else {//没有右子树
            Node parent = node.parent;
            while (parent != null && parent.left != node){
                //如果在左子树中，要找到父节点
                //node是parent的右孩子，则继续往上找
                //parent一直往上跳到空的时候停，说明没有后继
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    public static Node getLeftMost(Node node){
        if (node == null){
            return node;
        }
        while (node.left != null){
            node = node.left;
        }
        return node;
    }
}
