package com.hepeng.baselibrary.bean;

import android.text.TextUtils;

import java.util.List;

public class CalendarBan {

    private List<List<AskListBean>> askList;

    public List<List<AskListBean>> getAskList() {
        return askList;
    }

    public void setAskList(List<List<AskListBean>> askList) {
        this.askList = askList;
    }

    public static class AskListBean {
        /**
         * title :
         * nowDate : null
         * isEdit : 0
         * weekDay : null
         * askid : null
         * addressid : null
         * timetype : null
         */

        private String title;
        private String nowDate;
        private String isEdit;
        private String weekDay;
        private String askid;
        private String addressid;
        private String timetype;
        private String hospitalname;
        private String starttime;
        private String endtime;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getNowDate() {
            if (TextUtils.isEmpty(nowDate)) {
                return "";
            }
            return nowDate;
        }

        public void setNowDate(String nowDate) {
            this.nowDate = nowDate;
        }

        public String getIsEdit() {
            return isEdit;
        }

        public void setIsEdit(String isEdit) {
            this.isEdit = isEdit;
        }

        public String getWeekDay() {
            if (TextUtils.isEmpty(weekDay)) {
                return "";
            }
            return weekDay;
        }

        public void setWeekDay(String weekDay) {
            this.weekDay = weekDay;
        }

        public String getAskid() {
            if (TextUtils.isEmpty(askid)) {
                return "";
            }
            return askid;
        }

        public void setAskid(String askid) {
            this.askid = askid;
        }

        public String getAddressid() {
            if (TextUtils.isEmpty(addressid)) {
                return "";
            }
            return addressid;
        }

        public void setAddressid(String addressid) {
            this.addressid = addressid;
        }

        public String getTimetype() {
            if (TextUtils.isEmpty(timetype)) {
                return "";
            }
            return timetype;
        }

        public void setTimetype(String timetype) {
            this.timetype = timetype;
        }

        public String getHospitalname() {
            if (TextUtils.isEmpty(hospitalname)) {
                return "";
            }
            return hospitalname;
        }

        public void setHospitalname(String hospitalname) {
            this.hospitalname = hospitalname;
        }

        public String getStarttime() {
            if (TextUtils.isEmpty(starttime)) {
                return "";
            }
            return starttime;
        }

        public void setStarttime(String starttime) {
            this.starttime = starttime;
        }

        public String getEndtime() {
            if (TextUtils.isEmpty(endtime)) {
                return "";
            }
            return endtime;
        }

        public void setEndtime(String endtime) {
            this.endtime = endtime;
        }
    }
}
