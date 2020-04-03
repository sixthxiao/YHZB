package com.hepeng.baselibrary.bean;

public class UpdateBean {

    /**
     * updatecontent : 更新说明
     * downurl :
     * updatecode : 0
     * version : 2.0.0
     */

    private String updatecontent;
    private String downurl;
    private String updatecode;
    private String version;

    public String getUpdatecontent() {
        return updatecontent;
    }

    public void setUpdatecontent(String updatecontent) {
        this.updatecontent = updatecontent;
    }

    public String getDownurl() {
        return downurl;
    }

    public void setDownurl(String downurl) {
        this.downurl = downurl;
    }

    public String getUpdatecode() {
        return updatecode;
    }

    public void setUpdatecode(String updatecode) {
        this.updatecode = updatecode;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
