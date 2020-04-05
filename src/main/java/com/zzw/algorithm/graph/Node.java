package com.zzw.algorithm.graph;

import java.util.ArrayList;

/**
 * Node
 *
 * @author Daydreamer
 * @date 2018/4/9 11:27
 */
public class Node{
    public int value;
    public int in;//入度：有多少个节点指向它
    public int out;//出度：指向多少个节点
    public ArrayList<Node> nexts;//邻居节点
    public ArrayList<Edge> edges;//边

    public Node(int value){
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}