package com.hepeng.baselibrary.bean;

import java.util.List;

public class EvaluateTitleBean {

    /**
     * total : 15
     * list : [{"tag_id":"189","title":"回复及时(3)"},{"tag_id":"190","title":"态度友好(8)"},{"tag_id":"191","title":"意见很有帮助(2)"},{"tag_id":"192","title":"十分专业(2)"},{"tag_id":"193","title":"很有耐心(2)"}]
     */

    private int total;
    private List<ListBean> list;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * tag_id : 189
         * title : 回复及时(3)
         */

        private String tag_id;
        private String title;
        private boolean isSelect = false;

        public String getTag_id() {
            return tag_id;
        }

        public void setTag_id(String tag_id) {
            this.tag_id = tag_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isSelect() {
            return isSelect;
        }

        public void setSelect(boolean select) {
            isSelect = select;
        }
    }
}
