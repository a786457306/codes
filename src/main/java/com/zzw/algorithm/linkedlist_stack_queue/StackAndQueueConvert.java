package com.zzw.algorithm.linkedlist_stack_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * StackAndQueueConvert
 * 仅用队列实现栈，仅用栈实现队列
 *
 * @author Daydreamer
 * @date 2018/3/29 23:04
 */
//仅用栈实现队列结构
//往外倒数，一个pop栈，一个push栈。要把push栈里的东西全先进先出顺序输出，
// 则把push栈里的东西全放到pop栈中，再弹出，顺序就对了
public class StackAndQueueConvert {
    public static class TwoStackQueue{
        private Stack<Integer> stackPush;
        private Stack<Integer> stackPop;

        public TwoStackQueue(){
            stackPop = new Stack<Integer>();
            stackPush = new Stack<Integer>();
        }

        /**
         * 两个栈倒数原则：
         * pop栈为空时才能倒，
         * 要一次性倒完，push栈里不能留东西。
         */
        private void goTo(){
            if (stackPop.isEmpty()){
                while (!stackPush.isEmpty()){
                    stackPop.push(stackPush.pop());
                }
            }
        }

        public void push(int pushInt){
            stackPush.push(pushInt);
            goTo();
        }

    }

    //队列实现栈结构
    public static class TwoQueueStack{
        private Queue<Integer> queue;
        private Queue<Integer> help;

        public TwoQueueStack(){
            queue = new LinkedList<Integer>();
            help = new LinkedList<Integer>();
        }

        public void push(int pushInt){
            queue.add(pushInt);
        }

        /**
         * 读取第一个元素时
         * 不断从queue中拿出元素，读到最后一个元素，并把它压入help，
         * 因为只是读数，不用把它取出去
         * 然后交换引用
         *
         * @return
         */
        public int peek(){
            if (queue.isEmpty()){
                throw new RuntimeException("stack is empty!");
            }
            while (queue.size() != 1){
                help.add(queue.poll());
            }
            int res = queue.poll();
            help.add(res);
            swap();
            return res;
        }

        /**
         * 弹出元素时
         * queue的元素依次到help里去，只剩一个，然后弹出最后一个作为弹出结果
         * 两个queue交换引用，下次继续这样做
         *
         * @return
         */
        public int pop(){
            if (queue.isEmpty()){
                throw new RuntimeException("stack is empty!");
            }
            while (queue.size() > 1){
                help.add(queue.poll());//queue里的元素依次出来到help里去
            }
            int res = queue.poll();
            swap();
            return res;
        }

        /**
         * 两队列交换引用
         */
        public void swap(){
            Queue<Integer> tmp = help;
            help = queue;
            queue = tmp;
        }
    }
}
