package com.hepeng.baselibrary.bean;

import java.io.Serializable;

public class CosTempBean implements Serializable {

    /**
     * bucket : dev-1257318792
     * tmpSecretId : AKIDRJ5e3hnFnD1TvU6Hy01PVOPyu9lfSKu4SCnWTIvDYXtk855a0OL2wFlG848fvJSO
     * tmpSecretKey : pc+TUzP2EwT4budsALUHIesBVMt9Wi5AOEU80yacvdE=
     * domain : https://dev-1257318792.cos.ap-chongqing.myqcloud.com
     * sessionToken : 6oJVKutYvqmlOWDH4MUOivsW3VWZtOp2fea9acabf45223dc4daf4e84a9230d79hKbttrinc1OOro3qqSRqmlpDPw9Cpey7IzuNaKx-0umuOa7gDSXyYEglQEuhWI85djSVYyZNctNYHFWhQHwT_e_xdC4X-Byv_XQloqXHmSQctdG3nEKYEkZnLTxI3VIN1tj6Qp4kV8f6vX-Wc5zCqmxUVtSDgJaUO-mhUgMkJN_PbGbyKTKH2RIae6AZoat2QmJocWPy9VP2ufMwxReNUqAS6mM55JoMBlSoSyH0kkiM9w_Ypq6wXIegm3xiuPJP_rOntTkgMA7zRGJrQEUTtV6ZV7dzNC0rC2aekb2BpuywWjnhFhpmZDWpB9JvvB62E74KuE48xeeI4-PssyVQcbeFVjKl-pH_zXSpps6tipXeZrRru_PF6GemSKfe3vBbLipYEuJ89RWJaI96MAQ2Xu3XsAHxHwkuQ8kLDkKTQ-C_D7wPL2LFGes33JmfCZ58sS7anUA0Ti99lBk8smwD9g
     * "endtime": 1570527021883,
     * "starttime": 1570527018283
     */


    private String bucket;
    private String tmpSecretId;
    private String tmpSecretKey;
    private String domain;

    private String sessionToken;
    private long endtime;
    private long starttime;

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getTmpSecretId() {
        return tmpSecretId;
    }

    public void setTmpSecretId(String tmpSecretId) {
        this.tmpSecretId = tmpSecretId;
    }

    public String getTmpSecretKey() {
        return tmpSecretKey;
    }

    public void setTmpSecretKey(String tmpSecretKey) {
        this.tmpSecretKey = tmpSecretKey;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public long getEndtime() {
        return endtime;
    }

    public void setEndtime(long endtime) {
        this.endtime = endtime;
    }

    public long getStarttime() {
        return starttime;
    }

    public void setStarttime(long starttime) {
        this.starttime = starttime;
    }
}
