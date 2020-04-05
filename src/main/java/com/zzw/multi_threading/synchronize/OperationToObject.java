package com.zzw.multi_threading.synchronize;

/**
 * synchronized 锁定对象，而非方法
 * 任何方法要执行synchronized中的代码，都要先拿到锁
 *
 * @author Daydreamer
 * @date 2020/4/5 10:41
 */
public class OperationToObject {

    private int count = 10;

    public void m() {
        // 锁定的是对象
        synchronized (this) {
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }

    // 同上，方法上加synchronized，相当于synchronized(this)
    public synchronized void n() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }
}
