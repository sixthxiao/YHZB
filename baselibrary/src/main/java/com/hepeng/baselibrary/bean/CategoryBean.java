package com.hepeng.baselibrary.bean;

import java.io.Serializable;

public class CategoryBean implements Serializable {

    /**
     * hospitalid : 1
     * id : 68
     * title : 皮肤科
     * categoryid : 15
     */

    private int hospitalid;
    private int id;
    private String title;
    private int categoryid;
    private String letters;

    public String getLetters() {
        return letters;
    }

    public void setLetters(String letters) {
        this.letters = letters;
    }

    public int getHospitalid() {
        return hospitalid;
    }

    public void setHospitalid(int hospitalid) {
        this.hospitalid = hospitalid;
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

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }
}
