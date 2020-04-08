package com.zzw.multi_threading.synchronize;

import java.util.concurrent.TimeUnit;

/**
 * https://www.cnblogs.com/nexiyi/p/java_memory_model_and_thread.html
 *
 * volatile关键字，使变量在线程之间 可见 。无锁同步。
 * todo:内存可见性，禁止重排序，，，线程处理的内存模型——深入java虚拟机
 *
 * running存在读内存的test对象中
 * 当test1开始运行的时候，将running的值从堆内存中读取test1线程的工作区，运行过程中直接使用copy的值，
 * 而不是每次都读取堆内存。这时，主线程修改了running值，test1感知不到，所以死循环会一直持续。
 *
 * 使用volatile，每次running值更新，就强制所有线程重新去堆内存读取值（线程缓存值过期）。
 *
 * volatile不能保证多个线程同时修改变量值带来的不一致问题，不能代替synchronized。
 *
 * @author Daydreamer
 * @date 2020/4/5 15:26
 */
public class VolatileVisibility {

    // 加了volatile，变量在不同线程间均可见。比synchronized效率高很多很多，并发性好
//    volatile
    boolean running = true;

    // running为true，一直执行，若终止就改为false
    void m() {
        System.out.println("m start");
        while (running) {
            // 当cpu有空闲的时候，可能去主内存中刷新值，running值就会被刷新，但是无法保证时机
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("m end");
    }

    public static void main(String[] args) {
        VolatileVisibility test = new VolatileVisibility();

        new Thread(test::m, "test1").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 让死循环结束
        test.running = false;

    }
}
