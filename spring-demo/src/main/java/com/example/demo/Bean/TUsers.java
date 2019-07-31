package com.example.demo.Bean;

import javax.persistence.*;

@Table(name = "t_users")
public class TUsers {
    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 用户昵称(对应第三方接口的name)
     */
    private String username;

    /**
     * 固定电话
     */
    @Column(name = "fix_phone")
    private String fixPhone;

    /**
     * 手机(对应第三方接口的sjhm)
     */
    private String iphone;

    /**
     * 法官id(预留)(对应第三方接口的oa_userid)
     */
    @Column(name = "fg_userid")
    private String fgUserid;

    /**
     * 身份证号
     */
    @Column(name = "identity_id")
    private String identityId;

    /**
     * 创建时间
     */
    private String createtime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private String updateTime;

    /**
     * 部门名(用于通讯录筛选)
     */
    @Column(name = "permission_name")
    private String permissionName;

    public TUsers(Integer id, String username, String fixPhone, String iphone, String fgUserid, String identityId, String createtime, String updateTime, String permissionName) {
        this.id = id;
        this.username = username;
        this.fixPhone = fixPhone;
        this.iphone = iphone;
        this.fgUserid = fgUserid;
        this.identityId = identityId;
        this.createtime = createtime;
        this.updateTime = updateTime;
        this.permissionName = permissionName;
    }

    public TUsers() {
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
     * 获取用户昵称(对应第三方接口的name)
     *
     * @return username - 用户昵称(对应第三方接口的name)
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户昵称(对应第三方接口的name)
     *
     * @param username 用户昵称(对应第三方接口的name)
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 获取固定电话
     *
     * @return fix_phone - 固定电话
     */
    public String getFixPhone() {
        return fixPhone;
    }

    /**
     * 设置固定电话
     *
     * @param fixPhone 固定电话
     */
    public void setFixPhone(String fixPhone) {
        this.fixPhone = fixPhone == null ? null : fixPhone.trim();
    }

    /**
     * 获取手机(对应第三方接口的sjhm)
     *
     * @return iphone - 手机(对应第三方接口的sjhm)
     */
    public String getIphone() {
        return iphone;
    }

    /**
     * 设置手机(对应第三方接口的sjhm)
     *
     * @param iphone 手机(对应第三方接口的sjhm)
     */
    public void setIphone(String iphone) {
        this.iphone = iphone == null ? null : iphone.trim();
    }

    /**
     * 获取法官id(预留)(对应第三方接口的oa_userid)
     *
     * @return fg_userid - 法官id(预留)(对应第三方接口的oa_userid)
     */
    public String getFgUserid() {
        return fgUserid;
    }

    /**
     * 设置法官id(预留)(对应第三方接口的oa_userid)
     *
     * @param fgUserid 法官id(预留)(对应第三方接口的oa_userid)
     */
    public void setFgUserid(String fgUserid) {
        this.fgUserid = fgUserid == null ? null : fgUserid.trim();
    }

    /**
     * 获取身份证号
     *
     * @return identity_id - 身份证号
     */
    public String getIdentityId() {
        return identityId;
    }

    /**
     * 设置身份证号
     *
     * @param identityId 身份证号
     */
    public void setIdentityId(String identityId) {
        this.identityId = identityId == null ? null : identityId.trim();
    }

    /**
     * 获取创建时间
     *
     * @return createtime - 创建时间
     */
    public String getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间
     *
     * @param createtime 创建时间
     */
    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    /**
     * 获取部门名(用于通讯录筛选)
     *
     * @return permission_name - 部门名(用于通讯录筛选)
     */
    public String getPermissionName() {
        return permissionName;
    }

    /**
     * 设置部门名(用于通讯录筛选)
     *
     * @param permissionName 部门名(用于通讯录筛选)
     */
    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", fixPhone=").append(fixPhone);
        sb.append(", iphone=").append(iphone);
        sb.append(", fgUserid=").append(fgUserid);
        sb.append(", identityId=").append(identityId);
        sb.append(", createtime=").append(createtime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", permissionName=").append(permissionName);
        sb.append("]");
        return sb.toString();
    }
}