package com.zzw.algorithm.jianzhi_offer.day01;

/**
 * Singleton2
 * 懒汉式
 *
 * @author Daydreamer
 * @date 2018/8/20 21:39
 */
public class Singleton2 {

    private static Singleton2 singleton = null;

    private Singleton2(){}

    public synchronized static Singleton2 getSingleton(){
        if (singleton == null){
            singleton = new Singleton2();
        }
        return singleton;
    }
}
