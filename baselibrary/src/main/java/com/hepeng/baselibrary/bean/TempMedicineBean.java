package com.hepeng.baselibrary.bean;

import java.io.Serializable;

public class TempMedicineBean implements Serializable {

    /**
     * unit : g
     * limitmax : 0
     * total : 27.6
     * islack : 0
     * max : 0
     * num : 276
     * finaltotal : 0.1
     * id : 14
     * title : 白头翁
     * limitmin : 0
     */

    private String unit;
    private int limitmax;
    private double total;
    private int islack;
    private int max;
    private double num;
    private double finaltotal;
    private int id;
    private String title;
    private int limitmin;
    private int medicineid;
    private String otherids;

    public String getOtherids() {
        return otherids;
    }

    public void setOtherids(String otherids) {
        this.otherids = otherids;
    }

    public int getMedicineid() {
        return medicineid;
    }

    public void setMedicineid(int medicineid) {
        this.medicineid = medicineid;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getLimitmax() {
        return limitmax;
    }

    public void setLimitmax(int limitmax) {
        this.limitmax = limitmax;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getIslack() {
        return islack;
    }

    public void setIslack(int islack) {
        this.islack = islack;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getNum() {
        return (int) num;
    }

    public void setNum(double num) {
        this.num = num;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLimitmin() {
        return limitmin;
    }

    public void setLimitmin(int limitmin) {
        this.limitmin = limitmin;
    }
}
