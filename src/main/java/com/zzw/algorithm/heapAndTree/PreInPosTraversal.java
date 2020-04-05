package com.zzw.algorithm.heapAndTree;

import java.util.Stack;

/**
 * PreInPosTraversal
 * 二叉树的先序中序后序遍历
 *
 * @author Daydreamer
 * @date 2018/4/6 19:50
 */
public class PreInPosTraversal {
    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int data){
            this.value = data;
        }
    }

    //递归遍历
    public static void preOrderRecur(Node head){
        if (head == null){
            return;
        }
        System.out.println(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    public static void inOrderRecur(Node head){
        if (head == null){
            return;
        }
        inOrderRecur(head.left);
        System.out.println(head.value + " ");
        inOrderRecur(head.right);
    }

    public static void posOrderRecur(Node head){
        if (head == null){
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.println(head.value + " ");
    }

    //非递归遍历
    //先序：用栈，先存右再存左，继续往下找，如果还有就入栈，否则就弹出。弹出就打印
    //中左右，所以入栈时是中右左，中先打印，右左出栈为左右
    public static void preOrderUnRecur(Node head){
        if (head != null) {
            Stack<Node> s = new Stack<>();
            s.push(head);
            while (!s.isEmpty()){
                head = s.pop();
                System.out.println(head.value + " ");
                if (head.right != null){
                    s.push(head.right);
                }
                if (head.left != null){
                    s.push(head.left);
                }
            }
        }
        System.out.println();
    }

    //左中右，先打印左边，再打印本身，再打印右边
    public static void inOrderUnRecur(Node head){
        if (head != null){
            Stack<Node> s = new Stack<>();
            s.push(head);
            while (!s.isEmpty() || head != null){
                if (head != null){//刚开始栈里放的是树的所有左边界（最左一排孩子节点）
                    s.push(head);
                    head = head.left;
                } else {
                    head = s.pop();//左边没有了，把左边的打印之后打印本身，再打印右孩子，并且循环加入右孩子的左子树。。。
                    System.out.println(head.value + " ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    //实现先中再右再左，然后存入另一个栈，这样打印的时候刚好左右中
    public static void posOrderUnRecur(Node head){
        if (head != null){
            Stack<Node> stack = new Stack<>();
            Stack<Node> help = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()){
                head = stack.pop();
                help.push(head);
                //中右左，因为右在下面，help先存了中，然后每次都先存右，没了右再存左
                if (head.left != null){
                    stack.push(head.left);
                    //入栈的时候把左子树全放进去，存入help栈顺序为
                }
                if (head.right != null){
                    stack.push(head.right);
                }
            }
            while (!help.isEmpty()){
                System.out.println(help.pop().value + " ");
            }
        }
        System.out.println();
    }

    public static void posOrderUnRecur2(Node head){

    }
}
