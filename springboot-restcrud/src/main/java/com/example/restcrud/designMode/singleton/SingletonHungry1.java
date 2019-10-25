package com.example.restcrud.designMode.singleton;

/**
 * @Title: 单例模式之：饿汉式1(均是基于类加载机制避免了多线程的同步问题)
 * @Author: hzl
 * @Description:
 * @Date: Create in 2019/10/25 15:22
 * @Modified By:
 */
public class SingletonHungry1 {
    //1.创建private static对象
    private static SingletonHungry1 instance = new SingletonHungry1();

    //2.私有化构造器
    private SingletonHungry1() {
    }

    //3.公共static方法
    public static SingletonHungry1 getInstance() {
        return instance;
    }

}
