package com.example.demo.Bean;

import javax.persistence.*;

@Table(name = "t_user_role")
public class TUserRole {
    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 角色主键
     */
    private Integer roleid;

    private Integer userid;

    public TUserRole(Integer id, Integer roleid, Integer userid) {
        this.id = id;
        this.roleid = roleid;
        this.userid = userid;
    }

    public TUserRole() {
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
     * @return userid
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * @param userid
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", roleid=").append(roleid);
        sb.append(", userid=").append(userid);
        sb.append("]");
        return sb.toString();
    }
}