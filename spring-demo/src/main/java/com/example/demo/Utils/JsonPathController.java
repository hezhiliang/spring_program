package com.example.demo.Utils;

import com.jayway.jsonpath.JsonPath;

import java.util.ArrayList;

public class JsonPathController {

    public static void main(String[] args) {
        String str="{\n" +
                "    \"store\": {\n" +
                "        \"book\": [\n" +
                "            {\n" +
                "                \"category\": \"reference\",\n" +
                "                \"author\": \"Nigel Rees\",\n" +
                "                \"title\": \"Sayings of the Century\",\n" +
                "                \"price\": 8.95\n" +
                "            },\n" +
                "            {\n" +
                "                \"category\": \"fiction\",\n" +
                "                \"author\": \"Evelyn Waugh\",\n" +
                "                \"title\": \"Sword of Honour\",\n" +
                "                \"price\": 12.99\n" +
                "            },\n" +
                "            {\n" +
                "                \"category\": \"fiction\",\n" +
                "                \"author\": \"Herman Melville\",\n" +
                "                \"title\": \"Moby Dick\",\n" +
                "                \"isbn\": \"0-553-21311-3\",\n" +
                "                \"price\": 8.99\n" +
                "            },\n" +
                "            {\n" +
                "                \"category\": \"fiction\",\n" +
                "                \"author\": \"J. R. R. Tolkien\",\n" +
                "                \"title\": \"The Lord of the Rings\",\n" +
                "                \"isbn\": \"0-395-19395-8\",\n" +
                "                \"price\": 22.99\n" +
                "            }\n" +
                "        ],\n" +
                "        \"bicycle\": {\n" +
                "            \"color\": \"red\",\n" +
                "            \"price\": 19.95\n" +
                "        }\n" +
                "    },\n" +
                "    \"expensive\": 10\n" +
                "}\n" +
                "                        ";
        System.out.println(str);

//        String duoTaiTest = "$.store.book[0].author";
//
//        String book1 = JsonPath.read(str, duoTaiTest);
//        System.out.println(book1);
        //第一种方式
//        String author = JsonPath.read(str,"$.store.book[*].author");
        //第二种方式
        ArrayList<Integer> list= JsonPath.parse(str).read("$..book.length()");
//        ArrayList<Integer> list = JsonPath.read(str, "$..book.length()");
        Integer integer = list.get(0);
        int bookNum = integer.intValue();


        System.out.println("book的数量是:"  + integer );
        System.out.println("book的数量是:"  + bookNum );

//        System.out.println("第一个book的author值是:" + read);


//        Object num = JsonPath.read(str, "$..book.length()");
//        System.out.println("num为:" + num );
//
//        int num = JsonPath.parse(str).read("$..book.length()");
//        System.out.println("num为:" + num );
        int num = JsonPath.read(str, "$.expensive");
        System.out.println("expensive的数量是:"  + num );

        ArrayList listAuthor = JsonPath.read(str, "$.store.book[*].author");
        System.out.println("所有的author是:" + listAuthor);

        for (Object o : listAuthor) {
            System.out.println(o);

        }

    }
}
