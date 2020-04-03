package com.hepeng.baselibrary.bean;

import java.io.Serializable;
import java.util.List;

public class RegionListBean implements Serializable {

    /**
     * keycode : 100000
     * parentcode : 0
     * ordernum : 0
     * id : 1
     * title : 北京
     * list : [{"keycode":"110000","parentcode":"100000","ordernum":0,"id":2,"title":"北京市","list":[{"keycode":"110101","parentcode":"110000","ordernum":0,"id":3,"title":"东城区","list":[]},{"keycode":"110102","parentcode":"110000","ordernum":0,"id":4,"title":"西城区","list":[]},{"keycode":"110105","parentcode":"110000","ordernum":0,"id":5,"title":"朝阳区","list":[]},{"keycode":"110106","parentcode":"110000","ordernum":0,"id":6,"title":"丰台区","list":[]},{"keycode":"110107","parentcode":"110000","ordernum":0,"id":7,"title":"石景山区","list":[]},{"keycode":"110108","parentcode":"110000","ordernum":0,"id":8,"title":"海淀区","list":[]},{"keycode":"110109","parentcode":"110000","ordernum":0,"id":9,"title":"门头沟区","list":[]},{"keycode":"110111","parentcode":"110000","ordernum":0,"id":10,"title":"房山区","list":[]},{"keycode":"110112","parentcode":"110000","ordernum":0,"id":11,"title":"通州区","list":[]},{"keycode":"110113","parentcode":"110000","ordernum":0,"id":12,"title":"顺义区","list":[]},{"keycode":"110114","parentcode":"110000","ordernum":0,"id":13,"title":"昌平区","list":[]},{"keycode":"110115","parentcode":"110000","ordernum":0,"id":14,"title":"大兴区","list":[]},{"keycode":"110116","parentcode":"110000","ordernum":0,"id":15,"title":"怀柔区","list":[]},{"keycode":"110117","parentcode":"110000","ordernum":0,"id":16,"title":"平谷区","list":[]},{"keycode":"110118","parentcode":"110000","ordernum":0,"id":17,"title":"密云区","list":[]},{"keycode":"110119","parentcode":"110000","ordernum":0,"id":18,"title":"延庆区","list":[]}]}]
     */

    private String keycode;
    private String parentcode;
    private int ordernum;
    private int id;
    private String title;
    private List<ListBeanX> list;

    public String getKeycode() {
        return keycode;
    }

    public void setKeycode(String keycode) {
        this.keycode = keycode;
    }

    public String getParentcode() {
        return parentcode;
    }

    public void setParentcode(String parentcode) {
        this.parentcode = parentcode;
    }

    public int getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(int ordernum) {
        this.ordernum = ordernum;
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

    public List<ListBeanX> getList() {
        return list;
    }

    public void setList(List<ListBeanX> list) {
        this.list = list;
    }

    public static class ListBeanX implements Serializable {
        /**
         * keycode : 110000
         * parentcode : 100000
         * ordernum : 0
         * id : 2
         * title : 北京市
         * list : [{"keycode":"110101","parentcode":"110000","ordernum":0,"id":3,"title":"东城区","list":[]},{"keycode":"110102","parentcode":"110000","ordernum":0,"id":4,"title":"西城区","list":[]},{"keycode":"110105","parentcode":"110000","ordernum":0,"id":5,"title":"朝阳区","list":[]},{"keycode":"110106","parentcode":"110000","ordernum":0,"id":6,"title":"丰台区","list":[]},{"keycode":"110107","parentcode":"110000","ordernum":0,"id":7,"title":"石景山区","list":[]},{"keycode":"110108","parentcode":"110000","ordernum":0,"id":8,"title":"海淀区","list":[]},{"keycode":"110109","parentcode":"110000","ordernum":0,"id":9,"title":"门头沟区","list":[]},{"keycode":"110111","parentcode":"110000","ordernum":0,"id":10,"title":"房山区","list":[]},{"keycode":"110112","parentcode":"110000","ordernum":0,"id":11,"title":"通州区","list":[]},{"keycode":"110113","parentcode":"110000","ordernum":0,"id":12,"title":"顺义区","list":[]},{"keycode":"110114","parentcode":"110000","ordernum":0,"id":13,"title":"昌平区","list":[]},{"keycode":"110115","parentcode":"110000","ordernum":0,"id":14,"title":"大兴区","list":[]},{"keycode":"110116","parentcode":"110000","ordernum":0,"id":15,"title":"怀柔区","list":[]},{"keycode":"110117","parentcode":"110000","ordernum":0,"id":16,"title":"平谷区","list":[]},{"keycode":"110118","parentcode":"110000","ordernum":0,"id":17,"title":"密云区","list":[]},{"keycode":"110119","parentcode":"110000","ordernum":0,"id":18,"title":"延庆区","list":[]}]
         */

        private String keycode;
        private String parentcode;
        private int ordernum;
        private int id;
        private String title;
        private List<ListBean> list;

        public String getKeycode() {
            return keycode;
        }

        public void setKeycode(String keycode) {
            this.keycode = keycode;
        }

        public String getParentcode() {
            return parentcode;
        }

        public void setParentcode(String parentcode) {
            this.parentcode = parentcode;
        }

        public int getOrdernum() {
            return ordernum;
        }

        public void setOrdernum(int ordernum) {
            this.ordernum = ordernum;
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

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean implements Serializable {
            /**
             * keycode : 110101
             * parentcode : 110000
             * ordernum : 0
             * id : 3
             * title : 东城区
             * list : []
             */

            private String keycode;
            private String parentcode;
            private int ordernum;
            private int id;
            private String title;
            private List<?> list;

            public String getKeycode() {
                return keycode;
            }

            public void setKeycode(String keycode) {
                this.keycode = keycode;
            }

            public String getParentcode() {
                return parentcode;
            }

            public void setParentcode(String parentcode) {
                this.parentcode = parentcode;
            }

            public int getOrdernum() {
                return ordernum;
            }

            public void setOrdernum(int ordernum) {
                this.ordernum = ordernum;
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

            public List<?> getList() {
                return list;
            }

            public void setList(List<?> list) {
                this.list = list;
            }

        }
    }
}
