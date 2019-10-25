package com.example.restcrud.designMode.singleton;

/**
 * @Title: 单例模式之懒汉式4:双重校验锁【推荐】(为了解决多线程内存可见性问题,成员变量加'volatile'关键字)
 * @Author: hzl
 * @Description: 好处：实现了延迟加载，又解决了线程并发问题，同时还解决了执行效率问题,加'volatile'关键字保证下一个读取操作会在前一个写操作之后发生。
 * @Date: Create in 2019/10/25 15:31
 * @Modified By:
 */
public class SingletonLazy4 {

    /**
     * 1.创建private static对象实例
     * volatile的一个语义是禁止指令重排序优化，也就保证了instance变量被赋值的时候对象已经是初始化过的，从而避免可见性问题。
     *
     * @Description： volatile 关键字：
     * 优点：当多个线程访问共享数据时，可以保证多个线程的数据彼此可见的。
     * 原理：volatile 低层使用内存栅栏，可以保证主存的缓存数据实时刷新。
     * 缺点：
     * 不能保证“互斥性”。
     * 不能保证数据的“原子性”。	（以i++原子性为例）
     * @Question: 如何解决原子性问题？
     * jdk1.5以后，在jave.util.concurrent.atomic下提供了原子变量，可以解决原子性问题。
     * 1)  volatile 解决了内存可见性问题。
     * 2)  CAS(Compare-And-Swap) 算法解决了原子性问题。
     * CAS 是硬件对于并发操作的解决办法
     * CAS 包含了三个操作数
     * V : 内存值
     * A : 预估值
     * B : 更新值
     * 思路仅当V == A 时，V = B 。否则，不做任何操作。
     * 简单来说，比较和替换是使用一个期望值和一个变量的当前值进行比较，如果当前变量的值与我们期望的值相等，就使用一个新值替换当前变量的值
     */
    private static volatile SingletonLazy4 instance = null;

    //2.私有化构造器
    private SingletonLazy4() {
    }

    //3.公共方法获取实例
    public static SingletonLazy4 getInstance() {
        //第一道校验：大部分情况下，调用getInstance()都不会执行到同步代码块，从而提高了程序性能。
        if (instance == null) {
            synchronized (SingletonLazy4.class) {
                //第二道校验：为就解决两个线程依次执行同步代码块，并分别创建了一个单例对象。
                if (instance == null) {
                    instance = new SingletonLazy4();
                }
            }
        }
        return instance;
    }
}
