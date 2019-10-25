package com.example.restcrud.designMode.singleton;

/**
 * @Title: 单例模式之懒汉式2:适合多线程(方法加锁:线程安全、性能差)
 * @Author: hzl
 * @Description:
 * @Date: Create in 2019/10/25 15:31
 * @Modified By:
 */
public class SingletonLazy2 {

    //1.创建private static对象实例
    private static SingletonLazy2 instance = null;

    //2.私有化构造器
    private SingletonLazy2() {
    }

    //3.公共方法获取实例（加锁 线程安全、性能差）
    public static synchronized SingletonLazy2 getInstance() {
        if (instance == null) {
            instance = new SingletonLazy2();
        }
        return instance;
    }
}
