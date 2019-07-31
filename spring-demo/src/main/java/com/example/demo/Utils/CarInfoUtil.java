package com.example.demo.Utils;

import com.example.demo.Annotation.CarNameTarget;
import com.example.demo.Annotation.CarSalerAnnotation;
import com.example.demo.Annotation.CarTypeAnnotatoin;

import java.lang.reflect.Field;

/**
 * create by hzl on 2018/7/1
 * 测试注解赋值
 */
public class CarInfoUtil {
    /**
     * 方法1：<T extends Annotation> T getAnnotation(Class<T> annotationClass): 返回该程序元素上存在的、指定类型的注解，如果该类型注解不存在，则返回null。
     　方法2：Annotation[] getAnnotations():返回该程序元素上存在的所有注解。
     　方法3：boolean is AnnotationPresent(Class< ?extends Annotation> annotationClass):判断该程序元素上是否包含指定类型的注解，存在则返回true，否则返回false.
     　方法4：Annotation[] getDeclaredAnnotations()：返回直接存在于此元素上的所有注释。与此接口中的其他方法不同，该方法将忽略继承的注释。（如果没有注释直接存在于此元素上，则返回长度为零的一个数组。）该方法的调用者可以随意修改返回的数组；这不会对其他调用者返回的数组产生任何影响。
     * @param clazz
     */
    public static void getFruitInfo(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();//获取声明的字段,不包括继承的字段
        for (Field field : fields) {
            //如果该字段是一个注解
            if (field.isAnnotationPresent(CarNameTarget.class)){
                CarNameTarget carName = (CarNameTarget)field.getAnnotation(CarNameTarget.class);
                String carColour = carName.CarName();
                System.out.println("汽车的中文名是:" + carColour);
            }else if (field.isAnnotationPresent(CarTypeAnnotatoin.class)){
                CarTypeAnnotatoin type = field.getAnnotation(CarTypeAnnotatoin.class);
                String carType = "汽车的类型是:" + type.Type().toString();
                System.out.println(carType);
            }else if(field.isAnnotationPresent(CarSalerAnnotation.class)){
                CarSalerAnnotation saler= field.getAnnotation(CarSalerAnnotation.class);
                String salerInfo = "销售员的名字是:" + saler.salerName() + " ,销售员的年龄是:" + saler.age();
                System.out.println(salerInfo);
            }



        }
    }

}
