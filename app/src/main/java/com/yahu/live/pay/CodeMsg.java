package com.yahu.live.pay;

import android.os.Parcel;
import android.os.Parcelable;

public class CodeMsg implements Parcelable {
    public int code;
    public String msg;

    public CodeMsg() {
    }

    protected CodeMsg(Parcel in) {
        code = in.readInt();
        msg = in.readString();
    }

    public static final Creator<CodeMsg> CREATOR = new Creator<CodeMsg>() {
        @Override
        public CodeMsg createFromParcel(Parcel in) {
            return new CodeMsg(in);
        }

        @Override
        public CodeMsg[] newArray(int size) {
            return new CodeMsg[size];
        }
    };

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(code);
        parcel.writeString(msg);
    }
}
