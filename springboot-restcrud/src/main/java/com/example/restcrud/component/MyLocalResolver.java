package com.example.restcrud.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 编写自定义的国际化区域信息类
 * 实现LocaleResolver接口--区域信息解析器,使SpringMvc默认自动注入的 'localeResolver' 失效。
 * 目的：默认的Localeresolver是根据请求头"Accept-Language"带来的区域信息获取Locale进行国际化,
 *      自定义可以在URL链接上携带Local区域信息
 */
//注入到spring容器中，因为区域信息解析器属于SpringMvc的内部功能，所以统一写在了MyMvcConfig配置类中
public class MyLocalResolver  implements LocaleResolver{


    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String l = request.getParameter("l");//获取请求参数为字母'l'的值
        //如果 请求参数上带l=zh_CN的参数的,就new一个local,把区域信息赋予进去
        //如果 请求参数l是空,则使用默认的local
        Locale locale = Locale.getDefault();//获取默认的Local，使用操作系统默认的语言信息，即中文
        if (!StringUtils.isEmpty(l)) { //如果l参数不为空，则新建一个自定义的区域解析器
            String[] split = l.split("_");
            locale = new Locale(split[0],split[1]);//第一个参数是语言代码，第二个参数是国家代码
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }

}
