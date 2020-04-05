package com.zzw.multi_threading.creation;

public class ThreadCreationCmp {


    /**
     * 计数器
     */
    static class Counter {
        private int count = 0;

        public void increment(){
            count++;
        }

        public int value(){
            return count;
        }
    }

    /**
     * 开启计数任务，随机休眠，看计数结果
     */
    static class CountingTask implements Runnable {

        private Counter counter;

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                doSomething();
                counter.increment();
            }
            System.out.println("Counting Task:" + counter.value());
        }

        public void doSomething() {
            Tool.randomPause(80);
        }
    }

    static class CountingThread extends Thread {
        private Counter counter;

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                doSomething();
                counter.increment();
            }
            System.out.println("Counting Task:" + counter.value());
        }

        public void doSomething() {
            Tool.randomPause(80);
        }
    }
}
