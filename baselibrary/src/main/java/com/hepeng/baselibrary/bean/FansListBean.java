package com.hepeng.baselibrary.bean;

import java.io.Serializable;

public class FansListBean implements Serializable {

    /**
     * typecode : 0
     * createtime : 2019-05-05 19:51:00
     * img : login_head.png
     * phone : 13760295806
     * id : 70580
     * username : 国医在线5806
     * memberid : 31174
     */

    private int typecode;
    private String createtime;
    private String img;
    private String phone;
    private int id;
    private String username;
    private int memberid;
    private boolean isSelect = false;

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public int getTypecode() {
        return typecode;
    }

    public void setTypecode(int typecode) {
        this.typecode = typecode;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getMemberid() {
        return memberid;
    }

    public void setMemberid(int memberid) {
        this.memberid = memberid;
    }
}
