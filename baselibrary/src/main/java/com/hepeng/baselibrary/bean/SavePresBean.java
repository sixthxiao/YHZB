package com.hepeng.baselibrary.bean;

public class SavePresBean {
    private String id;
    private String title;
    private String date;
    private String url;
    private String prescriptid;

    public String getPrescriptid() {
        return prescriptid;
    }

    public void setPrescriptid(String prescriptid) {
        this.prescriptid = prescriptid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
