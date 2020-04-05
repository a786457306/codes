package com.zzw.multi_threading.creation;

/**
 * 继承Thread类，重写run方法，在run方法里实现业务逻辑
 * 主线程里启动Thread，待jvm调用run方法之后才会实现多线程逻辑
 */
public class Welcome {

    public static void main(String[] args) {
        Thread welcome = new WelcomeThread();
        welcome.start();
        System.out.println("start " + Thread.currentThread().getName());
    }
}

class WelcomeThread extends Thread {
    @Override
    public void run() {
        System.out.println("welcome thread " + currentThread().getName());
    }
}
