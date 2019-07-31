package com.example.demo.Dao;

import com.example.demo.Bean.TRolePermission;
import com.example.demo.Utils.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TRolePermissionMapper extends MyMapper<TRolePermission> {

    int insertPermission(@Param("permission_ids") List<Integer> permission_ids, @Param("roleid") Integer roleid);
}