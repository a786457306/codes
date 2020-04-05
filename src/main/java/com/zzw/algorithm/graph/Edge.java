package com.zzw.algorithm.graph;

/**
 * Edge
 *
 * @author Daydreamer
 * @date 2018/4/9 11:27
 */
public class Edge {
    public int weight;
    public Node from;
    public Node to;

    public Edge(int weight, Node from, Node to){
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
