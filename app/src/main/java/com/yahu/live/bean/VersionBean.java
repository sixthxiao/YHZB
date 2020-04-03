package com.yahu.live.bean;

import java.io.Serializable;

public class VersionBean implements Serializable {
    private String msg;
    private String code;
    private VersionResult data = new VersionResult();

    public String getDetail() {
        return msg;
    }

    public void setDetail(String detail) {
        this.msg = detail;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public VersionResult getResults() {
        return data;
    }

    public void setResults(VersionResult results) {
        this.data = results;
    }
}
