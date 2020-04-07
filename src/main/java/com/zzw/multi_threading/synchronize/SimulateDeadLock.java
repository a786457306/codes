package com.zzw.multi_threading.synchronize;

/**
 * 模拟死锁
 *
 * @author Daydreamer
 * @date 2020/4/7 14:00
 */
public class SimulateDeadLock {

    public Object o1 = new Object();

    public Object o2 = new Object();

    public void m() {
        try {
            synchronized (o1) {
                System.out.println(Thread.currentThread().getName() + "执行m, 拿到o1");
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName() + "执行m, 想要o2");
                synchronized (o2) {
                    System.out.println(Thread.currentThread().getName() + "执行m, 拿到o2");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void n() {
        try {
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName() + "执行n, 拿到o2");
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName() + "执行n, 想要o1");
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName() + "执行n, 拿到o1");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SimulateDeadLock t = new SimulateDeadLock();

        new Thread(t::m, "thread1").start();
        new Thread(t::n, "thread2").start();
    }
}
