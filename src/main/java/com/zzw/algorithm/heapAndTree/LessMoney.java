package com.zzw.algorithm.heapAndTree;

import java.util.PriorityQueue;

/**
 * LessMoney
 * 哈夫曼编码问题——贪心算法
 * 一块金条切成两半，是需要花费和长度数值一样的铜板的。比如长度为20的金条，
 * 不管切成长度多大的两半，都要花费20个铜板。一群人想整分整块金条，怎么分
 * 最省铜板？
 * 例如,给定数组{10,20,30}，代表一共三个人，整块金条长度为10+20+30=60.
 * 金条要分成10,20,30三个部分。
 * 如果，先把长度60的金条分成10和50，花费60，
 * 再把长度50的金条分成20和30，花费50，
 * 一共花费110铜板。
 * 但是如果，
 * 先把长度60的金条分成30和30，花费60
 * 再把长度30金条分成10和20，花费30
 * 一共花费90铜板。
 * 输入一个数组，返回分割的最小代价。
 *
 * 确定叶节点合并顺序使得合并代价最低——求所有非叶节点的值的和最小值。
 * 小根堆结构。先将所有元素加入小根堆，然后弹出两个节点（倒数两个小的），
 * 这两个节点之和组成新的节点，扔回小根堆。循环往复。
 *
 * @author Daydreamer
 * @date 2018/4/6 17:39
 */
public class LessMoney {
    public static int lessMoney(int[] arr){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++){
            pq.add(arr[i]);
        }
        int sum = 0;
        int cur = 0;
        while (pq.size() > 1){
            cur = pq.poll() + pq.poll();
            sum += cur;
            pq.add(cur);
        }
        return sum;
    }
}
