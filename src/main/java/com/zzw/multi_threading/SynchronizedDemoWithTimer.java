package com.zzw.multi_threading;

/**
 * SynchronizedDemo
 *
 * @author Daydreamer
 * @date 2018/3/14 19:36
 */
//自身是线程类
//public class SynchronizedDemo implements Runnable{
//    Timer timer = new Timer();
//    public static void main(String[] args) {
//        SynchronizedDemo test = new SynchronizedDemo();
//        multi_threading t1 = new multi_threading(test);
//        multi_threading t2 = new multi_threading(test);
//        t1.setName("t1");
//        t2.setName("t2");
//        t1.start();
//        t2.start();
//    }
//
//    public void run(){
//        timer.add(multi_threading.currentThread().getName());
//    }
//}
//
//class Timer{
//    private static int num = 0;
//    public void add(String name){
//        //第一个线程访问时num++，从0变1.第一个线程睡眠，第二个线程执行。
//        //第二个线程访问同一个对象，还是num。num变成2。
//        //然后第一个线程被唤醒，两个都执行run方法，两个都是2.
//        //结果输出t1，t2都是第二个的原因就是执行中途被打断了，有一个线程暂停了
//        num++;
//        //执行的线程都要睡眠1毫秒
//        try {
//            multi_threading.sleep(1);
//        } catch (InterruptedException e){}
//        System.out.println(name + ", 你是第" + num + "个");
//
//    }
//}

public class SynchronizedDemoWithTimer implements Runnable{
    Timer timer = new Timer();
    public static void main(String[] args) {
        SynchronizedDemoWithTimer test = new SynchronizedDemoWithTimer();
        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test);
        if(t1.equals(t2))
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }

    public void run(){
        timer.add(Thread.currentThread().getName());
    }
}

class Timer{
    private static int num = 0;
    public synchronized void add(String name){//在执行该方法过程中锁定当前对象
        //synchronized (this) {//互斥锁
            //锁定，一个线程在进入锁定区域后，执行时不会被另一个线程打断
            num++;
            try {
                Thread.sleep(1);//sleep时也不会释放锁，必须执行完成后才释放。若想访问同一个对象必须等着。
            } catch (InterruptedException e) {
            }
            System.out.println(name + ", 你是第" + num + "个");
       // }
    }
}
