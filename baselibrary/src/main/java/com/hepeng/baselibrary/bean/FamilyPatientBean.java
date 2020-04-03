package com.hepeng.baselibrary.bean;

import java.util.List;

public class FamilyPatientBean {


    /**
     * accountid : 19254
     * asknum : 2
     * img : 201910/20191015202401-a8842584-5867-4db5-ab6f-1c1d945c9b59.png
     * advlist : [{"createtime":"2019/10/18","impwd":"S76zV7cKuY7XdR4C","labelid":"子女","sex":0,"id":32796,"advnum":1,"age":24,"realname":"唐三202","imname":"04261717201910_98143"}]
     * doctorid : 2020
     * nowcount : 3
     * endtime : 2019-11-25 23:59:59
     * id : 17
     * starttime : 2019-10-18 14:17:16
     * day : 31
     * realname : 白林波1122
     */

    private int accountid;
    private int asknum;
    private String img;
    private int doctorid;
    private int nowcount;
    private String endtime;
    private int id;
    private String starttime;
    private int day;
    private String realname;
    private List<AdvlistBean> advlist;

    public int getAccountid() {
        return accountid;
    }

    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }

    public int getAsknum() {
        return asknum;
    }

    public void setAsknum(int asknum) {
        this.asknum = asknum;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(int doctorid) {
        this.doctorid = doctorid;
    }

    public int getNowcount() {
        return nowcount;
    }

    public void setNowcount(int nowcount) {
        this.nowcount = nowcount;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public List<AdvlistBean> getAdvlist() {
        return advlist;
    }

    public void setAdvlist(List<AdvlistBean> advlist) {
        this.advlist = advlist;
    }

    public static class AdvlistBean {
        /**
         * createtime : 2019/10/18
         * impwd : S76zV7cKuY7XdR4C
         * labelid : 子女
         * sex : 0
         * id : 32796
         * advnum : 1
         * age : 24
         * realname : 唐三202
         * imname : 04261717201910_98143
         */

        private String createtime;
        private String impwd;
        private String labelid;
        private int sex;
        private int id;
        private int advnum;
        private int age;
        private String realname;
        private String imname;

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getImpwd() {
            return impwd;
        }

        public void setImpwd(String impwd) {
            this.impwd = impwd;
        }

        public String getLabelid() {
            return labelid;
        }

        public void setLabelid(String labelid) {
            this.labelid = labelid;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getAdvnum() {
            return advnum;
        }

        public void setAdvnum(int advnum) {
            this.advnum = advnum;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getRealname() {
            return realname;
        }

        public void setRealname(String realname) {
            this.realname = realname;
        }

        public String getImname() {
            return imname;
        }

        public void setImname(String imname) {
            this.imname = imname;
        }
    }
}
