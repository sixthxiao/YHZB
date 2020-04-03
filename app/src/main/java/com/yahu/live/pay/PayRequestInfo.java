package com.yahu.live.pay;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class PayRequestInfo implements Parcelable {
    String type;
    @SerializedName("pay_info")
    String payInfo;
    @SerializedName("return_url")
    String returnUrl;

    protected PayRequestInfo(Parcel in) {
        type = in.readString();
        payInfo = in.readString();
        returnUrl = in.readString();
    }

    public static final Creator<PayRequestInfo> CREATOR = new Creator<PayRequestInfo>() {
        @Override
        public PayRequestInfo createFromParcel(Parcel in) {
            return new PayRequestInfo(in);
        }

        @Override
        public PayRequestInfo[] newArray(int size) {
            return new PayRequestInfo[size];
        }
    };

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPayInfo() {
        return payInfo;
    }

    public void setPayInfo(String payInfo) {
        this.payInfo = payInfo;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }
    public WechatOrderRst toWechatRst(){
        Gson gson = new Gson();
        return gson.fromJson(payInfo,WechatOrderRst.class);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(type);
        parcel.writeString(payInfo);
        parcel.writeString(returnUrl);
    }
}
