package com.zzw.algorithm.heapAndTree;

import java.util.HashMap;
import java.util.List;

/**
 * UnionFind
 * 并查集
 *
 * @author Daydreamer
 * @date 2018/4/7 15:48
 */
public class UnionFind {

    public static class Data{
        public String value;
        public String p;
    }//随便填

    public static class UnionSet{
        //（key,value）表示 key的父节点是value.
        // <DATA_A, DATA_B>表示data_a指向data_b
        public HashMap<Data, Data> fatherMap;
        //如果data是集合代表点，则data的value代表集合大小；
        // 如果data不是代表点，则data的value无意义
        public HashMap<Data, Integer> sizeMap;

        public UnionSet(List<Data> nodes){
            fatherMap = new HashMap<Data, Data>();
            sizeMap = new HashMap<Data, Integer>();
            makeSets(nodes);
        }

        private void makeSets(List<Data> nodes){
            //刚开始的所有元素各成一个集合。
            // 用并查集的条件是必须刚开始就知道所有元素，不能之后动态添加
            fatherMap.clear();
            sizeMap.clear();
            for (Data node : nodes){
                //初始化，每个元素各成一个集合。
                fatherMap.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        private Data findHead(Data node){
            //找代表点
            Data father = fatherMap.get(node);
            //代表点就是指向自己的点，如果不是继续找
            if (father != node){
                father = findHead(father);
            }
            //递归的每个子过程把father传回去，将链打平
            fatherMap.put(node, father);
            return father;
        }

        //代表点相同则属于一个集合
        public boolean isSameSet(Data a, Data b){
            return findHead(a) == findHead(b);
        }

        //合并两个集合
        public void union(Data a, Data b){
            if (a == null || b == null){
                return;
            }
            Data aHead = findHead(a);
            Data bHead = findHead(b);
            //不在同一个集合中才需要合并
            if (aHead != bHead){
                int aSetSize = sizeMap.get(aHead);
                int bSetSize = sizeMap.get(bHead);
                if (aSetSize <= bSetSize){
                    fatherMap.put(aHead, bHead);
                    sizeMap.put(bHead, aSetSize + bSetSize);
                } else {
                    fatherMap.put(bHead, aHead);
                    sizeMap.put(aHead, aSetSize + bSetSize);
                }
            }
        }
    }
}
