package com.hepeng.baselibrary.bean;

import android.text.TextUtils;

import java.util.List;

public class InquiryListBean {

    /**
     * pageNum : 1
     * pageSize : 20
     * size : 12
     * startRow : 1
     * endRow : 12
     * total : 12
     * pages : 1
     * list : [{"createtime":"2019-10-26 17:07:22","img":"201907/2771475748884258.jpg","orderno":"A20191026170722_65128","patientid":18449,"sex":1,"endtime":"","starttime":"","doctorname":"张天(国医在线)","typecode":0,"patientname":"吴美琪","finishtime":"","jobid":35,"total":0,"doctorid":2020,"hospitalid":52,"hospitalname":"寻甸县中医医院","categoryname":"","id":32810,"age":28,"jobname":"副主任医师","categoryid":1765,"status":168},{"createtime":"2019-10-26 17:02:55","img":"201907/2771475748884258.jpg","orderno":"A20191026170255_80593","endtime":"","starttime":"","doctorname":"张天(国医在线)","typecode":1,"finishtime":"","jobid":35,"total":200,"doctorid":2020,"hospitalid":52,"hospitalname":"寻甸县中医医院","categoryname":"","id":32809,"jobname":"副主任医师","categoryid":1765,"status":167},{"createtime":"2019-10-26 14:26:46","img":"201907/2771475748884258.jpg","orderno":"A20191026142646_85498","patientid":18449,"sex":1,"endtime":"","starttime":"","doctorname":"张天(国医在线)","typecode":1,"patientname":"吴美琪","finishtime":"","jobid":35,"total":200,"doctorid":2020,"hospitalid":52,"hospitalname":"寻甸县中医医院","categoryname":"","id":32808,"age":28,"jobname":"副主任医师","categoryid":1765,"status":167},{"createtime":"2019-10-26 14:19:52","img":"201907/2771475748884258.jpg","orderno":"A20191026141951_29547","patientid":18448,"sex":0,"endtime":"","starttime":"","doctorname":"张天(国医在线)","typecode":1,"patientname":"唐三202","finishtime":"","jobid":35,"total":200,"doctorid":2020,"hospitalid":52,"hospitalname":"寻甸县中医医院","categoryname":"","id":32807,"age":24,"jobname":"副主任医师","categoryid":1765,"status":167},{"createtime":"2019-10-26 14:19:38","img":"201907/2771475748884258.jpg","orderno":"A20191026141937_61427","endtime":"","starttime":"","doctorname":"张天(国医在线)","typecode":1,"finishtime":"","jobid":35,"total":200,"doctorid":2020,"hospitalid":52,"hospitalname":"寻甸县中医医院","categoryname":"","id":32806,"jobname":"副主任医师","categoryid":1765,"status":167},{"createtime":"2019-10-26 14:19:15","img":"201907/2771475748884258.jpg","orderno":"A20191026141914_51266","endtime":"","starttime":"","doctorname":"张天(国医在线)","typecode":1,"finishtime":"","jobid":35,"total":200,"doctorid":2020,"hospitalid":52,"hospitalname":"寻甸县中医医院","categoryname":"","id":32805,"jobname":"副主任医师","categoryid":1765,"status":167},{"createtime":"2019-10-26 14:18:50","img":"201907/2771475748884258.jpg","orderno":"A20191026141850_76577","endtime":"","starttime":"","doctorname":"张天(国医在线)","typecode":1,"finishtime":"","jobid":35,"total":200,"doctorid":2020,"hospitalid":52,"hospitalname":"寻甸县中医医院","categoryname":"","id":32804,"jobname":"副主任医师","categoryid":1765,"status":167},{"createtime":"2019-10-26 14:18:29","img":"201907/2771475748884258.jpg","orderno":"A20191026141829_42802","endtime":"","starttime":"","doctorname":"张天(国医在线)","typecode":1,"finishtime":"","jobid":35,"total":200,"doctorid":2020,"hospitalid":52,"hospitalname":"寻甸县中医医院","categoryname":"","id":32803,"jobname":"副主任医师","categoryid":1765,"status":167},{"createtime":"2019-10-26 14:17:10","img":"201907/2771475748884258.jpg","orderno":"A20191026141709_35378","endtime":"","starttime":"","doctorname":"张天(国医在线)","typecode":1,"finishtime":"","jobid":35,"total":200,"doctorid":2020,"hospitalid":52,"hospitalname":"寻甸县中医医院","categoryname":"","id":32802,"jobname":"副主任医师","categoryid":1765,"status":167},{"createtime":"2019-10-26 14:16:06","img":"201907/2771475748884258.jpg","orderno":"A20191026141606_12002","endtime":"","starttime":"","doctorname":"张天(国医在线)","typecode":1,"finishtime":"","jobid":35,"total":200,"doctorid":2020,"hospitalid":52,"hospitalname":"寻甸县中医医院","categoryname":"","id":32801,"jobname":"副主任医师","categoryid":1765,"status":167},{"createtime":"2019-10-26 14:15:26","img":"201907/2771475748884258.jpg","orderno":"A20191026141525_60574","endtime":"","starttime":"","doctorname":"张天(国医在线)","typecode":1,"finishtime":"","jobid":35,"total":200,"doctorid":2020,"hospitalid":52,"hospitalname":"寻甸县中医医院","categoryname":"","id":32800,"jobname":"副主任医师","categoryid":1765,"status":167},{"createtime":"2019-10-18 14:19:07","img":"201907/2771475748884258.jpg","orderno":"A20191018141907_19693","patientid":18448,"sex":0,"endtime":"","starttime":"","doctorname":"张天(国医在线)","typecode":2,"patientname":"唐三202","finishtime":"","jobid":35,"total":1500,"doctorid":2020,"hospitalid":52,"hospitalname":"寻甸县中医医院","categoryname":"","id":32796,"age":24,"jobname":"副主任医师","categoryid":1765,"status":167}]
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

    public static class ListBean {
        /**
         * createtime : 2019-10-26 17:07:22
         * img : 201907/2771475748884258.jpg
         * orderno : A20191026170722_65128
         * patientid : 18449
         * sex : 1
         * endtime :
         * starttime :
         * doctorname : 张天(国医在线)
         * typecode : 0
         * patientname : 吴美琪
         * finishtime :
         * jobid : 35
         * total : 0
         * doctorid : 2020
         * hospitalid : 52
         * hospitalname : 寻甸县中医医院
         * categoryname :
         * id : 32810
         * age : 28
         * jobname : 副主任医师
         * categoryid : 1765
         * status : 168
         */

        private String createtime;
        private String img;
        private String orderno;
        private int patientid;
        private int sex;
        private String endtime;
        private String starttime;
        private String doctorname;
        private int typecode;
        private String patientname;
        private String finishtime;
        private int jobid;
        private double total;
        private int doctorid;
        private int hospitalid;
        private String hospitalname;
        private String categoryname;
        private int id;
        private int age;
        private String jobname;
        private int categoryid;
        private int status;

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
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

        public String getDoctorname() {
            return doctorname;
        }

        public void setDoctorname(String doctorname) {
            this.doctorname = doctorname;
        }

        public int getTypecode() {
            return typecode;
        }

        public void setTypecode(int typecode) {
            this.typecode = typecode;
        }

        public String getPatientname() {
            if (TextUtils.isEmpty(patientname)) {
                return "--";
            }
            return patientname;
        }

        public void setPatientname(String patientname) {
            this.patientname = patientname;
        }

        public String getFinishtime() {
            return finishtime;
        }

        public void setFinishtime(String finishtime) {
            this.finishtime = finishtime;
        }

        public int getJobid() {
            return jobid;
        }

        public void setJobid(int jobid) {
            this.jobid = jobid;
        }

        public double getTotal() {
            return total;
        }

        public void setTotal(double total) {
            this.total = total;
        }

        public int getDoctorid() {
            return doctorid;
        }

        public void setDoctorid(int doctorid) {
            this.doctorid = doctorid;
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

        public String getCategoryname() {
            return categoryname;
        }

        public void setCategoryname(String categoryname) {
            this.categoryname = categoryname;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getJobname() {
            return jobname;
        }

        public void setJobname(String jobname) {
            this.jobname = jobname;
        }

        public int getCategoryid() {
            return categoryid;
        }

        public void setCategoryid(int categoryid) {
            this.categoryid = categoryid;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
