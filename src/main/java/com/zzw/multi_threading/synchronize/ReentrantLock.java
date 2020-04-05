package com.zzw.multi_threading.synchronize;

import java.util.concurrent.TimeUnit;

/**
 * synchronized获取的锁是可重入的
 *
 * 一个同步方法可以调用另一个同步方法，
 * 执行同步方法的时候，当前线程已经获取了某个对象的锁
 * 再次执行同步方法的时候，再次申请锁，仍然可以申请到
 *
 * @author Daydreamer
 * @date 2020/4/5 14:45
 */
public class ReentrantLock {
    synchronized void m() {
        System.out.println("m.start");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        n();
    }

    synchronized void n() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("n.start");
    }
}
