package com.hepeng.baselibrary.bean;

public class EvaluateBean {

    /**
     * typecode : 0
     * score : 5
     * img : http://thirdwx.qlogo.cn/mmopen/vi_32/pQ0ZcFkqrCS7rhzzeiaggustOWic1XjL116kTCNibSphic0u9DSHEztOK124y7OHAF6xa4rBcpDmuIhEftmISekzAw/132
     * name : 陌生人
     * time : 2019/04/06
     * content : 回答详细耐心
     */

    private int typecode;
    private int score;
    private String img;
    private String name;
    private String time;
    private String content;

    public int getTypecode() {
        return typecode;
    }

    public void setTypecode(int typecode) {
        this.typecode = typecode;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
