package com.zzw.multi_threading;

/**
 * DeadLockDemo
 * 模拟线程死锁过程
 *
 * @author Daydreamer
 * @date 2018/3/14 20:43
 */
//一个线程类模拟两个线程
public class DeadLockDemo implements Runnable{
    public int flag = 1;
    static Object o1 = new Object(), o2 = new Object();
    public void run() {
        System.out.println("flag = " + flag);
        //先1再2
        if (flag == 1){
            synchronized (o1){
                try{
                    Thread.sleep(500);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                synchronized (o2){
                    System.out.println("1");
                }
            }

        }
        //先2再1
        if (flag == 0){
            synchronized (o2){
                try{
                    Thread.sleep(500);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                synchronized (o1){
                    System.out.println("0");
                }
            }
        }
    }

    public static void main(String[] args) {
        DeadLockDemo d1 = new DeadLockDemo();
        d1.flag = 1;
        DeadLockDemo d2 = new DeadLockDemo();
        d2.flag = 0;
        Thread t1 = new Thread(d1);
        Thread t2 = new Thread(d2);
        t1.start();
        t2.start();
    }
}
