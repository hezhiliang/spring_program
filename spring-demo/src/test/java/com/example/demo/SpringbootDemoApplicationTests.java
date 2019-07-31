package com.example.demo;

import com.example.demo.Bean.TUsers;
import com.example.demo.Dao.TUsersMapper;
import com.example.demo.Model.CaseNodeVo;
import com.example.demo.Utils.ZipUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * springboot 单元测试:
 * 可以在测试期间很方便的类似于编码一样进行自动注入到容器中的功能
 */
@RunWith(SpringRunner.class)
@SpringBootTest
//@WebAppConfiguration
public class SpringbootDemoApplicationTests {

//	@Autowired
//	private TUsers users;

    @Autowired
    ApplicationContext ioc;

    @Autowired
    private CaseNodeVo caseNodeVo;

    @Autowired
    private TUsersMapper TUsersMapper;

    @Test
    public void test02(){
        List<TUsers> tUsers = TUsersMapper.selectAll();
        for (TUsers tUser : tUsers) {
            System.out.println(tUser);
        }
    }
    //	@Test
//    public void contextLoads() {
//        System.out.println(users);
//    }
    @Test
    public void testHelloService() {
        boolean bean = ioc.containsBean("helloService");
        System.out.println(bean );
        boolean bean1 = ioc.containsBean("tUsersMapper");
        System.out.println(bean1);
        boolean bean2= ioc.containsBean("TUsersMapper");
        System.out.println(bean2);
    }

    @Test
    public void testZip(){
        //压缩源路径
        String srcPath = "C:\\Users\\x1c\\Desktop\\nbzyb图表";
        //目标文件压缩后的压缩包文件名(.zip)
        String zipFileName= "压缩测试文件2.zip";
        ZipUtil.zip(srcPath,zipFileName);
    }

    @Test
    public void testFile(){

    }



}


