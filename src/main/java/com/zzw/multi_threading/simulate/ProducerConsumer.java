package com.zzw.multi_threading.simulate;

/**
 * ProducerConsumer
 * 生产者消费者问题
 *
 * @author Daydreamer
 * @date 2018/3/16 14:21
 */
public class ProducerConsumer {
    public static void main(String[] args) {
        SyncStack ss = new SyncStack();
        Producer p = new Producer(ss);
        Consumer c = new Consumer(ss);//两线程都访问这个框
        new Thread(p).start();
        new Thread(c).start();
    }
}
class WoTou{
    int id;
    WoTou(int id){
        this.id = id;
    }

    public String toString(){
        return "WoTou:" + id;
    }
}

class SyncStack{
    int index = 0;
    WoTou[] arrWT = new WoTou[6];

    public synchronized void push(WoTou wt){
        while (index == arrWT.length){
            try {
                this.wait();//正在访问当前对象的线程wait
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        this.notify();//叫醒在wait的线程，使其继续执行
        arrWT[index] = wt;
        index++;
    }

    public synchronized WoTou pop(){
        while (index == 0){
            try {
                this.wait();//空了也等待
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        this.notify();
        index--;
        return arrWT[index];
    }
}

class Producer implements Runnable{
    SyncStack ss = null;
    Producer(SyncStack ss){
        this.ss = ss;
    }
    public void run(){
        for (int i = 0; i < 20; i++){
            WoTou wt = new WoTou(i);
            ss.push(wt);
            System.out.println("生产了" + wt);
        }
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable{
    SyncStack ss = null;
    Consumer(SyncStack ss){
        this.ss = ss;
    }
    public void run(){
        for (int i = 0; i < 20; i++){
            WoTou wt = ss.pop();
            System.out.println("消费了" + wt);
        }
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}