package com.zzw.multi_threading.synchronize;

import java.util.concurrent.TimeUnit;

/**
 * 使用synchronized给程序加锁，当程序出现异常时，锁自动释放
 * 不想释放就加try catch
 * catch住异常后可以做事务回滚
 *
 * r1释放锁，r2获取锁，继续执行
 *
 * @author Daydreamer
 * @date 2020/4/5 14:58
 */
public class ReleaseLockAutomatically {

    int count = 0;
    synchronized void m() {
        System.out.println(Thread.currentThread().getName() + " start");
        while (true) {
            count++;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 5) {
                // 此处抛出异常，锁被释放。
                // 若不想锁被释放，catch住异常，循环继续执行
                int i = 1/0; // throw exception
            }
        }
    }

    /**
     * 若不抛出异常，2永远不会执行
     *
     * @param args
     */
    public static void main(String[] args) {
        ReleaseLockAutomatically re = new ReleaseLockAutomatically();

        new Thread(re::m, "runnable1").start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(re::m, "runnable2").start();
    }
}
