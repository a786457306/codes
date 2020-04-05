package com.zzw.algorithm.linkedlist_stack_queue;

/**
 * ArrayToStackQueue
 * 用数组功能实现固定大小的队列和栈
 *
 * @author Daydreamer
 * @date 2018/3/29 16:15
 */
public class ArrayToStackQueue {
    public static class ArrayStack{
        private Integer[] arr;
        private Integer index;

        public ArrayStack(int initSize){
            if (initSize < 0){
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new Integer[initSize];
            index = 0;//指向栈顶元素上方
        }

        public Integer peek(){//读栈顶元素
            if (index == 0){
                return null;
            }
            return arr[index - 1];
        }

        public void push(int obj){//添加元素
            if (index == arr.length){
                throw new ArrayIndexOutOfBoundsException("The stack is full");
            }
            arr[index++] = obj;
        }

        public Integer pop(){//弹出栈顶元素
            if (index == 0){
                throw new ArrayIndexOutOfBoundsException("The stack is empty");
            }
            return arr[--index];
        }
    }

    public static class ArrayQueue{//循环用数组
        private Integer[] arr;
        private Integer size;
        private Integer start;//指向要取元素的第一个元素位置
        private Integer end;//指向新加入的元素应该放在哪

        public ArrayQueue(int initSize){
            if (initSize < 0){
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new Integer[initSize];
            size = 0;
            start = 0;
            end = 0;
        }

        public Integer peek(){
            if (size == 0){
                return null;
            }
            return arr[start];
        }

        public void push(int obj){//放元素，判断能否放下。
            if (size == arr.length){
                throw new ArrayIndexOutOfBoundsException("The queue is full");
            }
            size++;//能放
            arr[end] = obj;//最后一个元素是新放入的元素
            end = nextIndex(arr.length, end);//指向下一个新加入元素的位置
        }

        public Integer poll(){//弹出一个元素
            if (size == 0){
                throw new ArrayIndexOutOfBoundsException("The queue is empty");
            }
            size--;
            int temp = start;//start只与size有关
            start = nextIndex(arr.length, start);
            return arr[temp];
        }

        public int nextIndex(int size, int index){//有没有满
            return index == size - 1 ? 0 : index + 1;
        }
    }
}
