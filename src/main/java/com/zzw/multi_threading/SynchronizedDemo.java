package com.zzw.multi_threading;

/**
 * SynchronizedDemo
 *
 * @author Daydreamer
 * @date 2018/3/15 15:02
 */
public class SynchronizedDemo implements Runnable{
    private int flag = 1;
    static Object o1,o2;
    public void run(){
        if (flag == 1){
            synchronized (o1) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e){}
                synchronized (o2){
                    System.out.println("1");
                }
            }
        }

        if (flag == 0){
            synchronized (o2){
                try{
                    Thread.sleep(500);
                }catch (InterruptedException e){}
                synchronized (o1){
                    System.out.println("0");
                }
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedDemo s1 = new SynchronizedDemo();
        SynchronizedDemo s2 = new SynchronizedDemo();
        Thread t1 = new Thread(s1);
        Thread t2 = new Thread(s2);
        s1.flag = 1;
        s2.flag = 0;
        t1.start();
        t2.start();
    }
}
