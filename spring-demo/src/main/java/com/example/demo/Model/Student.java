package com.example.demo.Model;

/**
 * Comparator和Complable的区别
 *Comparable可以认为是一个内比较器，实现了Comparable接口的类有一个特点，就是这些类是可以和自己比较的，至于具体和另一个实现了Comparable接口的类如何比较，则依赖compareTo方法的实现，compareTo方法也被称为自然比较方法。如果开发者add进入一个Collection的对象想要Collections的sort方法帮你自动进行排序的话，那么这个对象必须实现Comparable接口。compareTo方法的返回值是int，有三种情况：
         1、比较者大于被比较者（也就是compareTo方法里面的对象），那么返回正整数
         2、比较者等于被比较者，那么返回0
         3、比较者小于被比较者，那么返回负整数

 Comparator可以认为是是一个外比较器，个人认为有两种情况可以使用实现Comparator接口的方式：
     1、一个对象不支持自己和自己比较（没有实现Comparable接口），但是又想对两个对象进行比较
     2、一个对象实现了Comparable接口，但是开发者认为compareTo方法中的比较方式并不是自己想要的那种比较方式
 Comparator接口里面有一个compare方法，方法有两个参数T o1和T o2，是泛型的表示方式，分别表示待比较的两个对象，方法返回值和Comparable接口一样是int，有三种情况：
     1、o1大于o2，返回正整数
     2、o1等于o2，返回0
     3、o1小于o2，返回负整数

 [总结一下]，两种比较器Comparable和Comparator，后者相比前者有如下优点：
 1、如果实现类没有实现Comparable接口，又想对两个类进行比较（或者实现类实现了Comparable接口，但是对compareTo方法内的比较算法不满意），那么可以实现Comparator接口，自定义一个比较器，写比较算法
 2、实现Comparable接口的方式比实现Comparator接口的耦合性 要强一些，如果要修改比较算法，要修改Comparable接口的实现类，而实现Comparator的类是在外部进行比较的，不需要对实现类有任何修 改
 */
public class Student implements Comparable<Student> {
    private int sid; //学号
    private String sname; //姓名
    private double score; //分数

    @Override
    public int compareTo(Student s) {
        int result = 0;
        if (s instanceof Student) {
            if (this.score > s.getScore()) {
                return 1; //正整数是大于
            } else if (this.score < s.getScore()) {
                return -1;//负整数是小于
            }
        }
        return result;
    }

    public Student() {
    }

    public Student(int sid, String sname, double score) {
        this.sid = sid;
        this.sname = sname;
        this.score = score;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }


}
