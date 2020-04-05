package com.zzw.algorithm.heapAndTree;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * MostEarning
 *
 * @author Daydreamer
 * @date 2018/4/6 18:28
 */
public class MostEarning {
    public static class Node{
        public int p;
        public int c;

        public Node(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }

    public static class MinCostComparator implements Comparator<Node>{
        public int compare(Node num1, Node num2){
            return  num1.c - num2.c;
        }
    }

    public static class MaxProfitComparator implements Comparator<Node>{
        public int compare(Node num1, Node num2){
            return num2.p - num1.p;
        }
    }

    public static int findMaxCapital(int k, int w, int[] profits, int[] cost){
        Node[] nodes = new Node[profits.length];
        for (int i = 0; i < profits.length; i++){//给node赋值
            nodes[i] = new Node(profits[i], cost[i]);
        }
        PriorityQueue<Node> minCostQ = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator());
        for (int i = 0; i < nodes.length; i++){
            minCostQ.add(nodes[i]);//所有节点都加入到花费的小根堆里。
        }
        for (int i = 0; i < k; i++){//找花费小于所持有资金数的所有节点，加入收益的大根堆并弹。
            while (!minCostQ.isEmpty() && minCostQ.peek().c <= w){
                maxProfitQ.add(minCostQ.poll());
            }
            if (maxProfitQ.isEmpty()){//没有可做的了，返回
                return w;
            }
            w += maxProfitQ.poll().p;//弹出的节点表示要做的项目，收益积累
        }
        return w;
    }
}
