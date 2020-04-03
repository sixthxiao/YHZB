package com.hepeng.baselibrary.bean;

import java.io.Serializable;
import java.util.List;

public class CommonManageBean implements Serializable {

    /**
     * id : 107
     * title : 常用语
     * phrases : [{"id":29,"title":"","delflag":1},{"id":30,"title":"考虑考虑","delflag":1},{"id":33,"title":"","delflag":1},{"id":34,"title":"","delflag":1},{"id":37,"title":"","delflag":1},{"id":38,"title":"看看","delflag":1},{"id":21,"title":"系统定义常用语不能删除","delflag":0}]
     */

    private int id;
    private String title;
    private List<PhrasesBean> phrases;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<PhrasesBean> getPhrases() {
        return phrases;
    }

    public void setPhrases(List<PhrasesBean> phrases) {
        this.phrases = phrases;
    }

    public static class PhrasesBean implements Serializable {
        /**
         * id : 29
         * title :
         * delflag : 1
         */

        private int id;
        private String title;
        private int delflag;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getDelflag() {
            return delflag;
        }

        public void setDelflag(int delflag) {
            this.delflag = delflag;
        }
    }
}
