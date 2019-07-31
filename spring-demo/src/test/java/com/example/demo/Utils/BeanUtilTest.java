package com.example.demo.Utils;

import com.example.demo.Model.SourceDemo;
import com.example.demo.Model.TargetDemo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * org.springframework.beans.BeanUtils与org.apache.commons.beanutils.BeanUtils都提供了copyProperties方法，作用是将一个Bean对象中的数据封装到另一个属性结构相似的Bean对象中
 1）两者的copyProperties方法参数位置不同
 　　org.springframework.beans.BeanUtils:　　copyProperties(sourceDemo, targetDemo)
 　　org.apache.commons.beanutils.BeanUtils:　　copyProperties(targetDemo, sourceDemo)

 2）要求两个Bean的属性名相同，且有对应的setXxx方法和getXxx方法。其实底层原理是使用sourceDemo的getXxx方法和targetDemo的setXxx方法

 3）sourceDemo有的属性而targetDemo没有的属性，不会封装到targetDemo对象中；
 　  targetDemo有的属性而sourceDemo没有的属性，会封装到targetDemo中，数据为默认值（注意基本类型默认值与引用类型默认值不同）
    注：使用两种BeanUtils效果相同

 4）类型转换问题
 　 a）基本类型与其对应的封装类型可以相互转换

 　 b）org.springframework.beans.BeanUtils与org.apache.commons.beanutils.BeanUtils对于String和Date类型转换的情况是不同的，具体看以下案例:

 结论一：org.springframework.beans.BeanUtils.copyProperties不可以将java.util.Date类型转换成String类型,同时：也不可将java.sql.Date类型转换成String类型

 结论二：org.apache.commons.beanutils.BeanUtils.copyProperties可以将java.util.Date类型转换成String类型,格式为: Mon Jul 09 11:42:06 CST 2018
        org.apache.commons.beanutils.BeanUtils.copyProperties可以将java.sql.Date类型转换成String类型,格式为: 1970-01-24
        注意：虽然都可以转换，但发现两者的日期格式还是不同的,

 结论三：org.springframework.beans.BeanUtils.copyProperties不可以将String类型转换成java.util.Date类型,同时：也不可将String类型转换成java.sql.Date类型

 结论四：org.apache.commons.beanutils.BeanUtils
        看错误日志，发现说是默认的转换器是不可以将String类型转换成java.util.Date，可能自己配置一个转换器就可以转了吧，我没有测试过

 结论五：org.apache.commons.beanutils.BeanUtils
        看错误日志，发现说是需要将String类型转成java.sql.Date，使用simpleDateFormat是将String类型转成java.util.Date，可能转成java.sql.Date就可以了吧，我没测试过
        注意:我这里说的转换，单纯是指这一行代码sourceDemo.setCreateTime(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(0)));而不是两个Bean的类型转换

 总之，无论是org.springframework.beans.BeanUtils还是org.apache.commons.beanutils.BeanUtils，默认情况下都不能将String类型转成Date类型

 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BeanUtilTest.class)
public class BeanUtilTest {
    @Test
    public  void test01() throws InvocationTargetException, IllegalAccessException {
        SourceDemo sourceDemo = new SourceDemo();
        sourceDemo.setId(10);
        sourceDemo.setAge(10.2323);
        sourceDemo.setName("姓名");
        sourceDemo.setAddress("地址");
        sourceDemo.setCreateTime(new Date());
        sourceDemo.setUpdateTime(new java.sql.Date(1996030611));

        TargetDemo targetDemo = new TargetDemo();
        org.springframework.beans.BeanUtils.copyProperties(sourceDemo, targetDemo);
        System.out.println("============org.springframework.beans.BeanUtils包:" + targetDemo);
        org.apache.commons.beanutils.BeanUtils.copyProperties(targetDemo, sourceDemo);
        System.out.println("============org.apache.commons.beanutils.BeanUtils包:" + targetDemo);
    }

}
