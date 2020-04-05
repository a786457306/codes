package com.zzw.algorithm.recursion;

import java.util.Stack;

/**
 * Author: Daydreamer
 * Date:2019/11/30
 */
public class ReverseStackByRecursive {

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }

    //
    public static int getAndRemoveLastElement(Stack<Integer> stack) {
        //入栈顺序321
        int res = stack.pop();//保存栈顶元素，一步步的保存，1,2
        if (stack.isEmpty()) {
            return res;
        } else {
            int last = getAndRemoveLastElement(stack);
            stack.push(res);
            return last;
        }
    }
}

