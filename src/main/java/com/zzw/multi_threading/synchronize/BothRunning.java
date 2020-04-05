package com.zzw.multi_threading.synchronize;

/**
 * 同步方法和非同步方法方法可以同时执行，因为执行第二个方法不需要获取锁
 *
 * @author Daydreamer
 * @date 2020/4/5 14:15
 */
public class BothRunning {

    public synchronized void m() {
        System.out.println(Thread.currentThread().getName() + "m.start...");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "m end");
    }

    public void n() {
        System.out.println(Thread.currentThread().getName() + "n.start...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "n end");
    }

    public static void main(String[] args) {
        BothRunning bothRunning = new BothRunning();

        new Thread(() -> bothRunning.m(), "bothRunning1").start();
        new Thread(() -> bothRunning.n(), "bothRunning2").start();
    }
}
