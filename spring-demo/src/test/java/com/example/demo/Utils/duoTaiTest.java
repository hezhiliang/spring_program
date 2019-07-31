package com.example.demo.Utils;

/**
 * 面向对象之"多肽性"
 * 关于类型转换的题目
 * One -- 父类
 * Two -- 子类
 *
 * 总结:
 *  One t = new Two();
 *  ①父类引用可以指向子类的对象,子类的引用,不可以指向父类的对象.
 *  ②对于强制类型转换，且是引用类型，如果是父类向子类转换，这种只牵扯到引用名义类型的转换，具体的内存没有什么变化(本质上还是子类的对象)。
 */
public class duoTaiTest {

    static class One {
        public void foo() {
            System.out.println("One");
        }
    }

    static class Two extends One {
        @Override
        public void foo() {
            System.out.println("Two");
        }

        public void dosth() {
            System.out.println("Two again");
        }
    }

    public static void main(String[] args) throws Exception {
        One t = new Two(); //向上转型，即父类引用指向子类对象，此时子类对象的类型为父类的类型
        System.out.println(t);
        if (t instanceof Two) {
            System.out.println("t是子类对象,本质上t是子类对象,父类引用指向子类对象.");
            t.foo();
//        t.dosth();//编译错误
            ((Two) t).dosth();//编译成功
        } else if (t instanceof One) {
            System.out.println("t是父类对象");
        }

        System.out.println("=====================================");

        t = (Two) t;//父类强制转换为子类,这种只牵扯到引用名义类型的转换，具体的内存没有什么变化(本质上还是子类的对象)。
        System.out.println(t);
        if (t instanceof Two) {
            System.out.println("t是子类对象,本质上t是子类对象,父类引用指向子类对象.");
            t.foo();
//        t.dosth();//编译错误,                 因为这里t本质上是子类对象,但是名义上还是父类,然而父类是没有dosth()方法的,所以编译不通过.
            ((Two) t).dosth();//编译成功        这里t已经由父类强制转换为子类,所以名义上是子类()
        } else if (t instanceof One) {
            System.out.println("t是父类对象");
        }


    }
}
