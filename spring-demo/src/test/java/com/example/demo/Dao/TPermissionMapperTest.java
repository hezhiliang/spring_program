package com.example.demo.Dao;

import com.example.demo.Bean.TPermission;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TPermissionMapperTest {
    @Autowired
    private TPermissionMapper tPermissionMapper;

    @Test
    public void selectRolePermissionByRoleId() {
        List<TPermission> tPermissions = tPermissionMapper.selectRolePermissionByRoleId(2);
        for (TPermission tPermission : tPermissions) {
            System.out.println(tPermission);
        }
    }
}