package com.zzw.multi_threading.synchronize;

import java.util.concurrent.TimeUnit;

/**
 * 使用synchronized给程序加锁，当程序出现异常时，锁自动释放
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
                // 此处抛出异常，锁被释放。若不想锁被释放，catch住异常，循环继续执行
                int i = 1/0; // throw exception
            }
        }
    }

    public static void main(String[] args) {
        ReleaseLockAutomatically re = new ReleaseLockAutomatically();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                re.m();
            }
        };
        new Thread(runnable, "runnable1").start();
        new Thread(runnable, "runnable2").start();
    }
}
