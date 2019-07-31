package com.example.demo.Utils;

import java.util.Comparator;

public class Comparators2 {
    public  static Comparator getComparators2(){

        return new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }

            public int compare(String o1,String o2){
                return 0;
            };

            public int compare(char o1,char o2){
                return 0;
            };

            public int compare(Integer o1,Integer o2){
                return 0;
            };

        };

    }
}
