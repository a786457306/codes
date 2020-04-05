package com.zzw.algorithm.graph;

/**
 * PrefixTree
 * 前缀树实现
 * trie tree
 *
 * @author Daydreamer
 * @date 2018/4/9 9:58
 */
public class PrefixTree {
    public static class TrieNode{
        public int pass;
        public int end;
        public TrieNode[] nexts;
        //边结构也可以这样
        //public HashMap<Integer, TrieNode> nexts;
        //Integer是字符对应的ASCII码，TrieNode是下一个节点

        public TrieNode(){
            pass = 0;
            end = 0;
            nexts = new TrieNode[26];
            //字符串里只有26个字符，默认长度为26。
            // 如果觉得长度不止26，可以用上面那个方法表示边
        }
    }

    public static class Trie{
        private TrieNode root;

        public Trie(){
            root = new TrieNode();
        }

        //将字符串存入树中
        public void insert(String word){
            if (word == null){
                return;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;//从头节点开始
            int index = 0;
            for (int i = 0; i < chs.length; i++){
                index = chs[i] - 'a';//字母对应的数
                if (node.nexts[index] == null){//没有通路
                    node.nexts[index] = new TrieNode();//建个新节点
                }
                node = node.nexts[index];//node往下走
                node.pass++;//有路过该节点的通路
            }
            node.end++;//表示有字符串以该节点结尾
        }

        public int search(String word){
            if (word == null){
                return 0;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++){
                index = chs[i] - 'a';
                if (node.nexts[index] == null){//边是否存在
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;
            //返回有多少个字符串是以该字符结尾的
            // 表示这个字符串在树中出现的次数
        }

        public void delete(String word){
            if (search(word) != 0){
                char[] chs = word.toCharArray();
                TrieNode node = root;
                int index = 0;
                for (int i = 0; i < chs.length; i++){
                    index = chs[i] - 'a';
                    if (--node.nexts[index].pass == 0){
                        //pass值表示前缀有多少个节点是共享的
                        //当pass值减掉之后为0时，说明只有
                        // 当前字符串用过这些节点，可以直接删掉
                        node.nexts[index] = null;
                        return;
                    }
                    node = node.nexts[index];
                }
                node.end--;
            }
        }
    }
}
