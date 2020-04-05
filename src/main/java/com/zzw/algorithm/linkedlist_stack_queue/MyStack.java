package com.zzw.algorithm.linkedlist_stack_queue;

import java.io.IOException;
import java.util.Scanner;

/**
 * MyStack
 *
 * @author Daydreamer
 * @date 2018/3/25 17:00
 */
public class MyStack {
    private int maxSize;
    private char[] stackArray;
    private int top;//栈顶

    public MyStack(int s){
        maxSize = s;
        stackArray = new char[maxSize];
        top = -1;//初始化栈，栈顶指针为-1
    }

    public void push(char value){
        stackArray[++top] = value;//栈顶指针一直指向元素
    }

    public char pop(){
        return stackArray[top--];
    }

    public char peek(){//看栈顶元素是啥
        return stackArray[top];
    }

    public boolean isEmpty(){
        return (top == -1);//top = -1 则栈为空
    }

    public boolean isFull(){
        return (top == maxSize - 1);
    }
}

/**
 * 左右分隔符匹配,读到左分隔符就入栈，读到右分隔符就从栈中弹出左分隔符与之匹配。
 * 匹配成功则正常进行。非分隔符不插入栈中，忽略。
 */

class separatorMate{
    private static String input;

    public void check(){
        int stackSize  = input.length();
        MyStack stack = new MyStack(stackSize);

        for (int j = 0; j < stackSize; j++){
            char ch = input.charAt(j);
            switch (ch){
                case '{' :
                case '[' :
                case '(' :
                    stack.push(ch);
                    break;

                case ')':
                case ']':
                case '}':
                    if (!stack.isEmpty()){
                        char chx = stack.pop();
                        if ((ch == '}' && chx != '{') ||
                                (ch == '[' && chx != ']') ||
                                (ch == '(' && chx != ')'))
                            System.out.println("Error:" + ch + "at" + j);
                    }
                    else
                        System.out.println("Error:" + ch + "at" + j);
                    break;
                default:
                    break;
            }
        }
        if (!stack.isEmpty()){
            System.out.println("Error: missing right delimiter");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        input = sc.nextLine();

    }
}

class wordReverse{//单词逆序
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        MyStack stack = new MyStack(s.length());
        char[] c = s.toCharArray();
        String input = "";
        for (int i = 0; i < c.length; i++){
            stack.push(c[i]);
        }
        for (int i = 0; i < c.length; i++){
            input = input + stack.pop();
        }
        System.out.println(input);
    }
}