package com.zzw.multi_threading.creation;

public class JavaThreadAnywhere {
    public static void main(String[] args) {
//      当前线程
        Thread currentThread = Thread.currentThread();
//      当前线程名
        String currentThreadName = currentThread.getName();
        System.out.println("The main method was expected by thread: " + currentThreadName);

        Helper helper = new Helper("Java thread anywhere");
        helper.run();
    }

    static class Helper implements Runnable {
        private final String message;

        public Helper(String message) {
            this.message = message;
        }

        @Override
        public void run() {
            doSomething(message);
        }

        private void doSomething(String message) {
            Thread currentThread = Thread.currentThread();
            String currentThreadName = currentThread.getName();
            System.out.println("The doSomething method was expected by thread: " + currentThreadName);
            System.out.println("Do something with " + message);
        }
    }
}

