package com.zzw.multi_threading.basic_method;

/**
 * JoinDemo
 *
 * @author Daydreamer
 * @date 2018/3/14 11:47
 */
public class JoinDemo {
    public static void main(String[] args) {
        MyThread2 t1 = new MyThread2("t1");
        t1.start();
        try {
            //join：两线程合并，t1加入到main线程中，所以先执行完t1再执行main方法
            t1.join();
        } catch (InterruptedException e){}
        for (int i = 1; i <= 10; i++){
            System.out.println("main thread");
        }
    }
}

/**
 * public multi_threading(String name) {
 *      init(null, null, name, 0);
 * }
 */
class MyThread2 extends Thread {
    MyThread2(String s) {
        super(s);
    }
    public void run(){
        for (int i = 1; i <= 10; i++){
            System.out.println("i am " + getName());
            try {
                sleep(1000);
            } catch (InterruptedException e){
                return;
            }
        }
    }
}
