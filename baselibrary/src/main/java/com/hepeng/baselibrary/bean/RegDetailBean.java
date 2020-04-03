package com.hepeng.baselibrary.bean;

import android.text.TextUtils;

import java.util.List;

public class RegDetailBean {

    /**
     * hospitaladdress : 迪庆
     * img : /doctor/2019-09-29/20190929084806_ikgaggytgw.png
     * strong : [{"disease":"急性心梗","num":6}]
     * orderno : R20191029205936_85914
     * patientid : 18449
     * patientsex : 1
     * num : 1
     * finishcode :
     * endtime : 2019-10-31 17:30:11
     * starttime : 2019-10-31 08:30:03
     * realname : 杨超(国医在线)
     * patientname : 吴美琪
     * total : 2
     * hospitalid : 2
     * registertype : 0
     * patientage : 28
     * hospitalname : 国医在线
     * categoryname : 妇科
     * tip : 请到医院出示你的身份证或就诊号进行就医具体文案没有确定
     * id : 4107
     * timetype : 158
     * jobname : 副主任医师
     * status : 201
     * timetypename : 全天
     */

    private String hospitaladdress;
    private String img;
    private String orderno;
    private int patientid;
    private int patientsex;
    private int num;
    private String finishcode;
    private String endtime;
    private String starttime;
    private String realname;
    private String patientname;
    private double total;
    private int hospitalid;
    private int registertype;
    private int patientage;
    private String hospitalname;
    private String categoryname;
    private String tip;
    private int id;
    private int timetype;
    private String jobname;
    private int status;
    private String timetypename;
    private List<StrongBean> strong;

    public String getHospitaladdress() {
        return hospitaladdress;
    }

    public void setHospitaladdress(String hospitaladdress) {
        this.hospitaladdress = hospitaladdress;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public int getPatientid() {
        return patientid;
    }

    public void setPatientid(int patientid) {
        this.patientid = patientid;
    }

    public int getPatientsex() {
        return patientsex;
    }

    public void setPatientsex(int patientsex) {
        this.patientsex = patientsex;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getFinishcode() {
        if (TextUtils.isEmpty(finishcode)) {
            return "无";
        }
        return finishcode;
    }

    public void setFinishcode(String finishcode) {
        this.finishcode = finishcode;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPatientname() {
        return patientname;
    }

    public void setPatientname(String patientname) {
        this.patientname = patientname;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getHospitalid() {
        return hospitalid;
    }

    public void setHospitalid(int hospitalid) {
        this.hospitalid = hospitalid;
    }

    public int getRegistertype() {
        return registertype;
    }

    public void setRegistertype(int registertype) {
        this.registertype = registertype;
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

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTimetype() {
        return timetype;
    }

    public void setTimetype(int timetype) {
        this.timetype = timetype;
    }

    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTimetypename() {
        return timetypename;
    }

    public void setTimetypename(String timetypename) {
        this.timetypename = timetypename;
    }

    public List<StrongBean> getStrong() {
        return strong;
    }

    public void setStrong(List<StrongBean> strong) {
        this.strong = strong;
    }

    public static class StrongBean {
        /**
         * disease : 急性心梗
         * num : 6
         */

        private String disease;
        private int num;

        public String getDisease() {
            return disease;
        }

        public void setDisease(String disease) {
            this.disease = disease;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }
    }
}
