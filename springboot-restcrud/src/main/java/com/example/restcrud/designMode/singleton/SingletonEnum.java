package com.example.restcrud.designMode.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Title:
 * @Author: hzl
 * @Description:
 * @Date: Create in 2019/10/25 17:47
 * @Modified By:
 */
public enum SingletonEnum {
    /**
     * 单例实例
     */
    INSTANCE;
    private  SingletonEnum(){

    }
    private  String name ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //获取枚举类的构造函数
        Constructor<SingletonEnum> constructor = SingletonEnum.class.getDeclaredConstructor(String.class, int.class);
        constructor.setAccessible(true);

        //利用反射创建枚举
        SingletonEnum otherInstance = constructor.newInstance("otherInstance", 9);

        /**
         * Exception in thread "main" java.lang.IllegalArgumentException: Cannot reflectively create enum objects
         at java.lang.reflect.Constructor.newInstance(Constructor.java:417)
         at com.example.restcrud.designMode.singleton.SingletonEnum.main(SingletonEnum.java:37)
         */
    }
}
