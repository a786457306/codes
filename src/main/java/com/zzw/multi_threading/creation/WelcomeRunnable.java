package com.zzw.multi_threading.creation;

/**
 * 实现Runnable接口，重写接口中的run方法，添加业务逻辑
 * 新建线程时使用带Runnable的构造方法，新建Runnable实例
 * 在主线程中开启线程后，jvm启动线程之后才会执行run方法中的内容
 */
public class WelcomeRunnable {
    public static void main(String[] args) {
        Thread welcome = new Thread(new WelcomeTask());
        welcome.start();
        System.out.println("start " + Thread.currentThread().getName());
    }
}

class WelcomeTask implements Runnable {

    @Override
    public void run() {
        System.out.println("welcome " + Thread.currentThread().getName());
    }
}
