package com.example.restcrud.designMode.singleton;

import java.io.Serializable;

/**
 * @Title: 设计模式之单例模式的缺点优化
 * @Author: hzl
 * @Description: 从上述单例模式的写法中，似乎也解决了效率与懒加载的问题，但是它们都有两个共同的缺点：
 * 缺点一：序列化可能会破坏单例模式，比如：每次反序列化一个序列化的对象实例时都会创建一个新的实例，解决方案如下：
 * 缺点二：使用反射可以强行调用私有构造器，导致创建一个新的实例。解决方式可以修改构造器，让它在创建第二个实例的时候抛异常，如下：
 * 以饿汉式（静态内部类）为例：
 * @Date: Create in 2019/10/25 16:49
 * @Modified By:
 */
public class SingletonSerializable implements Serializable {
    //1.使用静态内部类创建private static对象
    private static class SingletonHolder {
        private static SingletonSerializable INSTANCE = new SingletonSerializable();
    }

    private static volatile boolean flag = true;

    //2.私有化构造器
    private SingletonSerializable() {
        //【优化缺点二】判断是否第一次初始化，如果不是则抛异常阻止反射强行初始化
        if (flag) {
            flag = false;
        } else {
            throw new RuntimeException("The instance already exists!");
        }
    }

    //3.提供公共的静态方法
    public static SingletonSerializable getInstance() {
        return SingletonHolder.INSTANCE;
    }

    //【优化缺点一】反序列时直接返回当前INSTANCE
    private Object readObject() {
        return SingletonHolder.INSTANCE;
    }

    public static void main(String[] args) {
        System.out.println("测试是否是单例：");
        SingletonSerializable instance1 = SingletonSerializable.getInstance();
        SingletonSerializable instance2 = SingletonSerializable.getInstance();

        System.out.println("instance1 == instance2 ?" + (instance1 == instance2));

        System.out.println("测试是否允许初始化2次：");
        SingletonSerializable singleton1 = new SingletonSerializable();
        SingletonSerializable singleton2 = new SingletonSerializable();
    }

}
