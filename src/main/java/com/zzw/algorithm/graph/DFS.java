package com.zzw.algorithm.graph;

import java.util.HashSet;
import java.util.Stack;

/**
 * DFS
 * 深度优先遍历
 *
 * @author Daydreamer
 * @date 2018/4/10 15:57
 */
public class DFS {
    //用栈
    public static void dfs(Node node){
        if (node == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        //刚开始把节点装进去，打印值。
        stack.add(node);
        set.add(node);
        System.out.println(node.value);
        while (!stack.isEmpty()){
            //弹出当前节点，遍历当前节点的所有邻居节点
            Node cur = stack.pop();
            for (Node next : cur.nexts){
                //一旦邻居节点中有一个没遍历过，就找这个
                if (!set.contains(next)){
                    //把当前节点和它的后继重新放入
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }
}
