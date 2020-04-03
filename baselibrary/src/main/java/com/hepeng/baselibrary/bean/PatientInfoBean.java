package com.hepeng.baselibrary.bean;

import android.text.TextUtils;

public class PatientInfoBean {

    /**
     * imgs :
     * orderno : 20190707113939_5222
     * sex : 1
     * specialtime :
     * weight : 16
     * nativefullname :
     * content : 孩子舌苔白腻，胃口不好，经常出汗，大便干燥
     * realname : 伊伊
     * imname :
     * typecode : 1
     * nativename :
     * stature : 106
     * id : 20653
     * nativeid :
     * age : 5
     * status : 172
     */

    private String imgs;
    private String orderno;
    private int sex;
    private String specialtime;
    private int weight;
    private String nativefullname;
    private String content;
    private String realname;
    private String imname;
    private int typecode;
    private String nativename;
    private int stature;
    private int id;
    private String nativeid;
    private int age;
    private int status;

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getSpecialtime() {
        if (TextUtils.isEmpty(specialtime)) {
            return "暂无";
        }
        return specialtime;
    }

    public void setSpecialtime(String specialtime) {
        this.specialtime = specialtime;
    }

    public int getWeight() {
        if (weight < 0) {
            return 0;
        }
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getNativefullname() {
        return nativefullname;
    }

    public void setNativefullname(String nativefullname) {
        this.nativefullname = nativefullname;
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

    public String getNativename() {
        return nativename;
    }

    public void setNativename(String nativename) {
        this.nativename = nativename;
    }

    public int getStature() {
        if (stature < 0) {
            return 0;
        }
        return stature;
    }

    public void setStature(int stature) {
        this.stature = stature;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNativeid() {
        return nativeid;
    }

    public void setNativeid(String nativeid) {
        this.nativeid = nativeid;
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
}
