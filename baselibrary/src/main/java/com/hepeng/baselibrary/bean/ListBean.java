package com.hepeng.baselibrary.bean;

import java.util.List;

public class ListBean {

    /**
     * total : 35
     * orders : [{"id":"20190703151208_17417","parentOrderId":"20190703151208_17417","orderStatus":"2","pid":17417,"type":3,"type1":1,"recordTime":"2019-07-03 15:12:08","money":0,"startTime":"2019-07-03 15:12:08","endTime":"","finishTime":"2019-07-05 06:00:02","did":20525,"status":3,"sex":0,"fullName":"王陈斌","age":25,"diseaseDescription":"岐黄哈哈哈哈哈哈哈哈哈","prescription":"0","directionTreatment":"","imName":"1550725072_17417"}]
     */

    private int total;
    private List<OrdersBean> orders;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<OrdersBean> getOrders() {
        return orders;
    }

    public void setOrders(List<OrdersBean> orders) {
        this.orders = orders;
    }

    public static class OrdersBean {
        /**
         * id : 20190703151208_17417
         * parentOrderId : 20190703151208_17417
         * orderStatus : 2
         * pid : 17417
         * type : 3
         * type1 : 1
         * recordTime : 2019-07-03 15:12:08
         * money : 0
         * startTime : 2019-07-03 15:12:08
         * endTime :
         * finishTime : 2019-07-05 06:00:02
         * did : 20525
         * status : 3
         * sex : 0
         * fullName : 王陈斌
         * age : 25
         * diseaseDescription : 岐黄哈哈哈哈哈哈哈哈哈
         * prescription : 0
         * directionTreatment :
         * imName : 1550725072_17417
         */

        private String id;
        private String parentOrderId;
        private String orderStatus;
        private int pid;
        private int type;
        private int type1;
        private String recordTime;
        private int money;
        private String startTime;
        private String endTime;
        private String finishTime;
        private int did;
        private int status;
        private int sex;
        private String fullName;
        private int age;
        private String diseaseDescription;
        private String prescription;
        private String directionTreatment;
        private String imName;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getParentOrderId() {
            return parentOrderId;
        }

        public void setParentOrderId(String parentOrderId) {
            this.parentOrderId = parentOrderId;
        }

        public String getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
        }

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getType1() {
            return type1;
        }

        public void setType1(int type1) {
            this.type1 = type1;
        }

        public String getRecordTime() {
            return recordTime;
        }

        public void setRecordTime(String recordTime) {
            this.recordTime = recordTime;
        }

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            this.money = money;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getFinishTime() {
            return finishTime;
        }

        public void setFinishTime(String finishTime) {
            this.finishTime = finishTime;
        }

        public int getDid() {
            return did;
        }

        public void setDid(int did) {
            this.did = did;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getDiseaseDescription() {
            return diseaseDescription;
        }

        public void setDiseaseDescription(String diseaseDescription) {
            this.diseaseDescription = diseaseDescription;
        }

        public String getPrescription() {
            return prescription;
        }

        public void setPrescription(String prescription) {
            this.prescription = prescription;
        }

        public String getDirectionTreatment() {
            return directionTreatment;
        }

        public void setDirectionTreatment(String directionTreatment) {
            this.directionTreatment = directionTreatment;
        }

        public String getImName() {
            return imName;
        }

        public void setImName(String imName) {
            this.imName = imName;
        }
    }
}
