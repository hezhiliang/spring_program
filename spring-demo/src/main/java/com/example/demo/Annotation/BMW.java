package com.example.demo.Annotation;

/**
 * 使用注解赋值
 */
public class BMW {

    @CarNameTarget(CarName = "宝马s4")
    private  String name;

    @CarSalerAnnotation(salerName = "Mark",age = 22)
    private String salerInfo;

    @CarTypeAnnotatoin(type = "BMW")
    private String type;

}
