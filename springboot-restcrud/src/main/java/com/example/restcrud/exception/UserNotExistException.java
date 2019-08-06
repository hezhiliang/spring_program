package com.example.restcrud.exception;

/**
 * @Author: hzl
 * @Description: 用户不存在异常类
 * @Date: Create in  2019/8/5 15:57
 * @Modified By:
 */
public class UserNotExistException extends RuntimeException {

    public UserNotExistException(){
        super("用户不存在!");
    }
}
