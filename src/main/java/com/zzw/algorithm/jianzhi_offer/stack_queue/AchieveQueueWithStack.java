package com.zzw.algorithm.jianzhi_offer.stack_queue;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class AchieveQueueWithStack {

    /**
     * 第一种解法：
     * 两个栈分别用来存数据和取数据。
     * pop的时候将数据全部存入popStack中，弹出最后一个
     * push的时候将数据全部存入pushStack中，最后push元素
     */
    Stack<Integer> popStack = new Stack<>();
    Stack<Integer> pushStack = new Stack<>();

    public void push(int node) {
        convert(pushStack, popStack);
        pushStack.push(node);
    }

    public int pop() {
        convert(popStack, pushStack);
        return popStack.pop();
    }

    public void convert(Stack<Integer> inStack, Stack<Integer> outStack) {
        while (!outStack.isEmpty()) {
            inStack.push(outStack.pop());
        }
    }
}
