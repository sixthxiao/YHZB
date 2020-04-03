package com.hepeng.baselibrary.bean;

import android.text.TextUtils;

public class WelcomeInfoBean {

    /**
     * splicingtext : 开启后平台将会在段落后面为您加上:为你提供最优质的医疗服务本人将在24小时内对您题出的问题进行回复请留意手机短信和微信消息提醒
     * welcomeadd : null
     * title :
     * welcome : null
     * outowelcome : 患者购买服务后，将自动发送您预留的欢迎语
     */

    private String splicingtext;
    private String welcomeadd;
    private String title;
    private String welcome;
    private String outowelcome;

    public String getSplicingtext() {
        return splicingtext;
    }

    public void setSplicingtext(String splicingtext) {
        this.splicingtext = splicingtext;
    }

    public String getWelcomeadd() {
        if (TextUtils.isEmpty(welcomeadd)) {
            return "0";
        }
        return welcomeadd;
    }

    public void setWelcomeadd(String welcomeadd) {
        this.welcomeadd = welcomeadd;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWelcome() {
        if (TextUtils.isEmpty(welcome)) {
            return "0";
        }
        return welcome;
    }

    public void setWelcome(String welcome) {
        this.welcome = welcome;
    }

    public String getOutowelcome() {
        return outowelcome;
    }

    public void setOutowelcome(String outowelcome) {
        this.outowelcome = outowelcome;
    }
}
