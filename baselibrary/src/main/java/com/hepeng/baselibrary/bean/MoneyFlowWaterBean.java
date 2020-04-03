package com.hepeng.baselibrary.bean;

import java.util.List;

public class MoneyFlowWaterBean {

    /**
     * pageNum : 1
     * pageSize : 20
     * size : 20
     * startRow : 1
     * endRow : 20
     * total : 87
     * pages : 5
     * list : [{"typecode":124,"total":0,"createtime":"2019-04-22 00:00:15","orderno":"20190418100257_8816","remark":"以u的[复诊]费用","id":17781,"title":"复诊"},{"typecode":208,"total":0,"createtime":"2019-04-22 00:00:15","orderno":"20190418100257_8816","remark":"以u的[复诊]费用","id":17782,"title":"平台手续费"},{"typecode":119,"total":0,"createtime":"2019-04-17 12:00:01","orderno":"20190415095010_8816","remark":"以u的[图文问诊]问诊费用","id":17204,"title":"普通问诊"},{"typecode":208,"total":0,"createtime":"2019-04-17 12:00:01","orderno":"20190415095010_8816","remark":"以u的[图文问诊]问诊费用","id":17205,"title":"平台手续费"},{"typecode":119,"total":0,"createtime":"2019-04-14 18:00:01","orderno":"20190411152948_8816","remark":"以u的[图文问诊]问诊费用","id":16812,"title":"普通问诊"},{"typecode":208,"total":0,"createtime":"2019-04-14 18:00:01","orderno":"20190411152948_8816","remark":"以u的[图文问诊]问诊费用","id":16813,"title":"平台手续费"},{"typecode":124,"total":0,"createtime":"2019-04-09 06:00:01","orderno":"20190405120201_10414","remark":"小寒的[复诊]费用","id":15949,"title":"复诊"},{"typecode":208,"total":0,"createtime":"2019-04-09 06:00:01","orderno":"20190405120201_10414","remark":"小寒的[复诊]费用","id":15950,"title":"平台手续费"},{"typecode":124,"total":0,"createtime":"2019-04-07 15:00:00","orderno":"20190405121302_1040","remark":"孙康的[复诊]费用","id":15762,"title":"复诊"},{"typecode":208,"total":0,"createtime":"2019-04-07 15:00:00","orderno":"20190405121302_1040","remark":"孙康的[复诊]费用","id":15763,"title":"平台手续费"},{"typecode":124,"total":0,"createtime":"2019-04-07 15:00:00","orderno":"20190405123009_2136","remark":"xiaohei的[复诊]费用","id":15764,"title":"复诊"},{"typecode":208,"total":0,"createtime":"2019-04-07 15:00:00","orderno":"20190405123009_2136","remark":"xiaohei的[复诊]费用","id":15765,"title":"平台手续费"},{"typecode":124,"total":0,"createtime":"2019-04-07 15:00:00","orderno":"20190405130725_2136","remark":"xiaohei的[复诊]费用","id":15766,"title":"复诊"},{"typecode":208,"total":0,"createtime":"2019-04-07 15:00:00","orderno":"20190405130725_2136","remark":"xiaohei的[复诊]费用","id":15767,"title":"平台手续费"},{"typecode":119,"total":0,"createtime":"2019-04-07 06:00:07","orderno":"20190403163045_8816","remark":"以u的[图文问诊]问诊费用","id":15678,"title":"普通问诊"},{"typecode":208,"total":0,"createtime":"2019-04-07 06:00:07","orderno":"20190403163045_8816","remark":"以u的[图文问诊]问诊费用","id":15679,"title":"平台手续费"},{"typecode":119,"total":0,"createtime":"2019-04-06 09:00:06","orderno":"20190402133403_14786","remark":"毛从雯的[图文问诊]问诊费用","id":15369,"title":"普通问诊"},{"typecode":208,"total":0,"createtime":"2019-04-06 09:00:06","orderno":"20190402133403_14786","remark":"毛从雯的[图文问诊]问诊费用","id":15370,"title":"平台手续费"},{"typecode":119,"total":0,"createtime":"2019-04-05 00:00:09","orderno":"20190401103701_4084","remark":"某人的[图文问诊]问诊费用","id":15183,"title":"普通问诊"},{"typecode":208,"total":0,"createtime":"2019-04-05 00:00:09","orderno":"20190401103701_4084","remark":"某人的[图文问诊]问诊费用","id":15184,"title":"平台手续费"}]
     * prePage : 0
     * nextPage : 2
     * isFirstPage : true
     * isLastPage : false
     * hasPreviousPage : false
     * hasNextPage : true
     * navigatePages : 8
     * navigatepageNums : [1,2,3,4,5]
     * navigateFirstPage : 1
     * navigateLastPage : 5
     * firstPage : 1
     * lastPage : 5
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
         * typecode : 124
         * total : 0
         * createtime : 2019-04-22 00:00:15
         * orderno : 20190418100257_8816
         * remark : 以u的[复诊]费用
         * id : 17781
         * title : 复诊
         */

        private int typecode;
        private double total;
        private String createtime;
        private String orderno;
        private String remark;
        private int id;
        private String title;

        public int getTypecode() {
            return typecode;
        }

        public void setTypecode(int typecode) {
            this.typecode = typecode;
        }

        public double getTotal() {
            return total;
        }

        public void setTotal(double total) {
            this.total = total;
        }

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
    }
}
