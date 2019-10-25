package com.example.restcrud.designMode.singleton;

/**
 * @Title: Java单例之枚举实现方式
 * @Author: hzl
 * @Description: 单元素的枚举类型已经成为实现Singleton的最佳方法。
 * @Date: Create in 2019/10/25 17:24
 * @Modified By:
 */
public class EnumSingleton {


    //1.私有构造器
    private EnumSingleton() {
    }

    //2.private static 的枚举
    private static enum SingletonEnum {
        /**
         * 枚举单例
         */
        INSTANCE;
        private EnumSingleton singleton;

        //JVM会保证此方法绝对只调用一次(枚举内部构造器,默认是私有的)
        private SingletonEnum() {
            singleton = new EnumSingleton();
        }

        public EnumSingleton getInstance() {
            return singleton;
        }
    }

    public static EnumSingleton getInstance() {
        return SingletonEnum.INSTANCE.getInstance();
    }

    public static void main(String[] args) {
        EnumSingleton instance1 = EnumSingleton.getInstance();
        EnumSingleton instance2 = EnumSingleton.getInstance();
        System.out.println("instance1 == instance2 ?" + (instance1 == instance2 ));
    }
}
