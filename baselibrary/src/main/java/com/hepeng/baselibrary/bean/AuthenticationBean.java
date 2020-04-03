package com.hepeng.baselibrary.bean;

import java.io.Serializable;

public class AuthenticationBean implements Serializable {

    /**
     * img : 201711/19781462143019416.jpg
     * strong : 结石病,前列腺炎,男性不育,尿路感染,泌尿系结石
     * acceptcontent :
     * sex : 0
     * realname : 张春和
     * proimg :
     * doctorcardimg :
     * idtype : 14
     * jobid : 36
     * acceptstatus : 1
     * regionfullname : 云南省 昆明市 西山区
     * hospitalid : 1
     * regionid : 2586
     * idtypename : 身份证
     * idcard :
     * intro :
     * regionname : 西山区
     * hospitalname : 云南省中医医院
     * accepttime : 2017-11-08 13:52:48
     * categoryname : 慢性病科
     * jobcardimg :
     * id : 10
     * categoryid : 57
     * jobname : 主任医师
     */

    private String img = "";
    private String strong = "";
    private String strongCount = "";
    private String acceptcontent = "";
    private int sex = -1;
    private String realname = "";
    private String proimg = "";
    private String doctorcardimg = "";
    private int idtype;
    private int jobid;
    private int acceptstatus;
    private String regionfullname = "";
    private String hospitalid = "";
    private String regionid = "";
    private String idtypename = "";
    private String idcard = "";
    private String intro = "";
    private String regionname = "";
    private String hospitalname = "";
    private String accepttime = "";
    private String categoryname = "";
    private String jobcardimg = "";
    private int id;
    private int categoryid;
    private String jobname = "";

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getStrongCount() {
        return strongCount;
    }

    public void setStrongCount(String strongCount) {
        this.strongCount = strongCount;
    }

    public String getStrong() {
        return strong;
    }

    public void setStrong(String strong) {
        this.strong = strong;
    }

    public String getAcceptcontent() {
        return acceptcontent;
    }

    public void setAcceptcontent(String acceptcontent) {
        this.acceptcontent = acceptcontent;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getProimg() {
        return proimg;
    }

    public void setProimg(String proimg) {
        this.proimg = proimg;
    }

    public String getDoctorcardimg() {
        return doctorcardimg;
    }

    public void setDoctorcardimg(String doctorcardimg) {
        this.doctorcardimg = doctorcardimg;
    }

    public int getIdtype() {
        return idtype;
    }

    public void setIdtype(int idtype) {
        this.idtype = idtype;
    }

    public int getJobid() {
        return jobid;
    }

    public void setJobid(int jobid) {
        this.jobid = jobid;
    }

    public int getAcceptstatus() {
        return acceptstatus;
    }

    public void setAcceptstatus(int acceptstatus) {
        this.acceptstatus = acceptstatus;
    }

    public String getRegionfullname() {
        return regionfullname;
    }

    public void setRegionfullname(String regionfullname) {
        this.regionfullname = regionfullname;
    }

    public String getHospitalid() {
        return hospitalid;
    }

    public void setHospitalid(String hospitalid) {
        this.hospitalid = hospitalid;
    }

    public String getRegionid() {
        return regionid;
    }

    public void setRegionid(String regionid) {
        this.regionid = regionid;
    }

    public String getIdtypename() {
        return idtypename;
    }

    public void setIdtypename(String idtypename) {
        this.idtypename = idtypename;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getRegionname() {
        return regionname;
    }

    public void setRegionname(String regionname) {
        this.regionname = regionname;
    }

    public String getHospitalname() {
        return hospitalname;
    }

    public void setHospitalname(String hospitalname) {
        this.hospitalname = hospitalname;
    }

    public String getAccepttime() {
        return accepttime;
    }

    public void setAccepttime(String accepttime) {
        this.accepttime = accepttime;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public String getJobcardimg() {
        return jobcardimg;
    }

    public void setJobcardimg(String jobcardimg) {
        this.jobcardimg = jobcardimg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname;
    }
}
