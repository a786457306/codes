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

    private Object o = new Object();

    /**
     * 互斥锁：同一时间只能一个线程获取锁
     *
     * 执行synchronized中的代码，必须获取o对象这把锁
     * 指的是堆内存中的对象，而不是它的引用：获取到的锁的信息记录在堆内存的对象信息中
     * 若此时引用指向了另一个对象，则锁的对象也会改变了
     *
     * 另一个线程中途来申请锁，要先等第一个线程释放锁
     */
    public void p() {
        synchronized (o) {
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }

    /**
     * 每次锁定自身对象即可，不用每次都特意new一个出来
     */
    public void m() {
        // 锁定的是对象
        synchronized (this) {
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }

    /**
     * 同上，方法上加synchronized，相当于synchronized(this)
     */
    public synchronized void n() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }
}
