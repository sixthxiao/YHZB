package com.hepeng.baselibrary.bean;

public class MoneyInfoBean {
    private String id;
    private double freetotal;
    private double freezetotalhis;
    private double freezetotal;
    private String paypwd;

    public String getPaypwd() {
        return paypwd;
    }

    public void setPaypwd(String paypwd) {
        this.paypwd = paypwd;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getFreetotal() {
        if (freetotal < 0) {
            return 0.0;
        }
        return freetotal;
    }

    public void setFreetotal(double freetotal) {
        this.freetotal = freetotal;
    }

    public double getFreezetotalhis() {
        return Math.abs(freezetotalhis);
    }

    public void setFreezetotalhis(double freezetotalhis) {
        this.freezetotalhis = freezetotalhis;
    }

    public double getFreezetotal() {
        return Math.abs(freezetotal);
    }

    public void setFreezetotal(double freezetotal) {
        this.freezetotal = freezetotal;
    }
}
