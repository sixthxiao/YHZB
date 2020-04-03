package com.hepeng.baselibrary.bean;

import android.text.TextUtils;

import java.io.Serializable;

public class MedicineBean implements Serializable {
    private String decoction = "煎法";
    private int islack = 0;//1-缺药
    private int mls = 0;//是否双签
    private int pharmacyid;
    private int limitmax;
    private int max;
    private int medicineid;
    private String publicpy;
    private String py;
    private String kindname;
    private String title;
    private String publictitle;
    private String unit = "";
    private String otherids;
    private double finaltotal;
    private String amount = "";
    private int id;
    private int limitmin;
    private int kindid;

    public MedicineBean() {

    }

    public int getMls() {
        return mls;
    }

    public void setMls(int mls) {
        this.mls = mls;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDecoction() {
        if (TextUtils.isEmpty(decoction)) {
            return "煎法";
        }
        return decoction;
    }

    public void setDecoction(String decoction) {
        this.decoction = decoction;
    }

    public int getIslack() {
        return islack;
    }

    public void setIslack(int islack) {
        this.islack = islack;
    }

    public int getPharmacyid() {
        return pharmacyid;
    }

    public void setPharmacyid(int pharmacyid) {
        this.pharmacyid = pharmacyid;
    }

    public int getLimitmax() {
        return limitmax;
    }

    public void setLimitmax(int limitmax) {
        this.limitmax = limitmax;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMedicineid() {
        return medicineid;
    }

    public void setMedicineid(int medicineid) {
        this.medicineid = medicineid;
    }

    public String getPublicpy() {
        return publicpy;
    }

    public void setPublicpy(String publicpy) {
        this.publicpy = publicpy;
    }

    public String getPy() {
        return py;
    }

    public void setPy(String py) {
        this.py = py;
    }

    public String getKindname() {
        return kindname;
    }

    public void setKindname(String kindname) {
        this.kindname = kindname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublictitle() {
        return publictitle;
    }

    public void setPublictitle(String publictitle) {
        this.publictitle = publictitle;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getOtherids() {
        return otherids;
    }

    public void setOtherids(String otherids) {
        this.otherids = otherids;
    }

    public double getFinaltotal() {
        return finaltotal;
    }

    public void setFinaltotal(double finaltotal) {
        this.finaltotal = finaltotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLimitmin() {
        return limitmin;
    }

    public void setLimitmin(int limitmin) {
        this.limitmin = limitmin;
    }

    public int getKindid() {
        return kindid;
    }

    public void setKindid(int kindid) {
        this.kindid = kindid;
    }


    public static MedicineBean merge(MedicineBean s1, MedicineBean s2) {
        String amount1 = s1.amount;
        String amount2 = s2.amount;
        if (TextUtils.isEmpty(s1.amount)) {
            amount1 = "0";
        }
        if (TextUtils.isEmpty(s2.amount)) {
            amount2 = "0";
        }
        String total = String.valueOf(Integer.parseInt(amount1) + Integer.parseInt(amount2));
        return new MedicineBean(total);
    }

    public MedicineBean(String valueOf) {
        this.amount = valueOf;
    }
}
