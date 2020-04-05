package com.zzw.multi_threading;

/**
 * OperationToObject
 *
 * @author Daydreamer
 * @date 2018/3/14 9:54
 */
public class StartDemo {
    public static void main(String[] args) {//主线程
        Runner1 r = new Runner1();
        //multi_threading(Runnable target)
        //多态，父类引用Runnable指向子类对象Runner1 r，有继承并重写了run方法
        Thread t = new Thread(r);
        //main方法继续往下执行，t内的对象r与main方法并行执行。
        // start方法启动线程并调用其run方法，两个线程并发运行。
        // 此时被启动的线程就绪了，等待时间片。
        t.start();
        for(int i = 0; i < 100; i++){
            System.out.println("MainThread:" + i);
        }
    }
}

//实现Runnable接口代表这是一个线程类
//能用Runnable接口就不用Thread类继承，因为接口更加灵活
//class Runner2 extends multi_threading
class Runner1 implements Runnable{
    public void run(){
        for (int i = 0; i < 100; i++){
            System.out.println("Runnable:" + i);
        }
    }
}