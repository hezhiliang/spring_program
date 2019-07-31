package com.example.demo.Bean;

import javax.persistence.*;

@Table(name = "config")
public class Config {
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * cron表达式
     */
    @Column(name = "cron")
    private String cron;

    /**
     * 备注
     */
    @Column(name = "tips")
    private String tips;

    public Config(Integer id, String cron, String tips) {
        this.id = id;
        this.cron = cron;
        this.tips = tips;
    }

    public Config() {
        super();
    }

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取cron表达式
     *
     * @return cron - cron表达式
     */
    public String getCron() {
        return cron;
    }

    /**
     * 设置cron表达式
     *
     * @param cron cron表达式
     */
    public void setCron(String cron) {
        this.cron = cron == null ? null : cron.trim();
    }

    /**
     * 获取备注
     *
     * @return tips - 备注
     */
    public String getTips() {
        return tips;
    }

    /**
     * 设置备注
     *
     * @param tips 备注
     */
    public void setTips(String tips) {
        this.tips = tips == null ? null : tips.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", cron=").append(cron);
        sb.append(", tips=").append(tips);
        sb.append("]");
        return sb.toString();
    }
}