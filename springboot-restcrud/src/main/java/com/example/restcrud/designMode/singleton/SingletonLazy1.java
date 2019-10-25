package com.example.restcrud.designMode.singleton;

/**
 * @Title: 单例模式之懒汉式1:非线程安全
 * @Author: hzl
 * @Description: 好处：懒汉模式中单例是在需要的时候才去创建的，如果单例已经创建，再次调用获取接口将不会重新创建新的对象，而是直接返回之前创建的对象。
 * 适用于：如果某个单例使用的次数少，并且创建单例消耗的资源较多，那么就需要实现单例的按需创建，这个时候使用懒汉模式就是一个不错的选择。
 * 缺点：但是这里的懒汉模式并没有考虑线程安全问题，在多个线程可能会并发调用它的getInstance()方法，导致创建多个实例
 * @Date: Create in 2019/10/25 15:31
 * @Modified By:
 */
public class SingletonLazy1 {

    //1.创建private static对象实例
    private static SingletonLazy1 instance = null;

    //2.私有化构造器
    private SingletonLazy1() {
    }

    //3.公共方法获取实例
    public static SingletonLazy1 getInstance() {
        if (instance == null) {
            instance = new SingletonLazy1();
        }
        return instance;
    }
}
