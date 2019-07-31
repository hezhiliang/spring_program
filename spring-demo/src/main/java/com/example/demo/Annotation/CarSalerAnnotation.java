package com.example.demo.Annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface CarSalerAnnotation {
    public  String salerName() default  "";

    public int age() default 1;
}
