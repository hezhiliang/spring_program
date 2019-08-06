package com.example.restcrud.component;

import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;

import java.util.Map;

/**
 * @Author: hzl
 * @Description: 自定义的 ErrorAttributes ,重写 父类DefaultErrorAttributes.getErrorAttributes()方法
 * @Date: Create in 2019/8/6 10:32
 * @Modified By:
 */
//给容器中加入自定义的 ErrorAttributes
@Component
public class MyErrorAttributes extends DefaultErrorAttributes{

    //返回值map就是页面和json能获取的所有字段
    @Override
    public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(requestAttributes, includeStackTrace); //获取父类定义的map

        //从请求域中获取自定义错误参数 == 我们的异常处理器携带的数据
        Map<String,Object> ext = (Map<String,Object>)requestAttributes.getAttribute("ext", RequestAttributes.SCOPE_REQUEST);

        //添加自定义的错误字段
        map.put("ext",ext);

        return map;
    }
}
