package com.zzw.multi_threading.synchronize;

import java.util.concurrent.TimeUnit;

/**
 * synchronized获取的锁是可重入的
 * 同一线程，同一把锁，一个同步方法可以调用另一个同步方法，
 * 执行同步方法的时候，当前线程已经获取了某个对象的锁；再次执行同步方法的时候，再次申请锁，仍然可以申请到
 *
 * 在锁的数字上 + 1
 * todo：具体实现方式
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

/**
 * 继承中可能发生，子类调用父类的同步方法
 * 也可以获取到锁
 */
class ReentrantLockParent {
    synchronized void m() {
        System.out.println(this);
        System.out.println("m.start");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m.end");
    }

    public static void main(String[] args) {
        // 锁定sub对象，子类调父类也可以
        // this对象
        new ReentrantLockSub().m();
    }
}

class ReentrantLockSub extends ReentrantLockParent {

    @Override
    synchronized void m() {
        System.out.println(this);
        System.out.println("sub m.start");
        super.m();
        System.out.println("sub m.end");
    }
}
