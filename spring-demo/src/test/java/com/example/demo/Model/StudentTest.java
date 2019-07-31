package com.example.demo.Model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentTest {

    /**
     * 接口 Comparable<T>
     此接口强行对实现它的每个类的对象进行整体排序。这种排序被称为类的自然排序，类的 compareTo 方法被称为它的自然比较方法。
     实现此接口的对象列表（和数组）可以通过 Collections.sort（和 Arrays.sort）进行自动排序。实现此接口的对象可以用作有序映射中的键或有序集合中的元素，无需指定比较器。

     * 总结:我们可以使用Comparable接口中的compareTo方法使原本无法比较的对象通过某种自身条件来排序.
     */
    @Test
    public void compareTo() {
        Student s1 = new Student(101, "小强", 89.5);
        Student s2 = new Student(102, "大强", 56.5);
        Student s3 = new Student(103, "小飞", 90);


        List<Student> slist = new ArrayList<Student>();
        slist.add(s1);
        slist.add(s2);
        slist.add(s3);

        System.out.println("排序前-------------------");
        for (Student s : slist) {
            System.out.println(s.getScore());
        }

        Collections.sort(slist);

        System.out.println("排序后-------------------");
        for (Student s : slist) {
            System.out.println(s.getScore());
        }

        System.out.println("最高分为" + slist.get(slist.size() - 1).getScore());
    }

}