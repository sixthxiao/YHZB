package com.hepeng.baselibrary.bean;

import java.io.Serializable;

public class DoctorStrongBean implements Serializable {

    /**
     * id :
     * title :
     */

    private String id;
    private String title;

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
}
