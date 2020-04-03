package com.hepeng.baselibrary.bean;

import java.io.Serializable;

public class PatientListBean implements Serializable {

    /**
     * img : 201907/20190716212951-ca1ad080-a7cd-11e9-be03-0fc9b6b27fcb.png
     * createtime : 2019-07-05 06:00:03
     * prescriptcount : 0
     * patientid : 8183
     * sex : 0
     * ordercount : 1
     * content : 您的订单已经结束
     * realname : 王陈斌
     * imname :
     * typecode : 3
     * accountid : 17139
     * doctorid : 2015
     * id : 20512
     * msgtype : txt
     * age : 25
     * status : 171
     * username : 少年梦醉她城
     */

    private String img;
    private String createtime;
    private int prescriptcount;
    private int patientid;
    private int sex;
    private int ordercount;
    private String content;
    private String realname;
    private String imname;
    private int typecode;
    private int accountid;
    private int doctorid;
    private String id;
    private String msgtype = "";
    private int age;
    private int status;
    private String username;
    private String ext;
    private String idcard;

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public int getPrescriptcount() {
        return prescriptcount;
    }

    public void setPrescriptcount(int prescriptcount) {
        this.prescriptcount = prescriptcount;
    }

    public int getPatientid() {
        return patientid;
    }

    public void setPatientid(int patientid) {
        this.patientid = patientid;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getOrdercount() {
        return ordercount;
    }

    public void setOrdercount(int ordercount) {
        this.ordercount = ordercount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getImname() {
        return imname;
    }

    public void setImname(String imname) {
        this.imname = imname;
    }

    public int getTypecode() {
        return typecode;
    }

    public void setTypecode(int typecode) {
        this.typecode = typecode;
    }

    public int getAccountid() {
        return accountid;
    }

    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }

    public int getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(int doctorid) {
        this.doctorid = doctorid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
