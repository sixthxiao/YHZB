package com.hepeng.baselibrary.bean;

import java.io.Serializable;
import java.util.List;

public class TemplateBean implements Serializable {

    /**
     * pageNum : 1
     * pageSize : 20
     * size : 1
     * startRow : 1
     * endRow : 1
     * total : 1
     * pages : 1
     * list : [{"typecode":1,"createtime":"2019-04-04 11:38:57","doctorid":"2015","medicine":[{"unit":"g","limitmax":0,"max":0,"medicineid":1621,"num":5,"id":6608,"title":"三棱配方颗粒","limitmin":0},{"unit":"包","limitmax":0,"max":0,"medicineid":2012,"num":1,"id":6611,"title":"五味子K","limitmin":0},{"unit":"包","limitmax":0,"max":0,"medicineid":2060,"num":1,"id":6614,"title":"六神曲K","limitmin":0}],"id":228,"title":"默默哦哦"}]
     * prePage : 0
     * nextPage : 0
     * isFirstPage : true
     * isLastPage : true
     * hasPreviousPage : false
     * hasNextPage : false
     * navigatePages : 8
     * navigatepageNums : [1]
     * navigateFirstPage : 1
     * navigateLastPage : 1
     * lastPage : 1
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

    public static class ListBean implements Serializable {
        /**
         * typecode : 1
         * createtime : 2019-04-04 11:38:57
         * doctorid : 2015
         * medicine : [{"unit":"g","limitmax":0,"max":0,"medicineid":1621,"num":5,"id":6608,"title":"三棱配方颗粒","limitmin":0},{"unit":"包","limitmax":0,"max":0,"medicineid":2012,"num":1,"id":6611,"title":"五味子K","limitmin":0},{"unit":"包","limitmax":0,"max":0,"medicineid":2060,"num":1,"id":6614,"title":"六神曲K","limitmin":0}]
         * id : 228
         * title : 默默哦哦
         */

        private int typecode;
        private String createtime;
        private String doctorid;
        private int id;
        private String title;
        private List<MedicineBean> medicine;

        private List<MedicineBean> templateList;
        private boolean isSelect = false;

        public boolean isSelect() {
            return isSelect;
        }

        public void setSelect(boolean select) {
            isSelect = select;
        }

        public List<MedicineBean> getTemplateList() {
            return templateList;
        }

        public void setTemplateList(List<MedicineBean> templateList) {
            this.templateList = templateList;
        }

        public int getTypecode() {
            return typecode;
        }

        public void setTypecode(int typecode) {
            this.typecode = typecode;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getDoctorid() {
            return doctorid;
        }

        public void setDoctorid(String doctorid) {
            this.doctorid = doctorid;
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

        public List<MedicineBean> getMedicine() {
            return medicine;
        }

        public void setMedicine(List<MedicineBean> medicine) {
            this.medicine = medicine;
        }

        public static class MedicineBean implements Serializable {
            /**
             * unit : g
             * limitmax : 0
             * max : 0
             * medicineid : 1621
             * num : 5
             * id : 6608
             * title : 三棱配方颗粒
             * limitmin : 0
             */

            private String unit;
            private int limitmax;
            private int max;
            private int medicineid;
            private double num;
            private int id;
            private String title;
            private int limitmin;
            private String otherids;

            public String getOtherids() {
                return otherids;
            }

            public void setOtherids(String otherids) {
                this.otherids = otherids;
            }

            public String getUnit() {
                return unit;
            }

            public void setUnit(String unit) {
                this.unit = unit;
            }

            public int getLimitmax() {
                return limitmax;
            }

            public void setLimitmax(int limitmax) {
                this.limitmax = limitmax;
            }

            public int getMax() {
                return max;
            }

            public void setMax(int max) {
                this.max = max;
            }

            public int getMedicineid() {
                return medicineid;
            }

            public void setMedicineid(int medicineid) {
                this.medicineid = medicineid;
            }

            public int getNum() {
                return (int) num;
            }

            public void setNum(double num) {
                this.num = num;
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

            public int getLimitmin() {
                return limitmin;
            }

            public void setLimitmin(int limitmin) {
                this.limitmin = limitmin;
            }
        }
    }
}


