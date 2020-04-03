package com.yahu.live.pay;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class WechatOrderRst implements Serializable {
    @SerializedName("appid")
    String appId;
    @SerializedName("partnerid")
    String partnerId;
    @SerializedName("prepayid")
    String prepayId;
    @SerializedName("package")
    String packageValue;
    @SerializedName("noncestr")
    String nonceStr;
    @SerializedName("timestamp")
    String timestamp;
    @SerializedName("sign")
    String sign;


    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    public String getPackageValue() {
        return packageValue;
    }

    public void setPackageValue(String packageValue) {
        this.packageValue = packageValue;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
