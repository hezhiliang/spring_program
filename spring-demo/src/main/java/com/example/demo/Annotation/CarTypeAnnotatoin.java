package com.example.demo.Annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface CarTypeAnnotatoin {
    public String type() ;

    public String Type() default "BMW";
}
