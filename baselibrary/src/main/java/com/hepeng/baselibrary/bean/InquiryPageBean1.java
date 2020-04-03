package com.hepeng.baselibrary.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

public class InquiryPageBean1 implements MultiItemEntity {

    /**
     * statetype : 0
     * answer : [{"id":1,"title":"拉拉拉拉"}]
     * id : 1
     * title : 肚子
     */

    private int statetype;
    private int id;
    private String title;
    private List<AnswerBean> answer;

    public int getStatetype() {
        return statetype;
    }

    public void setStatetype(int statetype) {
        this.statetype = statetype;
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

    public List<AnswerBean> getAnswer() {
        return answer;
    }

    public void setAnswer(List<AnswerBean> answer) {
        this.answer = answer;
    }

    @Override
    public int getItemType() {
        return statetype;
    }

    public static class AnswerBean {
        /**
         * id : 1
         * title : 拉拉拉拉
         */

        private int id;
        private String title;
        private String answer;

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
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
    }
}
