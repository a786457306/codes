package com.zzw.algorithm.jianzhi_offer.day01;

import java.util.Arrays;

/**
 * BinaryTree
 *
 * 题目描述：输入二叉树的前序遍历和中序遍历的结果，重建出该二叉树。
 * 假设前序遍历和中序遍历结果中都不包含重复的数字，例如输入的前序遍历序列
 * {1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}重建出如图所示的二叉树。
 *
 * 思路：前序的第一个节点就是根节点，根据根节点将中序数组划分为左右两部分，递归。
 *
 * @author Daydreamer
 * @date 2018/8/20 22:48
 */
public class BinaryTree {
    public static void main(String[] args) throws Exception {
        int[] preSort={1,2,4,7,3,5,6,8};
        int[] inSort={4,7,2,1,5,3,8,6};
        BinaryTreeNode root=constructCore(preSort,inSort);
    }

    public static BinaryTreeNode constructCore(int[] preorder, int[] inorder) throws Exception{
        if (preorder == null || inorder == null){
            return null;
        }
        if (preorder.length != inorder.length){
            throw new Exception("非法输入");
        }
        BinaryTreeNode root = new BinaryTreeNode();
        for (int i = 0; i < preorder.length; i++){
            if (inorder[i] == preorder[0]){
                root.value = inorder[i];
                System.out.println(root.value);
                root.leftNode = constructCore(Arrays.copyOfRange(preorder,1,i+1), Arrays.copyOfRange(inorder, 0, i));
                root.rightNode = constructCore(Arrays.copyOfRange(preorder,i+1,preorder.length), Arrays.copyOfRange(inorder, i+1, inorder.length));
            }
        }
        return root;
    }
}
