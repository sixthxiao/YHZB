package com.hepeng.baselibrary.bean;

import java.io.Serializable;
import java.util.List;

public class WebChannelBean implements Serializable {

    /**
     * keycode : bzzx
     * titlepic :
     * remark :
     * id : 24
     * linkurl :
     * title : 帮助中心
     * list : [{"keycode":"cjet","titlepic":"","remark":"","id":27,"linkurl":"","title":"常见问题","list":[{"id":26,"title":"清平乐·候蛩凄断"},{"id":25,"title":"七哀诗三首·其三"},{"id":24,"title":"如何提现？"}]},{"keycode":"hzgl","titlepic":"","remark":"","id":28,"linkurl":"","title":"患者管理","list":[{"id":27,"title":"将进酒"}]},{"keycode":"szfu","titlepic":"","remark":"","id":29,"linkurl":"","title":"设置服务","list":[{"id":28,"title":"桃花源记"}]},{"keycode":"cfkf","titlepic":"","remark":"","id":30,"linkurl":"","title":"处方开方","list":[{"id":29,"title":"陋室铭"},{"id":33,"title":"滕王阁序"}]},{"keycode":"yqtg","titlepic":"","remark":"","id":31,"linkurl":"","title":"邀请推广","list":[{"id":30,"title":"沁园春·雪"},{"id":34,"title":"木兰诗 / 木兰辞"}]},{"keycode":"zjzf","titlepic":"","remark":"","id":32,"linkurl":"","title":"资金支付","list":[{"id":35,"title":"两小儿辩日 / 两小儿辩斗"},{"id":31,"title":"出师表 / 前出师表"},{"id":32,"title":"后出师表"}]}]
     */

    private String keycode;
    private String titlepic;
    private String remark;
    private int id;
    private String linkurl;
    private String title;
    private List<ListBeanX> list;

    public String getKeycode() {
        return keycode;
    }

    public void setKeycode(String keycode) {
        this.keycode = keycode;
    }

    public String getTitlepic() {
        return titlepic;
    }

    public void setTitlepic(String titlepic) {
        this.titlepic = titlepic;
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

    public String getLinkurl() {
        return linkurl;
    }

    public void setLinkurl(String linkurl) {
        this.linkurl = linkurl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ListBeanX> getList() {
        return list;
    }

    public void setList(List<ListBeanX> list) {
        this.list = list;
    }

    public static class ListBeanX implements Serializable{
        /**
         * keycode : cjet
         * titlepic :
         * remark :
         * id : 27
         * linkurl :
         * title : 常见问题
         * list : [{"id":26,"title":"清平乐·候蛩凄断"},{"id":25,"title":"七哀诗三首·其三"},{"id":24,"title":"如何提现？"}]
         */

        private String keycode;
        private String titlepic;
        private String remark;
        private int id;
        private String linkurl;
        private String title;
        private List<ListBean> list;

        public String getKeycode() {
            return keycode;
        }

        public void setKeycode(String keycode) {
            this.keycode = keycode;
        }

        public String getTitlepic() {
            return titlepic;
        }

        public void setTitlepic(String titlepic) {
            this.titlepic = titlepic;
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

        public String getLinkurl() {
            return linkurl;
        }

        public void setLinkurl(String linkurl) {
            this.linkurl = linkurl;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean implements Serializable{
            /**
             * id : 26
             * title : 清平乐·候蛩凄断
             */

            private int id;
            private String title;

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
        }
    }
}
