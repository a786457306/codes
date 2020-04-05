package com.zzw.algorithm.graph;

import java.util.HashMap;
import java.util.HashSet;

/**
 * graph
 *
 * @author Daydreamer
 * @date 2018/4/9 11:23
 */
public class Graph {
    //节点号，节点
    public HashMap<Integer, Node> nodes;
    public HashSet<Edge> edges;

    public Graph(){
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
