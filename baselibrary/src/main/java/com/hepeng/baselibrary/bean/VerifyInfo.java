package com.hepeng.baselibrary.bean;

import android.os.Build;

import java.util.HashMap;

public class VerifyInfo extends HashMap<String,Object> {

    public static VerifyInfo register(String userName, String password, String valiCode, String parentId){
        VerifyInfo info=new VerifyInfo();
        info.put("userName",userName);
        info.put("password",password);
        info.put("valiCode",valiCode);
        info.put("parentId",parentId);
        info.put("device", Build.BRAND+";"+Build.DEVICE);
        info.put("deviceType","Android");
        return  info;
    }
    public static VerifyInfo login(String userName, String password){
        VerifyInfo info=new VerifyInfo();
        info.put("userName",userName);
        info.put("password",password);
        info.put("device", Build.BRAND+";"+Build.DEVICE);
        info.put("deviceType","Android");
        return  info;
    }

    public static VerifyInfo DownloadNum(int versionId){
        VerifyInfo info=new VerifyInfo();
        info.put("id",versionId);
        return  info;
    }
    public static VerifyInfo buyCartSubmit(long[] buyCartIds){
        VerifyInfo info=new VerifyInfo();
        info.put("buyCartIds",buyCartIds);
        return info;
    }public static VerifyInfo buyCartEdit(long buyCartId, int num){
        VerifyInfo info=new VerifyInfo();
        info.put("buyCartId",buyCartId);
        info.put("num",num);
        return info;
    }






}
