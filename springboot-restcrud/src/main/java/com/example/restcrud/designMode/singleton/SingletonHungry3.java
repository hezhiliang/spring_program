package com.example.restcrud.designMode.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Title: 单例模式之：饿汉式3(静态内部类【推荐】)
 * @Author: hzl
 * @Description: 这种方式同样利用了类加载机制来保证只创建一个instance实例。它与饿汉模式一样，也是利用了类加载机制，因此不存在多线程并发的问题。
 * 不一样的是，它是在内部类里面去创建对象实例。
 * 这样的话，只要应用中不使用内部类，JVM就不会去加载这个单例类，也就不会创建单例对象，从而实现懒汉式的延迟加载。也就是说这种方式可以同时保证延迟加载和线程安全。
 * @Date: Create in 2019/10/25 15:22
 * @Modified By:
 */
public class SingletonHungry3 {
    private static class SingletonHolder {
        //1.静态内部类里面创建对象
        private static SingletonHungry3 instance = new SingletonHungry3();
    }

    //2.私有化构造器
    private SingletonHungry3() {
    }

    //3.公共static方法
    public static SingletonHungry3 getInstance() {
        return SingletonHolder.instance;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        /**
         * 验证单例
         */
        SingletonHungry3 instance1 = SingletonHungry3.getInstance();
        SingletonHungry3 instance2 = SingletonHungry3.getInstance();
        System.out.println("instance1 == instance2 ?" + (instance1 == instance2));

        /**
         * 弊端一：使用反射可以强行调用私有构造器，导致创建一个新的实例。解决方式可以修改构造器，让它在创建第二个实例的时候抛异常
         */
        //通过反射获取构造器
        Constructor<SingletonHungry3> constructor = SingletonHungry3.class.getDeclaredConstructor();
        //创建一个新实例
        SingletonHungry3 otherInstance = constructor.newInstance();
        System.out.println("instance1 == otherInstance ?" + (instance1 == otherInstance));

    }
}
