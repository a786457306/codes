package com.zzw.multi_threading.synchronize;

import java.util.concurrent.TimeUnit;

/**
 * 写加锁，读不加锁，多线程情况下可能会出现脏读问题
 * 同步方法执行过程中，可能被非同步方法读取到执行过程中的数据
 *
 * set睡两秒钟，第一秒去读，读到set前的数，
 * 再睡两秒去读，读到set之后的数
 *
 * @author Daydreamer
 * @date 2020/4/7 11:42
 */
public class DirtyRead {

    String name;
    double balance;

    public synchronized void set(String name, double balance) {
        this.name = name;

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.balance = balance;
    }

    public /* synchronized */ double getBalance(String name) {
        return this.balance;
    }

    public static void main(String[] args) {
        DirtyRead account = new DirtyRead();
        new Thread(() -> account.set("zhangsan", 100.0)).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // set之前
        System.out.println(account.getBalance("zhangsan"));

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // set之后
        System.out.println(account.getBalance("zhangsan"));
    }
}
