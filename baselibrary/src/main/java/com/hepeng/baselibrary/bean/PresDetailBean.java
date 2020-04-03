package com.hepeng.baselibrary.bean;

import java.io.Serializable;
import java.util.List;

public class PresDetailBean implements Serializable {

    /**
     * acceptcontent : null
     * orderno : 20190624224421_23087
     * expressname : 宾川申通快递
     * orderLog : [{"createtime":"2019-10-11 14:01:52","statusname":"待付款","id":1,"status":174},{"createtime":"2019-10-11 14:02:13","statusname":"待审核","id":3,"status":175},{"createtime":"2019-10-11 14:02:25","statusname":"待复核","id":4,"status":176},{"createtime":"2019-10-11 14:02:38","statusname":"待抓药","id":5,"status":177},{"createtime":"2019-10-11 14:03:05","statusname":"待发货","id":6,"status":178},{"createtime":"2019-10-11 14:03:17","statusname":"已发货","id":7,"status":179},{"createtime":"2019-10-11 14:03:27","statusname":"已送达","id":8,"status":180},{"createtime":"2019-10-11 14:03:40","statusname":"已收件","id":9,"status":181}]
     * realtotal : 1.64
     * express : [{"time":"10-26 23:50","content":"【广东省广州市白云区大源公司】 已收件 取件人: 肖立 (13060900144)"},{"time":"10-27 02:02","content":"【广东省广州市白云区大源公司】 已打包"},{"time":"10-27 02:06","content":"【广东省广州市白云区大源】 已发出 下一站 【广州转运中心】"},{"time":"10-27 05:13","content":"【广州转运中心公司】 已收入"},{"time":"10-27 05:17","content":"【广州转运中心】 已发出 下一站 【虎门转运中心】"},{"time":"10-27 07:33","content":"【虎门转运中心公司】 已收入"},{"time":"10-27 07:35","content":"【虎门转运中心】 已发出 下一站 【滇西转运中心】"},{"time":"10-28 13:10","content":"【滇西转运中心公司】 已收入"},{"time":"10-28 15:37","content":"【滇西转运中心】 已发出 下一站 【云南省保山市施甸县】"},{"time":"10-29 09:54","content":"【云南省保山市施甸县公司】 已收入"},{"time":"10-29 11:18","content":"【云南省保山市施甸县】 已发出 下一站 【云南省保山市施甸县姚关镇】"}]
     * systext : 如有疑问请联系平台客服,电话0871-68505995
     * addressname : 国医在线5201
     * servertotal : 0
     * typecode : 0
     * id : 1191
     * expressid : 13
     * specialmethod : 白茅根配方颗粒 烊化兑服
     * expresstotal : 0.05
     * hidetype : 11
     * acceptstatus : 1
     * tabu : --
     * timenum : 3
     * maketotal : 0
     * prescriptcontent : [{"total":0.076,"unit":"g","method":null,"mls":0,"max":null,"num":1,"id":15917,"finalprice":0,"medicinename":"糯稻根配方颗粒"},{"total":1.44,"unit":"g","method":null,"mls":0,"max":null,"num":16,"id":15922,"finalprice":0,"medicinename":"白茅根配方颗粒"},{"total":0.07400000000000001,"unit":"g","method":null,"mls":0,"max":null,"num":1,"id":15927,"finalprice":0,"medicinename":"大青叶配方颗粒"}]
     * pharmacytype : 0
     * accepttime : null
     * sendtime : null
     * prescriptid : 892
     * kindid : 3
     * status : 181
     * pharmacyid : 7
     * iswithin : 0
     * countnum : 1
     * remark : 忌与西药同服,空腹服
     * savetime : null
     * addressphone : 18313795201
     * eattime : null
     * total : 1.64
     * daynum : 1
     * createtime : 2019-09-19 17:58:56
     * hidetypename : 全程不可见
     * address : 云南省大理白族自治州宾川县鸡足山镇meiyoule
     * patientid : 7125
     * patientsex : 0
     * countnum1 : 1
     * pharmacyname : 保山市中医医院药房
     * paytime : null
     * kindname : 配方颗粒
     * expressnum : YT4163852289441
     * patientname : 杨超
     * diagnose : 痰火扰心证,
     * paystatus : 1
     * patientage : 23
     * ispick : 0
     */
    private String adviceid;
    private int advstatus;
    private String acceptcontent;
    private String orderno;
    private String expressname;
    private double realtotal;
    private String systext;
    private String addressname;
    private double servertotal;
    private int typecode;
    private String id;
    private String expressid;
    private String specialmethod;
    private double expresstotal;
    private int hidetype;
    private int acceptstatus;
    private String tabu;
    private String timenum;
    private double maketotal;
    private int pharmacytype;
    private String accepttime;
    private String sendtime;
    private String prescriptid;
    private int kindid;
    private int status;
    private int pharmacyid;
    private int iswithin;
    private String countnum;
    private String remark;
    private String savetime;
    private String addressphone;
    private String eattime;
    private double total;
    private String daynum;
    private String createtime;
    private String hidetypename;
    private String address;
    private String patientid;
    private int patientsex;
    private String countnum1;
    private String pharmacyname;
    private String paytime;
    private String kindname;
    private String expressnum;
    private String patientname;
    private String firstadvtime;
    private String diagnose;
    private int paystatus;
    private int patientage;
    private int ispick;
    private List<OrderLogBean> orderLog;
    private List<ExpressBean> express;
    private List<PrescribeBean.PrescriptContentListBean> prescriptcontent;
    private String idcard;

    public String getAdviceid() {
        return adviceid;
    }

    public void setAdviceid(String adviceid) {
        this.adviceid = adviceid;
    }

    public int getAdvstatus() {
        return advstatus;
    }

    public void setAdvstatus(int advstatus) {
        this.advstatus = advstatus;
    }

    public String getFirstadvtime() {
        return firstadvtime;
    }

    public void setFirstadvtime(String firstadvtime) {
        this.firstadvtime = firstadvtime;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getAcceptcontent() {
        return acceptcontent;
    }

    public void setAcceptcontent(String acceptcontent) {
        this.acceptcontent = acceptcontent;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public String getExpressname() {
        return expressname;
    }

    public void setExpressname(String expressname) {
        this.expressname = expressname;
    }

    public double getRealtotal() {
        return realtotal;
    }

    public void setRealtotal(double realtotal) {
        this.realtotal = realtotal;
    }

    public String getSystext() {
        return systext;
    }

    public void setSystext(String systext) {
        this.systext = systext;
    }

    public String getAddressname() {
        return addressname;
    }

    public void setAddressname(String addressname) {
        this.addressname = addressname;
    }

    public double getServertotal() {
        return servertotal;
    }

    public void setServertotal(double servertotal) {
        this.servertotal = servertotal;
    }

    public int getTypecode() {
        return typecode;
    }

    public void setTypecode(int typecode) {
        this.typecode = typecode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExpressid() {
        return expressid;
    }

    public void setExpressid(String expressid) {
        this.expressid = expressid;
    }

    public String getSpecialmethod() {
        return specialmethod;
    }

    public void setSpecialmethod(String specialmethod) {
        this.specialmethod = specialmethod;
    }

    public double getExpresstotal() {
        return expresstotal;
    }

    public void setExpresstotal(double expresstotal) {
        this.expresstotal = expresstotal;
    }

    public int getHidetype() {
        return hidetype;
    }

    public void setHidetype(int hidetype) {
        this.hidetype = hidetype;
    }

    public int getAcceptstatus() {
        return acceptstatus;
    }

    public void setAcceptstatus(int acceptstatus) {
        this.acceptstatus = acceptstatus;
    }

    public String getTabu() {
        return tabu;
    }

    public void setTabu(String tabu) {
        this.tabu = tabu;
    }

    public String getTimenum() {
        return timenum;
    }

    public void setTimenum(String timenum) {
        this.timenum = timenum;
    }

    public double getMaketotal() {
        return maketotal;
    }

    public void setMaketotal(double maketotal) {
        this.maketotal = maketotal;
    }

    public int getPharmacytype() {
        return pharmacytype;
    }

    public void setPharmacytype(int pharmacytype) {
        this.pharmacytype = pharmacytype;
    }

    public String getAccepttime() {
        return accepttime;
    }

    public void setAccepttime(String accepttime) {
        this.accepttime = accepttime;
    }

    public String getSendtime() {
        return sendtime;
    }

    public void setSendtime(String sendtime) {
        this.sendtime = sendtime;
    }

    public String getPrescriptid() {
        return prescriptid;
    }

    public void setPrescriptid(String prescriptid) {
        this.prescriptid = prescriptid;
    }

    public int getKindid() {
        return kindid;
    }

    public void setKindid(int kindid) {
        this.kindid = kindid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPharmacyid() {
        return pharmacyid;
    }

    public void setPharmacyid(int pharmacyid) {
        this.pharmacyid = pharmacyid;
    }

    public int getIswithin() {
        return iswithin;
    }

    public void setIswithin(int iswithin) {
        this.iswithin = iswithin;
    }

    public String getCountnum() {
        return countnum;
    }

    public void setCountnum(String countnum) {
        this.countnum = countnum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSavetime() {
        return savetime;
    }

    public void setSavetime(String savetime) {
        this.savetime = savetime;
    }

    public String getAddressphone() {
        return addressphone;
    }

    public void setAddressphone(String addressphone) {
        this.addressphone = addressphone;
    }

    public String getEattime() {
        return eattime;
    }

    public void setEattime(String eattime) {
        this.eattime = eattime;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getDaynum() {
        return daynum;
    }

    public void setDaynum(String daynum) {
        this.daynum = daynum;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getHidetypename() {
        return hidetypename;
    }

    public void setHidetypename(String hidetypename) {
        this.hidetypename = hidetypename;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getCountnum1() {
        return countnum1;
    }

    public void setCountnum1(String countnum1) {
        this.countnum1 = countnum1;
    }

    public String getPharmacyname() {
        return pharmacyname;
    }

    public void setPharmacyname(String pharmacyname) {
        this.pharmacyname = pharmacyname;
    }

    public String getPaytime() {
        return paytime;
    }

    public void setPaytime(String paytime) {
        this.paytime = paytime;
    }

    public String getKindname() {
        return kindname;
    }

    public void setKindname(String kindname) {
        this.kindname = kindname;
    }

    public String getExpressnum() {
        return expressnum;
    }

    public void setExpressnum(String expressnum) {
        this.expressnum = expressnum;
    }

    public String getPatientname() {
        return patientname;
    }

    public void setPatientname(String patientname) {
        this.patientname = patientname;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    public int getPaystatus() {
        return paystatus;
    }

    public void setPaystatus(int paystatus) {
        this.paystatus = paystatus;
    }

    public int getPatientage() {
        return patientage;
    }

    public void setPatientage(int patientage) {
        this.patientage = patientage;
    }

    public int getIspick() {
        return ispick;
    }

    public void setIspick(int ispick) {
        this.ispick = ispick;
    }

    public List<OrderLogBean> getOrderLog() {
        return orderLog;
    }

    public void setOrderLog(List<OrderLogBean> orderLog) {
        this.orderLog = orderLog;
    }

    public List<ExpressBean> getExpress() {
        return express;
    }

    public void setExpress(List<ExpressBean> express) {
        this.express = express;
    }

    public List<PrescribeBean.PrescriptContentListBean> getPrescriptcontent() {
        return prescriptcontent;
    }

    public void setPrescriptcontent(List<PrescribeBean.PrescriptContentListBean> prescriptcontent) {
        this.prescriptcontent = prescriptcontent;
    }

    public static class OrderLogBean implements Serializable {
        /**
         * createtime : 2019-10-11 14:01:52
         * statusname : 待付款
         * id : 1
         * status : 174
         */

        private String createtime;
        private String statusname;
        private int id;
        private int status;

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getStatusname() {
            return statusname;
        }

        public void setStatusname(String statusname) {
            this.statusname = statusname;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }

    public static class ExpressBean implements Serializable {
        /**
         * time : 10-26 23:50
         * content : 【广东省广州市白云区大源公司】 已收件 取件人: 肖立 (13060900144)
         */

        private String time;
        private String content;

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
