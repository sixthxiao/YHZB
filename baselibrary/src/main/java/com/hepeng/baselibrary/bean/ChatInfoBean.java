package com.hepeng.baselibrary.bean;

import android.text.TextUtils;

import java.io.Serializable;

public class ChatInfoBean implements Serializable {

    /**
     * orderno : A20191026170722_65128
     * patientimname : 17261426201910_63106
     * patientid : 18449
     * patientsex : 1
     * endtime : null
     * starttime : null
     * doctorname : 张天(国医在线)
     * doctorimname : 03211524201909_22825
     * doctorimg : 201907/2771475748884258.jpg
     * typecode : 0
     * patientname : 吴美琪
     * accountid : 19254
     * doctorid : 2020
     * hospitalid : 52
     * idcard : 532326199104252226
     * patientage : 28
     * hospitalname : 寻甸县中医医院
     * id : 32810
     * hostype : 1
     * doctorimpwd : mH8ZsFPxx24GwNyP
     * patientimpwd : C8Q3hN2ZpT63WxnR
     */

    private String orderno;
    private String patientimname;
    private String patientid;
    private int patientsex;
    private String endtime;
    private String starttime;
    private String doctorname;
    private String doctorimname;
    private String doctorimg;
    private int typecode;
    private String patientname;
    private String accountid;
    private String doctorid;
    private int hospitalid;
    private String idcard;
    private int patientage;
    private String hospitalname;
    private String id;
    private int hostype;
    private String doctorimpwd;
    private String patientimpwd;
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public String getPatientimname() {
        return patientimname;
    }

    public void setPatientimname(String patientimname) {
        this.patientimname = patientimname;
    }

    public String getPatientid() {
        return patientid;
    }

    public void setPatientid(String patientid) {
        this.patientid = patientid;
    }

    public int getPatientsex() {
        return patientsex;
    }

    public void setPatientsex(int patientsex) {
        this.patientsex = patientsex;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getStarttime() {
        if (TextUtils.isEmpty(starttime)) {
            return "0";
        }
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getDoctorname() {
        return doctorname;
    }

    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname;
    }

    public String getDoctorimname() {
        return doctorimname;
    }

    public void setDoctorimname(String doctorimname) {
        this.doctorimname = doctorimname;
    }

    public String getDoctorimg() {
        return doctorimg;
    }

    public void setDoctorimg(String doctorimg) {
        this.doctorimg = doctorimg;
    }

    public int getTypecode() {
        return typecode;
    }

    public void setTypecode(int typecode) {
        this.typecode = typecode;
    }

    public String getPatientname() {
        return patientname;
    }

    public void setPatientname(String patientname) {
        this.patientname = patientname;
    }

    public String getAccountid() {
        return accountid;
    }

    public void setAccountid(String accountid) {
        this.accountid = accountid;
    }

    public String getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(String doctorid) {
        this.doctorid = doctorid;
    }

    public int getHospitalid() {
        return hospitalid;
    }

    public void setHospitalid(int hospitalid) {
        this.hospitalid = hospitalid;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public int getPatientage() {
        return patientage;
    }

    public void setPatientage(int patientage) {
        this.patientage = patientage;
    }

    public String getHospitalname() {
        return hospitalname;
    }

    public void setHospitalname(String hospitalname) {
        this.hospitalname = hospitalname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getHostype() {
        return hostype;
    }

    public void setHostype(int hostype) {
        this.hostype = hostype;
    }

    public String getDoctorimpwd() {
        return doctorimpwd;
    }

    public void setDoctorimpwd(String doctorimpwd) {
        this.doctorimpwd = doctorimpwd;
    }

    public String getPatientimpwd() {
        return patientimpwd;
    }

    public void setPatientimpwd(String patientimpwd) {
        this.patientimpwd = patientimpwd;
    }
}
