package com.zzw.algorithm.linkedlist_stack_queue;

import java.util.Stack;

/**
 * GetMinStack
 * 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
 * 【要求】
 * 1．pop、push、getMin操作的时间复杂度都是O(1)。
 * 2．设计的栈类型可以使用现成的栈结构。
 * 同时再存一个Min栈，每当往栈里添加元素时也在Min栈里添加当前最小元素，然后同步操作。
 *
 * @author Daydreamer
 * @date 2018/3/29 23:31
 */
public class GetMinStack {
    public static class MyStack2{
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack2(){
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }
        //如果新添加的元素更小则放入min栈中，若大则再次放入min栈顶元素
        public void push(int newNum){
            if (this.stackMin.isEmpty()){
                this.stackMin.push(newNum);
            } else if (newNum < this.getMin()){
                this.stackMin.push(newNum);
            } else {
                int newMin = this.stackMin.peek();
                this.stackMin.push(newMin);
            }
            this.stackData.push(newNum);//无论怎样都要压数
        }

        public int pop(){
            if (this.stackData.isEmpty()){
                throw new RuntimeException("Your stack is empty");
            }
            this.stackMin.pop();
            return this.stackData.pop();
        }

        //获取当前最小值（即min栈栈顶元素）
        public int getMin(){
            if (this.stackMin.isEmpty()){
                throw new RuntimeException("Your stack is empty");
            }
            return this.stackMin.peek();
        }
    }
}
