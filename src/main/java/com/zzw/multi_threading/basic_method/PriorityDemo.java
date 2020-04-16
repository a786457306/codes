package com.zzw.multi_threading.basic_method;

/**
 * PriorityDemo
 *
 * @author Daydreamer
 * @date 2018/3/14 12:30
 */
public class PriorityDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(new T1());
        Thread t2 = new Thread(new T2());
        //t1优先级提高3级，执行t1的时间片变长。
        t1.setPriority(Thread.NORM_PRIORITY + 3);
        t1.start();
        t2.start();
    }

}
class T1 implements Runnable{
    public void run(){
        for (int i = 0; i < 100; i++){
            System.out.println("T1:" + i);
        }
    }
}

class T2 implements Runnable{
    public void run(){
        for (int i = 0; i < 100; i++){
            System.out.println("=====T2:" + i);
        }
    }
}