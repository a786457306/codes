package com.zzw.multi_threading.synchronize;

import java.util.concurrent.TimeUnit;

/**
 * volatile关键字
 *
 * @author Daydreamer
 * @date 2020/4/5 15:26
 */
public class VolatileTest {

    boolean running = true;

    void m() {
        System.out.println("m start");
        while (running) {
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("m end");
        }
    }

    public static void main(String[] args) {
        VolatileTest test = new VolatileTest();

        new Thread(test::m, "test1").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        test.running = false;
        new Thread(test::m, "test2").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
