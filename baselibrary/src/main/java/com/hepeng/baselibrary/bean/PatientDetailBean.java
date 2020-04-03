package com.hepeng.baselibrary.bean;

import java.util.List;

public class PatientDetailBean {

    /**
     * patientDiseaseList : ["来来来;哦哦哦","555555555;哦哦哦"]
     * impwd : C8Q3hN2ZpT63WxnR
     * sex : 1
     * specialtime : 星期1
     * weight : 56
     * imname : 17261426201910_63106
     * realname : 吴美琪
     * adv : [{"imgs":"adv/2019-10-26/20191026170420_puwryk7el4.png","createtime":"2019-10-26 17:07:22","hospitalname":"寻甸县中医医院","categoryname":"针灸科","content":"头疼肌筋膜痛综合症头疼肌筋膜痛综合症"},{"imgs":"/adv/2019-10-26/20191026142710_4yw58rdjfi.png","createtime":"2019-10-26 14:26:46","hospitalname":"寻甸县中医医院","categoryname":"针灸科","content":"对方她她她她她她她她她她她她她她她"}]
     * nativename : 云南省 昆明市
     * phone : 15288168216
     * stature : 156
     * patientDiseaseImgList : []
     * id : 18449
     * age : 28
     */

    private String impwd;
    private int sex;
    private String specialtime;
    private String weight;
    private String imname;
    private String realname;
    private String nativename;
    private String phone;
    private String stature;
    private int id;
    private int age;
    private List<String> patientDiseaseList;
    private List<AdvBean> adv;
    private List<String> patientDiseaseImgList;
    private String countryname;
    private int advstatus;
    private String idcard;
    private String adviceid;

    public int getAdvstatus() {
        return advstatus;
    }

    public void setAdvstatus(int advstatus) {
        this.advstatus = advstatus;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getAdviceid() {
        return adviceid;
    }

    public void setAdviceid(String adviceid) {
        this.adviceid = adviceid;
    }

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public String getImpwd() {
        return impwd;
    }

    public void setImpwd(String impwd) {
        this.impwd = impwd;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getSpecialtime() {
        return specialtime;
    }

    public void setSpecialtime(String specialtime) {
        this.specialtime = specialtime;
    }

    public String getWeight() {
        if (weight.startsWith("-")) {
            return "";
        }
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getImname() {
        return imname;
    }

    public void setImname(String imname) {
        this.imname = imname;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getNativename() {
        return nativename;
    }

    public void setNativename(String nativename) {
        this.nativename = nativename;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStature() {
        if (stature.startsWith("-")) {
            return "";
        }
        return stature;
    }

    public void setStature(String stature) {
        this.stature = stature;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getPatientDiseaseList() {
        return patientDiseaseList;
    }

    public void setPatientDiseaseList(List<String> patientDiseaseList) {
        this.patientDiseaseList = patientDiseaseList;
    }

    public List<AdvBean> getAdv() {
        return adv;
    }

    public void setAdv(List<AdvBean> adv) {
        this.adv = adv;
    }

    public List<String> getPatientDiseaseImgList() {
        return patientDiseaseImgList;
    }

    public void setPatientDiseaseImgList(List<String> patientDiseaseImgList) {
        this.patientDiseaseImgList = patientDiseaseImgList;
    }

    public class AdvBean {
        /**
         * imgs : adv/2019-10-26/20191026170420_puwryk7el4.png
         * createtime : 2019-10-26 17:07:22
         * hospitalname : 寻甸县中医医院
         * categoryname : 针灸科
         * content : 头疼肌筋膜痛综合症头疼肌筋膜痛综合症
         */

        private String imgs;
        private String createtime;
        private String hospitalname;
        private String categoryname;
        private String content;
        private String advtypecode;
        private List<PrescriptListBean> prescriptList;

        public String getAdvtypecode() {
            return advtypecode;
        }

        public void setAdvtypecode(String advtypecode) {
            this.advtypecode = advtypecode;
        }

        public String getImgs() {
            return imgs;
        }

        public void setImgs(String imgs) {
            this.imgs = imgs;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
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

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public List<PrescriptListBean> getPrescriptList() {
            return prescriptList;
        }

        public void setPrescriptList(List<PrescriptListBean> prescriptList) {
            this.prescriptList = prescriptList;
        }

        public class PrescriptListBean {
            /**
             * diagnose : 来来来;图兔兔图图
             * prescriptorderid : 5722
             * prescriptcontenttitle : 白前 15g,薄荷 15g,白头翁 10g,白薇 20g,车前草 50g,阿胶-太极250g 10g
             */

            private String diagnose;
            private String prescriptorderid;
            private String prescriptcontenttitle;

            public String getDiagnose() {
                return diagnose;
            }

            public void setDiagnose(String diagnose) {
                this.diagnose = diagnose;
            }

            public String getPrescriptorderid() {
                return prescriptorderid;
            }

            public void setPrescriptorderid(String prescriptorderid) {
                this.prescriptorderid = prescriptorderid;
            }

            public String getPrescriptcontenttitle() {
                return prescriptcontenttitle;
            }

            public void setPrescriptcontenttitle(String prescriptcontenttitle) {
                this.prescriptcontenttitle = prescriptcontenttitle;
            }
        }
    }
}
