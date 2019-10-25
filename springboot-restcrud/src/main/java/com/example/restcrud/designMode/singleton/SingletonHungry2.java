package com.example.restcrud.designMode.singleton;

/**
 * @Title: 单例模式之：饿汉式2(静态代码块)
 * @Author: hzl
 * @Description:
 * @Date: Create in 2019/10/25 15:22
 * @Modified By:
 */
public class SingletonHungry2 {
    //1.创建private static对象
    private static SingletonHungry2 instance = null;
    static {
        instance = new SingletonHungry2();
    }

    //2.私有化构造器
    private SingletonHungry2() {
    }

    //3.公共static方法
    public static SingletonHungry2 getInstance() {
        return instance;
    }

}
