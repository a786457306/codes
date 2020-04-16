package com.zzw.multi_threading.synchronize;

import java.util.ArrayList;
import java.util.List;

/**
 * volatile不能保证多个线程同时修改running变量带来的不一致问题
 * 只保证可见性，不保证原子性
 * 不能替代synchronized
 *
 * synchronized 既保证可见性，又保证原子性
 *
 * @author Daydreamer
 * @date 2020/4/8 14:35
 */
public class VolatileNotAtomic {

    volatile int count = 0;

    // synchronized保证操作的原子性，不加就不能保证执行结果
    synchronized void m() {
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }

    public static void main(String[] args) {
        VolatileNotAtomic t = new VolatileNotAtomic();

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(t::m, "thread-" + i));
        }

        threads.forEach((o)->o.start());

        // 等待所有线程结束
        // join就是，当前线程停止，执行join方法的线程执行完后，当前线程再执行
        // 当线程被生成但未启动时，join不会执行该线程，会直接跳过
        threads.forEach((o)->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(t.count);
    }
}
