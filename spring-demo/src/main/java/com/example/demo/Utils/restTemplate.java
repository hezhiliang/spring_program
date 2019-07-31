package com.example.demo.Utils;

import net.minidev.json.JSONObject;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Map;

public class restTemplate {

    public static String post(Map<String, Object> params ){
        //1.设置restTemplate的初始编码为utf-8
        StringHttpMessageConverter m = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        RestTemplate restTemplate = new RestTemplateBuilder().additionalMessageConverters( m ).build();

        //2.构造请求头
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());

        //3.把params对象转换为String字符串
        String jsonStr = JSONObject.toJSONString(params);

        //4、构建请求实体对象
        HttpEntity<String> formEntity = new HttpEntity<String>(jsonStr, headers);

//        String result = restTemplate.getForObject("http://www.baidu.com", String.class,formEntity);
        String result = restTemplate.postForObject("http://www.baidu.com", formEntity, String.class);
        return result;
    }


}
