package com.hepeng.baselibrary.bean;

public class PharmBean {

    /**
     * keycode : 50004
     * address : 云南省大理白族自治州宾川县全球通大道中段
     * kindname : 中药饮片
     * express : 宾川百世快递
     * id : 4
     * title : 宾川县中医医院药房
     * phartype : 0
     * kindid : 2
     */

    private String keycode;
    private String address;
    private String kindname;
    private String express;
    private int id;
    private String title;
    private int phartype;
    private int kindid;
    private boolean isSelect;

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public String getKeycode() {
        return keycode;
    }

    public void setKeycode(String keycode) {
        this.keycode = keycode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getKindname() {
        return kindname;
    }

    public void setKindname(String kindname) {
        this.kindname = kindname;
    }

    public String getExpress() {
        return express;
    }

    public void setExpress(String express) {
        this.express = express;
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

    public int getPhartype() {
        return phartype;
    }

    public void setPhartype(int phartype) {
        this.phartype = phartype;
    }

    public int getKindid() {
        return kindid;
    }

    public void setKindid(int kindid) {
        this.kindid = kindid;
    }
}
