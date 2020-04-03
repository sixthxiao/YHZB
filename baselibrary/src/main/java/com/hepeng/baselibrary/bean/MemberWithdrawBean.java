package com.hepeng.baselibrary.bean;

import java.util.List;

public class MemberWithdrawBean {

    /**
     * pageNum : 1
     * pageSize : 20
     * size : 20
     * startRow : 1
     * endRow : 20
     * total : 22
     * pages : 2
     * list : [{"createtime":"2019-11-10 16:48:15","month":"11","hour":"16:48","finaltotal":1,"id":677,"paytypename":"微信","paytype":129,"day":"10","memberid":23040,"status":0},{"createtime":"2019-09-05 16:54:20","month":"09","hour":"16:54","finaltotal":1,"id":652,"paytypename":"微信","paytype":129,"day":"05","memberid":23040,"status":-1},{"createtime":"2019-09-02 17:25:29","month":"09","hour":"17:25","finaltotal":1,"id":647,"paytypename":"微信","paytype":129,"day":"02","memberid":23040,"status":-1},{"createtime":"2019-04-16 11:38:52","month":"04","hour":"11:38","finaltotal":1,"id":426,"paytypename":"微信","paytype":129,"day":"16","memberid":23040,"status":0},{"createtime":"2019-04-09 10:48:18","month":"04","hour":"10:48","finaltotal":1,"id":412,"paytypename":"微信","paytype":129,"day":"09","memberid":23040,"status":-1},{"createtime":"2019-04-04 16:06:23","month":"04","hour":"16:06","finaltotal":1,"id":400,"paytypename":"微信","paytype":129,"day":"04","memberid":23040,"status":-1},{"createtime":"2019-04-04 16:03:24","month":"04","hour":"16:03","finaltotal":1,"id":399,"paytypename":"微信","paytype":129,"day":"04","memberid":23040,"status":-1},{"createtime":"2019-04-04 15:58:19","month":"04","hour":"15:58","finaltotal":1,"id":398,"paytypename":"微信","paytype":129,"day":"04","memberid":23040,"status":-1},{"createtime":"2019-04-04 15:52:10","month":"04","hour":"15:52","finaltotal":1,"id":397,"paytypename":"支付宝","paytype":130,"day":"04","memberid":23040,"status":-1},{"createtime":"2019-04-04 15:52:01","month":"04","hour":"15:52","finaltotal":1,"id":396,"paytypename":"微信","paytype":129,"day":"04","memberid":23040,"status":1},{"createtime":"2019-04-04 15:50:08","month":"04","hour":"15:50","finaltotal":1,"id":395,"paytypename":"微信","paytype":129,"day":"04","memberid":23040,"status":-1},{"createtime":"2019-04-04 15:49:25","month":"04","hour":"15:49","finaltotal":1,"id":394,"paytypename":"微信","paytype":129,"day":"04","memberid":23040,"status":-1},{"createtime":"2019-04-02 09:59:44","month":"04","hour":"09:59","finaltotal":1,"id":360,"paytypename":"微信","paytype":129,"day":"02","memberid":23040,"status":-1},{"createtime":"2019-04-01 16:35:48","month":"04","hour":"16:35","finaltotal":1,"id":356,"paytypename":"微信","paytype":129,"day":"01","memberid":23040,"status":-1},{"createtime":"2019-04-01 10:42:26","month":"04","hour":"10:42","finaltotal":1,"id":349,"paytypename":"微信","paytype":129,"day":"01","memberid":23040,"status":-1},{"createtime":"2019-04-01 10:42:19","month":"04","hour":"10:42","finaltotal":1,"id":348,"paytypename":"微信","paytype":129,"day":"01","memberid":23040,"status":-1},{"createtime":"2019-04-01 10:35:58","month":"04","hour":"10:35","finaltotal":1,"id":347,"paytypename":"微信","paytype":129,"day":"01","memberid":23040,"status":-1},{"createtime":"2019-04-01 10:29:43","month":"04","hour":"10:29","finaltotal":1,"id":346,"paytypename":"微信","paytype":129,"day":"01","memberid":23040,"status":-1},{"createtime":"2019-04-01 10:22:57","month":"04","hour":"10:22","finaltotal":1,"id":345,"paytypename":"微信","paytype":129,"day":"01","memberid":23040,"status":-1},{"createtime":"2019-04-01 10:21:50","month":"04","hour":"10:21","finaltotal":1,"id":344,"paytypename":"支付宝","paytype":130,"day":"01","memberid":23040,"status":-1}]
     * prePage : 0
     * nextPage : 2
     * isFirstPage : true
     * isLastPage : false
     * hasPreviousPage : false
     * hasNextPage : true
     * navigatePages : 8
     * navigatepageNums : [1,2]
     * navigateFirstPage : 1
     * navigateLastPage : 2
     * lastPage : 2
     * firstPage : 1
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
    private int lastPage;
    private int firstPage;
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

    public int getLastPage() {
        return lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public int getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(int firstPage) {
        this.firstPage = firstPage;
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
         * createtime : 2019-11-10 16:48:15
         * month : 11
         * hour : 16:48
         * finaltotal : 1
         * id : 677
         * paytypename : 微信
         * paytype : 129
         * day : 10
         * memberid : 23040
         * status : 0
         */

        private String createtime;
        private String month;
        private String hour;
        private double finaltotal;
        private int id;
        private String paytypename;
        private int paytype;
        private String day;
        private int memberid;
        private int status;

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getMonth() {
            return month;
        }

        public void setMonth(String month) {
            this.month = month;
        }

        public String getHour() {
            return hour;
        }

        public void setHour(String hour) {
            this.hour = hour;
        }

        public double getFinaltotal() {
            return finaltotal;
        }

        public void setFinaltotal(double finaltotal) {
            this.finaltotal = finaltotal;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPaytypename() {
            return paytypename;
        }

        public void setPaytypename(String paytypename) {
            this.paytypename = paytypename;
        }

        public int getPaytype() {
            return paytype;
        }

        public void setPaytype(int paytype) {
            this.paytype = paytype;
        }

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public int getMemberid() {
            return memberid;
        }

        public void setMemberid(int memberid) {
            this.memberid = memberid;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
