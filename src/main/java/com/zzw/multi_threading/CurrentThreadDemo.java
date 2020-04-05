package com.zzw.multi_threading;

/**
 * CurrentThreadDemo
 *
 * @author Daydreamer
 * @date 2018/3/14 19:25
 */
public class CurrentThreadDemo {
    public static void main(String[] args) {
        Thread t = new Runner();
        t.start();
        for (int i = 0; i < 50; i++){
            System.out.println("MainThread:" + i);
        }
    }
}

class Runner extends Thread{
    public void run(){
        System.out.println(Thread.currentThread().isAlive());
        //判断当前线程是否处于活动状态
        for (int i = 0; i < 50; i++){
            System.out.println("SubThread:" + i);
        }
    }
}
