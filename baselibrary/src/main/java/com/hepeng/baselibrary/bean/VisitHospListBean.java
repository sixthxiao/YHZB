package com.hepeng.baselibrary.bean;

import java.io.Serializable;

public class VisitHospListBean implements Serializable {

    /**
     * hosHospitalname : 国医在线
     * address : 77
     * regionid : 2584
     * id : 1
     * hosHospitalid : 5
     */

    private String hosHospitalname;
    private String address;
    private String regionid;
    private String regionname;
    private String id;
    private String hosHospitalid;
    private String color;

    public String getHosHospitalname() {
        return hosHospitalname;
    }

    public void setHosHospitalname(String hosHospitalname) {
        this.hosHospitalname = hosHospitalname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRegionid() {
        return regionid;
    }

    public void setRegionid(String regionid) {
        this.regionid = regionid;
    }

    public String getRegionname() {
        return regionname;
    }

    public void setRegionname(String regionname) {
        this.regionname = regionname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHosHospitalid() {
        return hosHospitalid;
    }

    public void setHosHospitalid(String hosHospitalid) {
        this.hosHospitalid = hosHospitalid;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
