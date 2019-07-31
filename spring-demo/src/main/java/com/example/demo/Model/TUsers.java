package com.example.demo.Model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
/**
 * @ConfigurationProperties  告诉springboot容器本类中的所有属性和application.properties配置文件中的相关配置进行绑定(默认只能从全局配置文件中读取)
 * 注意:还需要加入@Component,把这些属性导入容器中
 * @ConfigurationProperties与@Value的对比:
 * 前者支持松散绑定(比如驼峰命名法),后者不支持.
 * 前者不支持spEL表达式语言,后者支持.
 * 前者支持JSR303数据校验,后者不支持
 * 前者支持复杂类型的封装,后者只能拿简单的数据类型
 */

//@ImportResource     //导入Spring的配置文件
//@Component
//@ConfigurationProperties(prefix = "tUser")
//@Validated //开启数据校验功能,JSR303数据校验
@PropertySource(value = "classpath:tUser.properties")//这个注解可以加载指定的配置文件
public class TUsers {
//    @Value("#{10*20}")
    private Integer id;
//    @Email
    @Value("${tUser.loginacct}")
    private String loginacct;

    private String username;

    private String userpswd;


    private String fixPhone;


    private String iphone;

    private String fgUserid;

    private String identityId;

    private String createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginacct() {
        return loginacct;
    }

    public void setLoginacct(String loginacct) {
        this.loginacct = loginacct;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpswd() {
        return userpswd;
    }

    public void setUserpswd(String userpswd) {
        this.userpswd = userpswd;
    }

    public String getFixPhone() {
        return fixPhone;
    }

    public void setFixPhone(String fixPhone) {
        this.fixPhone = fixPhone;
    }

    public String getIphone() {
        return iphone;
    }

    public void setIphone(String iphone) {
        this.iphone = iphone;
    }

    public String getFgUserid() {
        return fgUserid;
    }

    public void setFgUserid(String fgUserid) {
        this.fgUserid = fgUserid;
    }

    public String getIdentityId() {
        return identityId;
    }

    public void setIdentityId(String identityId) {
        this.identityId = identityId;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "TUsers{" +
                "id=" + id +
                ", loginacct='" + loginacct + '\'' +
                ", username='" + username + '\'' +
                ", userpswd='" + userpswd + '\'' +
                ", fixPhone='" + fixPhone + '\'' +
                ", iphone='" + iphone + '\'' +
                ", fgUserid='" + fgUserid + '\'' +
                ", identityId='" + identityId + '\'' +
                ", createtime='" + createtime + '\'' +
                '}';
    }
}