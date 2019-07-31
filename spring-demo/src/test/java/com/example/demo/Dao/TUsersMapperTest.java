package com.example.demo.Dao;

import com.example.demo.Bean.TUsers;
import com.github.pagehelper.PageHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TUsersMapperTest {

    @Autowired
    private TUsersMapper tUsersMapper;
    // 插入一条新记录
    @Test
    public void insertOne() {
        TUsers tUsers = new TUsers();
        String identityId = "436456435436";
        tUsers.setUsername("何智亮21");
        tUsers.setIdentityId(identityId);
        tUsers.setCreatetime("20180627");
        tUsers.setIphone("13566564565434");
        tUsers.setPermissionName("办公室");
        tUsersMapper.insertSelective(tUsers);
        System.out.println("插入成功");
    }

    // 批量插入记录(用不了)
    @Test
    public void insertMore() {
        List<TUsers> recordList = new ArrayList<TUsers>();
        for (int i = 0; i < 2; i++) {
            TUsers newUser = new TUsers();
            newUser.setUsername(i + "批量插入用户");
            newUser.setIphone("12345352345");
            newUser.setIdentityId(i + "是身份证号");
            recordList.add(newUser);
        }
//        tUsersMapper.insertList(recordList);
        System.out.println("批量插入成功");
    }

    // 根据唯一编号查询用户(通用Mapper查询)
    @Test
    public void selectByIphone() {
        TUsers paramBean = new TUsers();
        paramBean.setIphone("13906610633");
        TUsers dbUser = tUsersMapper.selectOne(paramBean);
        if (dbUser != null) {
            System.out.println("数据库用户(通用Mapper查询)：" + dbUser.getUsername());
            return;
        }
        System.out.println("查无此用户");
    }

    // 根据主键查询用户
    @Test
    public void selectById() {
        TUsers paramBean = new TUsers();
        paramBean.setId(3);
        TUsers dbUser = tUsersMapper.selectByPrimaryKey(paramBean);
        if (dbUser != null) {
            System.out.println("数据库用户(XML查询)：" + dbUser.getUsername());
            return;
        }
        System.out.println("查无此用户");
    }

    // 根据permission_name查询一组用户
    @Test
    public void selectByPermissionName() {
        TUsers paramBean = new TUsers();
        paramBean.setPermissionName("商事审判中心第一团队");
        List<TUsers> dbUserList = tUsersMapper.select(paramBean);
        System.out.println("总共查询数：" + dbUserList.size());
        for (TUsers tUsers : dbUserList) {
            System.out.println(tUsers);
        }
    }

    // 分页查询用户
    @Test
    public void selectByPage() {
        PageHelper.startPage(2,5);
        List<TUsers> dbUserList = tUsersMapper.select(null);
        for (TUsers item : dbUserList) {
            System.out.println("分页用户：" + item.getUsername());
        }
    }

    // 更新用户信息
    @Test
    public void updateOneInfo() {
        TUsers paramBean = new TUsers();
        paramBean.setId(1);
        paramBean.setUsername("盒子亮");
        tUsersMapper.updateByPrimaryKeySelective(paramBean);
        System.out.println("更新成功");
    }
}