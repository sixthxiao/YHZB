package com.hepeng.baselibrary.bean;

public class MixUserInfo {
    private String deviceId="";
    //默认的proxy为yjyc
    private String proxy="yhjg";
    private String nickName="";
    private String logo="";
    private String phone="";
    private int memberType=0;
    private String token="";
    private String merchantTelephone="";
    private String merchantTitle="";
    private String merchantLogo="";


    // Getter Methods

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getProxy() {
        return proxy;
    }

    public String getNickName() {
        return nickName;
    }

    public String getLogo() {
        return logo;
    }

    public String getPhone() {
        return phone;
    }

    public int getMemberType() {
        return memberType;
    }

    public String getToken() {
        return token;
    }

    public String getMerchantTelephone() {
        return merchantTelephone;
    }

    public String getMerchantTitle() {
        return merchantTitle;
    }

    public String getMerchantLogo() {
        return merchantLogo;
    }

    // Setter Methods

    public void setProxy(String proxy) {
        this.proxy = proxy;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setMemberType(int memberType) {
        this.memberType = memberType;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setMerchantTelephone(String merchantTelephone) {
        this.merchantTelephone = merchantTelephone;
    }

    public void setMerchantTitle(String merchantTitle) {
        this.merchantTitle = merchantTitle;
    }

    public void setMerchantLogo(String merchantLogo) {
        this.merchantLogo = merchantLogo;
    }
}
