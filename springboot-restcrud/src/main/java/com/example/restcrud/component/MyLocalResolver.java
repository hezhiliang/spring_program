package com.example.restcrud.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 编写国际化区域信息类
 * 实现LocaleResolver接口--区域信息解析器
 * 可以在URL链接上携带Local区域信息
 */
public class MyLocalResolver  implements LocaleResolver{

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String l = request.getParameter("l");
        //如果 请求参数上带l=zh_CN的参数的,就new一个local,把区域信息赋予进去
        //如果 请求参数l是空,则使用默认的local
        Locale locale = Locale.getDefault();
        if (!StringUtils.isEmpty(l)) {
            String[] split = l.split("_");
             locale = new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }


}
