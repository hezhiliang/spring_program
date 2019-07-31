package com.example.demo.Exception;

import java.util.Scanner;

/*
 * 自定义的异常测试类
 */
public class Student {
    public static void main(String[] args) {
        System.out.println("请输入一个整数:" );
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();

        CheckScore check = new CheckScore();
        try {
            check.check(score);
        } catch (MyException e) {// 用自己的异常类来捕获异常
            e.printStackTrace();
        }

        System.out.println("继续向下执行其他东西!");
    }

}