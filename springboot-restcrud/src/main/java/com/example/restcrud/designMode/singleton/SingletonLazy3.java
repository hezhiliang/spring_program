package com.example.restcrud.designMode.singleton;

/**
 * @Title: 单例模式之:懒汉式3(双重校验锁,成员变量不带'volatile'关键字)
 * @Author: hzl
 * @Description: 好处：实现了延迟加载，又解决了线程并发问题，同时还解决了执行效率问题
 * 缺点：JDK1.4之前多线程存在内存可见性问题，这里需要了解Java中的指令重排优化。所谓指令重排优化是指在不改变原语义的情况下，通过调整指令的执行顺序让程序运行的更快。
 * JVM中并没有规定编译器优化相关的内容，也就是说JVM可以自由的进行指令重排序的优化。
 * 这个问题的关键就在于由于指令重排优化的存在，导致初始化Singleton和将对象地址赋给instance字段的顺序是不确定的。
 * 在某个线程创建单例对象时，在构造方法被调用之前，就为该对象分配了内存空间并将对象的字段设置为默认值。
 * 此时就可以将分配的内存地址赋值给instance字段了，然而该对象可能还没有初始化。若紧接着另外一个线程来调用getInstance，取到的就是状态不正确的对象，程序就会出错。
 * @Date: Create in 2019/10/25 15:31
 * @Modified By:
 */
public class SingletonLazy3 {

    //1.创建private static对象实例
    private static SingletonLazy3 instance = null;

    //2.私有化构造器
    private SingletonLazy3() {
    }

    //3.公共方法获取实例
    public static SingletonLazy3 getInstance() {
        //第一道校验：大部分情况下，调用getInstance()都不会执行到同步代码块，从而提高了程序性能。
        if (instance == null) {
            synchronized (SingletonLazy3.class) {
                //第二道校验：为就解决两个线程依次执行同步代码块，并分别创建了一个单例对象。
                if (instance == null) {
                    instance = new SingletonLazy3();
                }
            }
        }
        return instance;
    }
}
