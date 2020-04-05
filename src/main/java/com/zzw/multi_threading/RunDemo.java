package com.zzw.multi_threading;

import java.util.Date;

/**
 * ThreadDemo2
 *
 * @author Daydreamer
 * @date 2018/3/14 10:27
 */
//主线程睡眠了
public class RunDemo {
    public static void main(String[] args) {//主线程
        MyThread thread = new MyThread();
        //继承Thread类，可直接调用。start方法调用run方法。
        // start后子线程就绪，等待时间片
        thread.start();
        try {
            Thread.sleep(10000);//主线程暂停10秒
        }catch (InterruptedException e){}
        //10s后主线程停止休眠状态/sleep状态，打断子线程，让子线程结束
//        thread.interrupt();
        thread.shutDown();
    }
}

class MyThread extends Thread{//实现Runnable接口代表这是一个线程类
    boolean flag = true;
    public void run(){
        while(flag){//flag=false线程就结束了，比interrupt温柔
            System.out.println("===" + new Date() + "===");
            //当线程被打断时sleep方法要抛出异常，但重写方法不能抛出与被重写方法不同的异常，所以只能用try catch
            //每隔一秒钟（sleep1000秒）把时间打印一次
            try {
                sleep(1000);
            }catch (InterruptedException e){
                //线程被打断则抛异常，被打断后return。这种方式比较粗暴。
                return;
            }
        }
    }
    public void shutDown(){
        flag = false;
    }
}