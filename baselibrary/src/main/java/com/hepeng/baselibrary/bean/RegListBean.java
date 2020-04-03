package com.hepeng.baselibrary.bean;

import java.util.List;

public class RegListBean {

    /**
     * pageNum : 1
     * pageSize : 20
     * size : 20
     * startRow : 1
     * endRow : 20
     * total : 282
     * pages : 15
     * list : [{"createtime":"2019-09-16 21:01:14","orderno":"20190916210114_61079","patientid":18344,"sex":0,"realtotal":65,"endtime":"2019-09-20 17:00:00","starttime":"2019-09-20 13:30:00","realname":"代正先","registerid":943,"hospitalid":0,"hospitalname":"国医在线","id":2283,"timetype":154,"age":54,"status":185,"timetypename":"下午"}]
     * prePage : 0
     * nextPage : 2
     * isFirstPage : true
     * isLastPage : false
     * hasPreviousPage : false
     * hasNextPage : true
     * navigatePages : 8
     * navigatepageNums : [1,2,3,4,5,6,7,8]
     * navigateFirstPage : 1
     * navigateLastPage : 8
     * firstPage : 1
     * lastPage : 8
     */

    private int pageNum;
    private int pageSize;
    private int size;
    private int startRow;
    private int endRow;
    private int total;
    private int pages;
    private int prePage;
    private int nextPage;
    private boolean isFirstPage;
    private boolean isLastPage;
    private boolean hasPreviousPage;
    private boolean hasNextPage;
    private int navigatePages;
    private int navigateFirstPage;
    private int navigateLastPage;
    private int firstPage;
    private int lastPage;
    private List<ListBean> list;
    private List<Integer> navigatepageNums;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public int getEndRow() {
        return endRow;
    }

    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPrePage() {
        return prePage;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public boolean isIsFirstPage() {
        return isFirstPage;
    }

    public void setIsFirstPage(boolean isFirstPage) {
        this.isFirstPage = isFirstPage;
    }

    public boolean isIsLastPage() {
        return isLastPage;
    }

    public void setIsLastPage(boolean isLastPage) {
        this.isLastPage = isLastPage;
    }

    public boolean isHasPreviousPage() {
        return hasPreviousPage;
    }

    public void setHasPreviousPage(boolean hasPreviousPage) {
        this.hasPreviousPage = hasPreviousPage;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public int getNavigatePages() {
        return navigatePages;
    }

    public void setNavigatePages(int navigatePages) {
        this.navigatePages = navigatePages;
    }

    public int getNavigateFirstPage() {
        return navigateFirstPage;
    }

    public void setNavigateFirstPage(int navigateFirstPage) {
        this.navigateFirstPage = navigateFirstPage;
    }

    public int getNavigateLastPage() {
        return navigateLastPage;
    }

    public void setNavigateLastPage(int navigateLastPage) {
        this.navigateLastPage = navigateLastPage;
    }

    public int getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(int firstPage) {
        this.firstPage = firstPage;
    }

    public int getLastPage() {
        return lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public List<Integer> getNavigatepageNums() {
        return navigatepageNums;
    }

    public void setNavigatepageNums(List<Integer> navigatepageNums) {
        this.navigatepageNums = navigatepageNums;
    }

    public static class ListBean {
        /**
         * createtime : 2019-09-16 21:01:14
         * orderno : 20190916210114_61079
         * patientid : 18344
         * sex : 0
         * realtotal : 65
         * endtime : 2019-09-20 17:00:00
         * starttime : 2019-09-20 13:30:00
         * realname : 代正先
         * registerid : 943
         * hospitalid : 0
         * hospitalname : 国医在线
         * id : 2283
         * timetype : 154
         * age : 54
         * status : 185
         * timetypename : 下午
         */

        private String createtime;
        private String orderno;
        private int patientid;
        private int sex;
        private String realtotal;
        private String endtime;
        private String starttime;
        private String realname;
        private int registerid;
        private int hospitalid;
        private String hospitalname;
        private int id;
        private int timetype;
        private int age;
        private int status;
        private String timetypename;

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getOrderno() {
            return orderno;
        }

        public void setOrderno(String orderno) {
            this.orderno = orderno;
        }

        public int getPatientid() {
            return patientid;
        }

        public void setPatientid(int patientid) {
            this.patientid = patientid;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getRealtotal() {
            return realtotal;
        }

        public void setRealtotal(String realtotal) {
            this.realtotal = realtotal;
        }

        public String getEndtime() {
            return endtime;
        }

        public void setEndtime(String endtime) {
            this.endtime = endtime;
        }

        public String getStarttime() {
            return starttime;
        }

        public void setStarttime(String starttime) {
            this.starttime = starttime;
        }

        public String getRealname() {
            return realname;
        }

        public void setRealname(String realname) {
            this.realname = realname;
        }

        public int getRegisterid() {
            return registerid;
        }

        public void setRegisterid(int registerid) {
            this.registerid = registerid;
        }

        public int getHospitalid() {
            return hospitalid;
        }

        public void setHospitalid(int hospitalid) {
            this.hospitalid = hospitalid;
        }

        public String getHospitalname() {
            return hospitalname;
        }

        public void setHospitalname(String hospitalname) {
            this.hospitalname = hospitalname;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getTimetype() {
            return timetype;
        }

        public void setTimetype(int timetype) {
            this.timetype = timetype;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getTimetypename() {
            return timetypename;
        }

        public void setTimetypename(String timetypename) {
            this.timetypename = timetypename;
        }
    }
}
