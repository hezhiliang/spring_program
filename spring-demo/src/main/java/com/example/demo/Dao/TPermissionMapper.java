package com.example.demo.Dao;

import com.example.demo.Bean.TPermission;
import com.example.demo.Utils.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TPermissionMapper extends MyMapper<TPermission> {
    //以下开始是自己写的sql方法
    List<TPermission> selectRolePermissionByRoleId(@Param("roleid") Integer roleid);


}