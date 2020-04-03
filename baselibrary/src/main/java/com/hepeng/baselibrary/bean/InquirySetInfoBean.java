package com.hepeng.baselibrary.bean;

import android.text.TextUtils;

import java.util.List;

public class InquirySetInfoBean {

    /**
     * sysfamily : [{"doctorprice":0,"price":88,"id":5,"day":15,"maxtime":5},{"doctorprice":0,"price":120,"id":2,"day":30,"maxtime":10},{"doctorprice":0,"price":620,"id":3,"day":90,"maxtime":20},{"doctorprice":0,"price":1500,"id":4,"day":180,"maxtime":30}]
     * disendtime :
     * disstarttime :
     * isfreeserver : 0
     * id : 7
     * isimgserver : 0
     * imgservermoney : 0
     * isfamily : 0
     * closestats : 0
     */

    private String disendtime;
    private String disstarttime;
    private int isfreeserver;
    private int id;
    private int isimgserver;
    private double imgservermoney;
    private int isfamily;
    private int closestats;
    private List<SysfamilyBean> sysfamily;
    private double minimgservermoney;
    private int orderselectionnummin;
    private int orderselectionnum;
    private int orderselectionnummax;
    private String doctorconfigadv;

    public String getDoctorconfigadv() {
        return doctorconfigadv;
    }

    public void setDoctorconfigadv(String doctorconfigadv) {
        this.doctorconfigadv = doctorconfigadv;
    }

    public int getOrderselectionnummin() {
        return orderselectionnummin;
    }

    public void setOrderselectionnummin(int orderselectionnummin) {
        this.orderselectionnummin = orderselectionnummin;
    }

    public int getOrderselectionnum() {
        return orderselectionnum;
    }

    public void setOrderselectionnum(int orderselectionnum) {
        this.orderselectionnum = orderselectionnum;
    }

    public int getOrderselectionnummax() {
        return orderselectionnummax;
    }

    public void setOrderselectionnummax(int orderselectionnummax) {
        this.orderselectionnummax = orderselectionnummax;
    }

    public double getMinimgservermoney() {
        return minimgservermoney;
    }

    public void setMinimgservermoney(double minimgservermoney) {
        this.minimgservermoney = minimgservermoney;
    }

    public String getDisendtime() {
        if (TextUtils.isEmpty(disendtime) || disendtime.equals("0")) {
            return "00:00";
        }
        return disendtime;
    }

    public void setDisendtime(String disendtime) {
        this.disendtime = disendtime;
    }

    public String getDisstarttime() {
        if (TextUtils.isEmpty(disstarttime) || disstarttime.equals("0")) {
            return "00:00";
        }
        return disstarttime;
    }

    public void setDisstarttime(String disstarttime) {
        this.disstarttime = disstarttime;
    }

    public int getIsfreeserver() {
        return isfreeserver;
    }

    public void setIsfreeserver(int isfreeserver) {
        this.isfreeserver = isfreeserver;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIsimgserver() {
        return isimgserver;
    }

    public void setIsimgserver(int isimgserver) {
        this.isimgserver = isimgserver;
    }

    public double getImgservermoney() {
        return imgservermoney;
    }

    public void setImgservermoney(double imgservermoney) {
        this.imgservermoney = imgservermoney;
    }

    public int getIsfamily() {
        return isfamily;
    }

    public void setIsfamily(int isfamily) {
        this.isfamily = isfamily;
    }

    public int getClosestats() {
        return closestats;
    }

    public void setClosestats(int closestats) {
        this.closestats = closestats;
    }

    public List<SysfamilyBean> getSysfamily() {
        return sysfamily;
    }

    public void setSysfamily(List<SysfamilyBean> sysfamily) {
        this.sysfamily = sysfamily;
    }

    public static class SysfamilyBean {
        /**
         * doctorprice : 0
         * price : 88
         * id : 5
         * day : 15
         * maxtime : 5
         */

        private double doctorprice;
        private double price;
        private int id;
        private int day;
        private int maxtime;

        public double getDoctorprice() {
            return doctorprice;
        }

        public void setDoctorprice(double doctorprice) {
            this.doctorprice = doctorprice;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getDay() {
            return day;
        }

        public void setDay(int day) {
            this.day = day;
        }

        public int getMaxtime() {
            return maxtime;
        }

        public void setMaxtime(int maxtime) {
            this.maxtime = maxtime;
        }
    }
}
