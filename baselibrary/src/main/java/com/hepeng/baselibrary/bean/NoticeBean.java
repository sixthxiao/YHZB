package com.hepeng.baselibrary.bean;

import java.io.Serializable;
import java.util.List;

public class NoticeBean {

    /**
     * pageNum : 1
     * pageSize : 20
     * size : 2
     * startRow : 1
     * endRow : 2
     * total : 2
     * pages : 1
     * list : [{"imgs":"","createtime":"2019-12-04 16:37:14","doctorid":2016,"id":15,"content":"JJ考虑考虑空军建军节考虑考虑空军建军节考虑考虑空军建军节考虑考虑空军建军节考虑考虑空军建军节考虑考虑空军建军节考虑考虑空军建军节考虑考虑空军建军节考虑考虑空军建军节考虑考虑空军建军节考虑考虑空军建军节考虑考虑空军建军节考虑考虑空军建军节考虑考虑空军建军节考虑考虑空军建军节考虑考虑空军建军节考虑考虑空军建军节"},{"imgs":",https://dev-1257318792.cos.ap-chongqing.myqcloud.com/doctor/2019-12-04/20191204162918_1wwboxqt29.jpg","createtime":"2019-12-04 16:29:49","doctorid":2016,"id":13,"content":"啦咯啦咯啦咯来lol哦YYKKK啦咯啦咯啦咯考虑考虑空军建军节啦咯啦咯就考虑图hill哦空军建军节啦咯啦咯啦咯啦咯啦咯啦空军建军节啊啊啊吧UK图JJ空军建军节啦咯啦咯啦咯啦啦咯啦咯啦咯啦啦咯啦咯啦咯啦咯啦咯啦咯啦咯啦咯啦咯啦咯啦咯啦咯啦咯啦咯啦咯阿里啦咯啦咯啦咯不会死了KKK啦咯啦咯啦咯啦咯啦啦咯啦咯啦咯啦咯啦咯啦咯啦咯崭露头角啦咯啦咯啦咯空军建军节考虑考虑空军建军节考虑考虑空军建军节考虑考虑空军建军节考虑考虑空军建军节考虑考虑空军建军节考虑考虑空军建军节考虑考虑空军建军节考虑考虑空军建军节考虑考虑空军建军节考虑考虑空军建军节考虑考虑空军建军节考虑考虑空军建军节考虑考虑空军建军节考虑考虑空军建"}]
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
     * firstPage : 1
     * lastPage : 1
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

    public static class ListBean implements Serializable {
        /**
         * imgs :
         * createtime : 2019-12-04 16:37:14
         * doctorid : 2016
         * id : 15
         * content : JJ考虑考虑空军建军节考虑考虑空军建军节考虑考虑空军建军节考虑考虑空军建军节考虑考虑空军建军节考虑考虑空军建军节考虑考虑空军建军节考虑考虑空军建军节考虑考虑空军建军节考虑考虑空军建军节考虑考虑空军建军节考虑考虑空军建军节考虑考虑空军建军节考虑考虑空军建军节考虑考虑空军建军节考虑考虑空军建军节考虑考虑空军建军节
         */

        private String imgs;
        private String createtime;
        private int doctorid;
        private int id;
        private String content;

        public String getImgs() {
            return imgs;
        }

        public void setImgs(String imgs) {
            this.imgs = imgs;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public int getDoctorid() {
            return doctorid;
        }

        public void setDoctorid(int doctorid) {
            this.doctorid = doctorid;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
