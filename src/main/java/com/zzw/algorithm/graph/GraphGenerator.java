package com.zzw.algorithm.graph;

/**
 * GraphGenerator
 * 生成图
 *
 * @author Daydreamer
 * @date 2018/4/9 11:31
 */
public class GraphGenerator {
    public static Graph creatGraph(Integer[][] matrix){
        //给数组，三列分别为权，from节点，to节点
        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; i++){
            Integer weight = matrix[i][0];
            Integer from = matrix[i][1];
            Integer to = matrix[i][2];
            if (!graph.nodes.containsKey(from)){
                graph.nodes.put(from, new Node(from));
                //如果from点不存在则新建
            }
            if (!graph.nodes.containsKey(to)){
                graph.nodes.put(to, new Node(to));
            }
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge newEdge = new Edge(weight, fromNode, toNode);
            //增加一个邻居
            fromNode.nexts.add(toNode);
            //出度++
            fromNode.out++;
            toNode.in++;
            //加入fromNode的边集
            fromNode.edges.add(newEdge);
            //整个图加入一条新的边
            graph.edges.add(newEdge);
        }
        return graph;
    }
}
