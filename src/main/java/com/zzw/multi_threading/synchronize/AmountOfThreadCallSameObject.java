package com.zzw.multi_threading.synchronize;

/**
 * 每个线程都对count进行操作，操作的过程中，不允许其他线程访问
 *
 * synchronized是原子操作，不可分，中间是不允许其他线程操作的
 *
 * @author Daydreamer
 * @date 2020/4/5 11:04
 */
public class AmountOfThreadCallSameObject implements Runnable {

    private int count = 10;

    @Override
    public synchronized void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    /**
     * 5个线程同时访问t对象中的run方法
     * 可能出现在一个线程刚做完减操作，还没有打印，其他线程来访问，在打印之前又减了两次
     * 75677
     * 加锁即可
     *
     * @param args
     */
    public static void main(String[] args) {
        AmountOfThreadCallSameObject t = new AmountOfThreadCallSameObject();
        for (int i = 0; i < 5; i++) {
            new Thread(t, "THREAD" + i).start();
        }
    }
}
