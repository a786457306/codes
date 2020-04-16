package com.zzw.multi_threading.synchronize;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用AtomXX类，可以解决volatile带来的原子性问题
 * AtomXXX类的方法本身是原子性的，但是不能保证连续多个方法的调用整体是原子性的
 *
 * @author Daydreamer
 * @date 2020/4/9 18:02
 */
public class AtomicClass {

    AtomicInteger count = new AtomicInteger(0);

    void m() {
        for (int i = 0; i < 10000; i++) {
            // 原子性方法，代替count++
            // 两个原子性方法之间不是原子性的
//          if (count.get() < 1000){
            count.incrementAndGet();
//        }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        AtomicClass atomicClass = new AtomicClass();

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(atomicClass::m, "thread-" + i));
        }

        threads.forEach((o)->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(atomicClass.count);
    }

}
