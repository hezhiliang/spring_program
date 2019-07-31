package com.example.demo.Annotation;

import java.lang.reflect.Method;

public class testAnnotation {
    @MyAnnotation
    public void doSomething() { }

    public static void main(String[] args) throws NoSuchMethodException {
           Method method = testAnnotation.class.getMethod("doSomething",null);
           if (method.isAnnotationPresent(MyAnnotation.class)){
               //可以判断出方法是不是存在MyAnnotation的注解
               System.out.println(method.getAnnotation(MyAnnotation.class));//@com.example.demo.Annotation.MyAnnotation()
           }
    }
}
