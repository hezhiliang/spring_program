package com.example.demo.Bean;

import javax.persistence.*;

@Table(name = "t_role_permission")
public class TRolePermission {
    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 角色主键
     */
    private Integer roleid;

    /**
     * 许可主键
     */
    private Integer permissionid;

    public TRolePermission(Integer id, Integer roleid, Integer permissionid) {
        this.id = id;
        this.roleid = roleid;
        this.permissionid = permissionid;
    }

    public TRolePermission() {
        super();
    }

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取角色主键
     *
     * @return roleid - 角色主键
     */
    public Integer getRoleid() {
        return roleid;
    }

    /**
     * 设置角色主键
     *
     * @param roleid 角色主键
     */
    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    /**
     * 获取许可主键
     *
     * @return permissionid - 许可主键
     */
    public Integer getPermissionid() {
        return permissionid;
    }

    /**
     * 设置许可主键
     *
     * @param permissionid 许可主键
     */
    public void setPermissionid(Integer permissionid) {
        this.permissionid = permissionid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", roleid=").append(roleid);
        sb.append(", permissionid=").append(permissionid);
        sb.append("]");
        return sb.toString();
    }
}