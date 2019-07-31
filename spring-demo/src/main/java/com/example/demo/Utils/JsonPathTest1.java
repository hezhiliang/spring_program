package com.example.demo.Utils;

import com.jayway.jsonpath.JsonPath;

import java.util.List;

public class JsonPathTest1 {

    public static void main(String[] args) {
        String str = "{\n" +
                "    \"totalRows\": 2,\n" +
                "    \"curPage\": 1,\n" +
                "    \"data\": [\n" +
                "        {\n" +
                "            \"xh\": \"1\",\n" +
                "            \"fymc\": \"德清县人民法院\",\n" +
                "            \"fybm1\": \"1349\",\n" +
                "            \"ahdm\": \"\",\n" +
                "            \"ah\": \"（2014）湖德立预字第00013号\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"xh\": \"2\",\n" +
                "            \"fymc\": \"德清县人民法院\",\n" +
                "            \"fybm1\": \"1349\",\n" +
                "            \"ahdm\": \"134900000060854\",\n" +
                "            \"ah\": \"（2014）湖德民初字第00573号\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"success\": \"true\"\n" +
                "}";
        System.out.println("string类型的json字符串为:" + str);

        Object read = JsonPath.read(str, "$.data[*].ahdm");
        System.out.println("所有的ahdm为:" + read);
        List<String> list = JsonPath.read(str, "$.data[*].ahdm");
        System.out.println("所有的ahdm为:" + list);
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            System.out.println("集合中的第" + (i+1) + "个元素为: " + s);
        }

    }
}
