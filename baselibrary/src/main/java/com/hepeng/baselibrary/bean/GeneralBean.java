package com.hepeng.baselibrary.bean;

public class GeneralBean {

    /**
     * keycode : 1
     * sysdicid : 3
     * remark : null
     * id : 10
     * title : 不要吃辣
     * remark2 : null
     */

    private String keycode;
    private int sysdicid;
    private String remark;
    private int id;
    private String title;
    private String remark2;
    private boolean select=false;

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }

    public String getKeycode() {
        return keycode;
    }

    public void setKeycode(String keycode) {
        this.keycode = keycode;
    }

    public int getSysdicid() {
        return sysdicid;
    }

    public void setSysdicid(int sysdicid) {
        this.sysdicid = sysdicid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }
}
