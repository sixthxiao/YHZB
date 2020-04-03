package com.hepeng.baselibrary.bean;

import java.util.List;

public class StateInfoBean {

    /**
     * issendstate : 0
     * statelist : [{"keycode":"0","remark":null,"id":163,"title":"成人（男）","remark2":null},{"keycode":"1","remark":null,"id":164,"title":"成人（女）","remark2":null},{"keycode":"3","remark":null,"id":165,"title":"小孩（男）","remark2":null},{"keycode":"4","remark":null,"id":166,"title":"小孩（女）","remark2":null}]
     * id : 203
     */

    private int issendstate;
    private int id;
    private List<StatelistBean> statelist;

    public int getIssendstate() {
        return issendstate;
    }

    public void setIssendstate(int issendstate) {
        this.issendstate = issendstate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<StatelistBean> getStatelist() {
        return statelist;
    }

    public void setStatelist(List<StatelistBean> statelist) {
        this.statelist = statelist;
    }

    public static class StatelistBean {
        /**
         * keycode : 0
         * remark : null
         * id : 163
         * title : 成人（男）
         * remark2 : null
         */

        private String keycode;
        private String remark = "";
        private int id;
        private String title;
        private Object remark2;

        public String getKeycode() {
            return keycode;
        }

        public void setKeycode(String keycode) {
            this.keycode = keycode;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

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

        public Object getRemark2() {
            return remark2;
        }

        public void setRemark2(Object remark2) {
            this.remark2 = remark2;
        }
    }
}
