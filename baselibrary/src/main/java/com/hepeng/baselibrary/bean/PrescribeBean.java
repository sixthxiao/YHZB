package com.hepeng.baselibrary.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PrescribeBean implements Serializable {

    /**
     * adviceid : 0
     * countnum : 0
     * countnum1 : 0
     * daynum : 0
     * diagnose : string
     * eattime : string
     * hidetype : 0
     * istemplate : 0
     * iswithin : 0
     * kindid : 0
     * patientid : 0
     * pharmacyid : 0
     * prescriptContentList : [{"finalprice":0,"medpharmacyid":0,"method":"string","mls":0,"num":0,"total":0}]
     * remark : string
     * servertotal : 0
     * specialmethod : string
     * tabu : string
     * templatename : string
     * timenum : 0
     * total : 0
     * typecode : 0
     */

    private String id;
    private String realname;
    private int age;
    private int sex = -1;
    private String idcard;
    private String adviceid = "";
    private String countnum = "";
    private String countnum1 = "";
    private String daynum = "";
    private String diagnose = "";
    private String eattime = "";
    private int hidetype = 0;
    private int istemplate = 0;
    private int iswithin = 0;
    private int kindid = -1;
    private String kindName = "药品剂型";
    private String patientid = "";
    private int pharmacyid = -1;
    private String pharmcacyName = "药房名称";
    private String pharmcacyDescribe = "请选择药房和剂型";
    private int phartype = 0;//药房类型
    private String remark = "";
    private double servertotal = 0;
    private String specialmethod = "";
    private String tabu = "";
    private String templatename = "";
    private String timenum = "";
    private double total;
    private int typecode;
    private List<PrescriptContentListBean> prescriptContentList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public int getPhartype() {
        return phartype;
    }

    public void setPhartype(int phartype) {
        this.phartype = phartype;
    }

    public String getAdviceid() {
        return adviceid;
    }

    public void setAdviceid(String adviceid) {
        this.adviceid = adviceid;
    }

    public String getCountnum() {
        return countnum;
    }

    public void setCountnum(String countnum) {
        this.countnum = countnum;
    }

    public String getCountnum1() {
        return countnum1;
    }

    public void setCountnum1(String countnum1) {
        this.countnum1 = countnum1;
    }

    public String getDaynum() {
        return daynum;
    }

    public void setDaynum(String daynum) {
        this.daynum = daynum;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    public String getEattime() {
        return eattime;
    }

    public void setEattime(String eattime) {
        this.eattime = eattime;
    }

    public int getHidetype() {
        return hidetype;
    }

    public void setHidetype(int hidetype) {
        this.hidetype = hidetype;
    }

    public int getIstemplate() {
        return istemplate;
    }

    public void setIstemplate(int istemplate) {
        this.istemplate = istemplate;
    }

    public int getIswithin() {
        return iswithin;
    }

    public void setIswithin(int iswithin) {
        this.iswithin = iswithin;
    }

    public int getKindid() {
        return kindid;
    }

    public void setKindid(int kindid) {
        this.kindid = kindid;
    }

    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName;
    }

    public String getPharmcacyName() {
        return pharmcacyName;
    }

    public void setPharmcacyName(String pharmcacyName) {
        this.pharmcacyName = pharmcacyName;
    }

    public String getPharmcacyDescribe() {
        return pharmcacyDescribe;
    }

    public void setPharmcacyDescribe(String pharmcacyDescribe) {
        this.pharmcacyDescribe = pharmcacyDescribe;
    }

    public String getPatientid() {
        return patientid;
    }

    public void setPatientid(String patientid) {
        this.patientid = patientid;
    }

    public int getPharmacyid() {
        return pharmacyid;
    }

    public void setPharmacyid(int pharmacyid) {
        this.pharmacyid = pharmacyid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public double getServertotal() {
        return servertotal;
    }

    public void setServertotal(double servertotal) {
        this.servertotal = servertotal;
    }

    public String getSpecialmethod() {
        return specialmethod;
    }

    public void setSpecialmethod(String specialmethod) {
        this.specialmethod = specialmethod;
    }

    public String getTabu() {
        return tabu;
    }

    public void setTabu(String tabu) {
        this.tabu = tabu;
    }

    public String getTemplatename() {
        return templatename;
    }

    public void setTemplatename(String templatename) {
        this.templatename = templatename;
    }

    public String getTimenum() {
        return timenum;
    }

    public void setTimenum(String timenum) {
        this.timenum = timenum;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getTypecode() {
        return typecode;
    }

    public void setTypecode(int typecode) {
        this.typecode = typecode;
    }

    public List<PrescriptContentListBean> getPrescriptContentList() {
        if (prescriptContentList == null) {
            return new ArrayList<>();
        }
        return prescriptContentList;
    }

    public void setPrescriptContentList(List<PrescriptContentListBean> prescriptContentList) {
        this.prescriptContentList = prescriptContentList;
    }

    public static class PrescriptContentListBean implements Serializable {
        /**
         * finalprice : 0
         * medpharmacyid : 0
         * method : string
         * mls : 0
         * num : 0
         * total : 0
         */

        private int id;
        private double finalprice;
        private int medpharmacyid;
        private String method;
        private int mls;
        private double num;
        private double total;
        private int max;
        private String unit;
        private String medicinename;
        private int islack = 0;
        private String otherids;

        public String getOtherids() {
            return otherids;
        }

        public void setOtherids(String otherids) {
            this.otherids = otherids;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getIslack() {
            return islack;
        }

        public void setIslack(int islack) {
            this.islack = islack;
        }

        public String getMedicinename() {
            return medicinename;
        }

        public void setMedicinename(String medicinename) {
            this.medicinename = medicinename;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public double getFinalprice() {
            return finalprice;
        }

        public void setFinalprice(double finalprice) {
            this.finalprice = finalprice;
        }

        public int getMedpharmacyid() {
            return medpharmacyid;
        }

        public void setMedpharmacyid(int medpharmacyid) {
            this.medpharmacyid = medpharmacyid;
        }

        public String getMethod() {
            return method;
        }

        public void setMethod(String method) {
            this.method = method;
        }

        public int getMls() {
            return mls;
        }

        public void setMls(int mls) {
            this.mls = mls;
        }

        public int getNum() {
            return (int) num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public double getTotal() {
            return total;
        }

        public void setTotal(double total) {
            this.total = total;
        }
    }
}
