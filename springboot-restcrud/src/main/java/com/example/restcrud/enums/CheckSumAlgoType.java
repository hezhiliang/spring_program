package com.example.restcrud.enums;

/**
 * @Author: hzl
 * @Description: checksum 用到的算法枚举类
 * @Date: Create in 2019/10/17 10:24
 * @Modified By:
 */
public enum CheckSumAlgoType {

    MD5("MD5"),
    SHA_256("SHA-256"),
    SHA_512("SHA-512"),
    SHA_1("SHA1");

    private String name;

    private CheckSumAlgoType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
