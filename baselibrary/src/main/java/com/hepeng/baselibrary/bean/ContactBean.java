package com.hepeng.baselibrary.bean;

import java.io.Serializable;

public class ContactBean implements Serializable {

    /**
     * createtime : 2019-10-31 09:48:12
     * orderno : A20191031094812_13885
     * patientid : 18447
     * sex : 1
     * realname : 罗晓丹
     * typecode : 1
     * accountid : 65536
     * focustype : 2
     * phone :
     * id : 32806
     * age : 28
     * memberid : 62770
     * username : Seirios
     */

    private String createtime;
    private String img;
    private String orderno;
    private String patientid;
    private int sex;
    private String realname;
    private int typecode;
    private String accountid;
    private String focustype;
    private String phone;
    private String id;
    private int age;
    private int memberid;
    private String username;
    private boolean isSelect = false;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public String getPatientid() {
        return patientid;
    }

    public void setPatientid(String patientid) {
        this.patientid = patientid;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public int getTypecode() {
        return typecode;
    }

    public void setTypecode(int typecode) {
        this.typecode = typecode;
    }

    public String getAccountid() {
        return accountid;
    }

    public void setAccountid(String accountid) {
        this.accountid = accountid;
    }

    public String getFocustype() {
        return focustype;
    }

    public void setFocustype(String focustype) {
        this.focustype = focustype;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMemberid() {
        return memberid;
    }

    public void setMemberid(int memberid) {
        this.memberid = memberid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
