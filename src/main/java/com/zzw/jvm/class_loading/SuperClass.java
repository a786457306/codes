package com.zzw.jvm.class_loading;

/**
 * SuperClass
 * 被动使用类字段：
 * 通过子类引用父类的静态字段不会导致类初始化
 *
 * @author Daydreamer
 * @date 2018/5/11 11:50
 */
public class SuperClass {
    static {
        System.out.println("SuperClass init!");
    }

    public static int value = 123;
}

class SubClass extends SuperClass{
    static {
        System.out.println("SubClass init!");
    }
}

/**
 * 非主动使用类字段演示
 */

class ConstClass{
    static {
        System.out.println("ConstClass init!");
    }
    public static final String HELLOWORLD = "hello world";
}

class NotInitialzation{
    public static void main(String[] args) {
        System.out.println(ConstClass.HELLOWORLD);
    }
}