package com.zzw.multi_threading.synchronize;

/**
 * 仍然是对对象加锁，但是static没有this，不new对象
 *
 * @author Daydreamer
 * @date 2020/4/5 10:53
 */
public class OperationToClass {

    private static int count = 10;

    public synchronized static void m() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void n() {
        synchronized (OperationToClass.class) {
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }
}
