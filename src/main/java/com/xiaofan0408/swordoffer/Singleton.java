package com.xiaofan0408.swordoffer;

/**
 * @author xuzefan  2019/7/29 10:44
 */
public class Singleton {
}

/**
 *  单线程可行
 * */
class Singleton01 {
    private static Singleton01 instance;

    private Singleton01(){}

    public static Singleton01 getInstance() {
        if (instance == null) {
            instance = new Singleton01();
        }
        return instance;
    }
}

/**
 *  多线程可行效率低
 * */
class Singleton02{
    private static Singleton02 instance;

    private static Object lock = new Object();

    public static Singleton02 getInstance() {
        synchronized (lock){
            if (instance == null) {
                instance = new Singleton02();
            }
            return instance;
        }
    }
}

/**
 *  多线程可行(双重锁检查)
 * */
class Singleton03 {
    private static Singleton03 instance;

    private static Object lock = new Object();

    public static Singleton03 getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new Singleton03();
                }
            }
        }
        return instance;
    }
}


/**
 * 饿汉模式
 * */
class Singleton04{
    private static Singleton04 instance = new Singleton04();

    public static Singleton04 getInstance() {
        return instance;
    }
}

class Singleton05 {
    private static class SingletonHolder {
        private static Singleton05 ourInstance = new Singleton05();
    }
    public static Singleton05 getInstance() {
        return SingletonHolder.ourInstance;
    }
    private Singleton05() {
    }
}