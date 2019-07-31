package com.example.demo.Model;

import org.springframework.stereotype.Component;

@Component
public class CaseNodeVo {
    private  int id;
    //推送标题
    private String title;

    //案号
    private String caseNo;

    //案号代码
    private  String caseId;

    //推送时间
    private String createTime;

    //推送内容
    private  String pushContent;

    //被推送入节点名称
    private  String contentName;

    //被推送人证件号码
    private  String identityId;

    //被推送人手机号码
    private String phone;

    public CaseNodeVo() {
    }

    public CaseNodeVo(int id, String title, String caseNo, String caseId, String createTime, String pushContent, String contentName, String identityId, String phone) {
        this.id = id;
        this.title = title;
        this.caseNo = caseNo;
        this.caseId = caseId;
        this.createTime = createTime;
        this.pushContent = pushContent;
        this.contentName = contentName;
        this.identityId = identityId;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getPushContent() {
        return pushContent;
    }

    public void setPushContent(String pushContent) {
        this.pushContent = pushContent;
    }

    public String getContentName() {
        return contentName;
    }

    public void setContentName(String contentName) {
        this.contentName = contentName;
    }

    public String getIdentityId() {
        return identityId;
    }

    public void setIdentityId(String identityId) {
        this.identityId = identityId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



    @Override
    public String toString() {
        return "CaseNodeVo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", caseNo='" + caseNo + '\'' +
                ", caseId='" + caseId + '\'' +
                ", createTime='" + createTime + '\'' +
                ", pushContent='" + pushContent + '\'' +
                ", contentName='" + contentName + '\'' +
                ", identityId='" + identityId + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
