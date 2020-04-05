package com.zzw.algorithm.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS
 *
 * @author Daydreamer
 * @date 2018/4/9 12:13
 */
public class BFS {

    //一个queue和一个set，set保存所有进过队列的节点。
    //出队列就打印，打印的同时遍历下面的节点。
    public static void bfs(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        //set表示点进没进过队列
        HashSet<Node> set = new HashSet<>();
        queue.add(node);
        //队列的注册，进过队列的就进set里
        set.add(node);
        //遍历当前节点的所有后继节点，没有了再下一层
        while (!queue.isEmpty()) {
            //队列中拿出当前节点并打印，弹出就打印并找被打印节点的后继节点
            Node cur = queue.poll();
            System.out.println(cur.value);
            //有当前节点1所有下一级的节点234，将他们都加进去，就是第一层
            for (Node next : cur.nexts) {
                //cur的后继节点们
                if (!set.contains(next)) {
                    //后继节点中还没加进去的就加进去
                    set.add(next);
                    queue.add(next);
                }
            }
        }
    }
}
