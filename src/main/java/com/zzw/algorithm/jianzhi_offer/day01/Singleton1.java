package com.zzw.algorithm.jianzhi_offer.day01;

/**
 * Singleton1
 * 饿汉式
 *
 * @author Daydreamer
 * @date 2018/8/20 19:14
 */
public class Singleton1 {

    private static final Singleton1 singleton = new Singleton1();

    private Singleton1(){
    }

    public Singleton1 getSingleton(){
        return singleton;
    }

}
