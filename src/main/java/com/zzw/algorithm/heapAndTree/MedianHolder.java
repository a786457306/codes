package com.zzw.algorithm.heapAndTree;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * MedianHolder
 * 随时找到中位数
 * 【题目】
 * 有一个源源不断地吐出整数的数据流，假设你有足够的空间来保存吐出的数。请设计一个名叫MedianHolder的结构，MedianHolder可以随时取得之前吐出所有数的中位数。
 * 【要求】
 * 1．如果MedianHolder已经保存了吐出的N个数，那么任意时刻将一个新数加入到MedianHolder的过程，其时间复杂度是O(logN)。
 * 2．取得已经吐出的N个数整体的中位数的过程，时间复杂度为O(1)。
 *
 * @author Daydreamer
 * @date 2018/4/6 12:08
 */
public class MedianHolder {
    public static class Median{
        private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new MaxHeapComparator());
        private PriorityQueue<Integer> minHeap = new PriorityQueue<>(new MinHeapComparator());

        private void modifyHeapSize(){
            if (this.maxHeap.size() - this.minHeap.size() > 1){
                this.minHeap.add(maxHeap.poll());
            }
            if (this.minHeap.size() - this.maxHeap.size() > 1){
                this.maxHeap.add(minHeap.poll());
            }
        }

        public void addNum(int num){
            if (this.maxHeap.isEmpty()) {
                this.maxHeap.add(num);
                return;
            }
            if (this.maxHeap.peek() >= num) {
                this.maxHeap.add(num);
            } else {
                if (this.minHeap.isEmpty()) {
                    this.minHeap.add(num);
                    return;
                }
                if (this.minHeap.peek() > num) {
                    this.maxHeap.add(num);
                } else {
                    this.minHeap.add(num);
                }
            }
            modifyHeapSize();
        }

        public Integer getMedian(){
            int maxSize = this.maxHeap.size();
            int minSize = this.minHeap.size();
            if (maxSize + minSize == 0){
                return null;
            }
            Integer maxHead = this.maxHeap.peek();
            Integer minHead = this.minHeap.peek();

            if (((maxSize + minSize) & 1) == 0){//有偶数个元素
                return (maxHead + minHead) / 2;
            }
            return maxSize > minSize ? maxHead : minHead;//返回多的那个元素
        }
    }

    public static class MaxHeapComparator implements Comparator<Integer>{//大顶堆

        public int compare(Integer o1, Integer o2) {
            if (o1 >= o2){
                return -1;
            } else
                return 1;
        }
    }

    public static class MinHeapComparator implements Comparator<Integer>{//小顶堆

        public int compare(Integer o1, Integer o2) {
            if (o2 >= o1){
                return -1;
            } else
                return 1;
        }
    }









    public static class Student{
        private String name;
        private int id;

        public Student(String name, int id){
            this.name = name;
            this.id = id;
        }

        @Override
        public String toString(){
            return this.id + " " +this.name;
        }
    }

    public static class StudentComparator implements Comparator<Student>{

        @Override
        public int compare(Student s1, Student s2) {
            if (s1.id < s2.id){
                return -1;
            } else if (s1.id > s2.id){
                return 1;
            }else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Student> heap = new PriorityQueue<>(new StudentComparator());
        heap.add(new Student("aa", 34));
        heap.add(new Student("bb", 45));
        heap.add(new Student("cc", 23));
        heap.add(new Student("dd", 12));
        heap.add(new Student("ee", 33));
        heap.add(new Student("ff", 11));
        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
    }
}
