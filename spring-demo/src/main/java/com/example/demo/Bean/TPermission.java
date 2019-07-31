package com.example.demo.Bean;

import javax.persistence.*;

@Table(name = "t_permission")
public class TPermission {
    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private String createTime;

    /**
     * 名称
     */
    private String name;

    @Column(name = "reform_name")
    private String reformName;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private String updateTime;

    public TPermission(Integer id, String createTime, String name, String reformName, String updateTime) {
        this.id = id;
        this.createTime = createTime;
        this.name = name;
        this.reformName = reformName;
        this.updateTime = updateTime;
    }

    public TPermission() {
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
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    /**
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return reform_name
     */
    public String getReformName() {
        return reformName;
    }

    /**
     * @param reformName
     */
    public void setReformName(String reformName) {
        this.reformName = reformName == null ? null : reformName.trim();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", createTime=").append(createTime);
        sb.append(", name=").append(name);
        sb.append(", reformName=").append(reformName);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}