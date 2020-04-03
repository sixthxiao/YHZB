package com.hepeng.baselibrary.bean;

import java.util.List;

public class ChangePharBean {

    /**
     * kindid : 0
     * list : [{"amount":"string","decoction":"string","finaltotal":0,"id":0,"islack":0,"kindid":0,"kindname":"string","limitmax":0,"limitmin":0,"max":0,"medicineid":0,"mls":0,"otherids":"string","pharmacyid":0,"publicpy":"string","publictitle":"string","py":"string","title":"string","unit":"string"}]
     * pharmacyid : 0
     */

    private int kindid;
    private int pharmacyid;
    private List<MedicineBean> list;

    public int getKindid() {
        return kindid;
    }

    public void setKindid(int kindid) {
        this.kindid = kindid;
    }

    public int getPharmacyid() {
        return pharmacyid;
    }

    public void setPharmacyid(int pharmacyid) {
        this.pharmacyid = pharmacyid;
    }

    public List<MedicineBean> getList() {
        return list;
    }

    public void setList(List<MedicineBean> list) {
        this.list = list;
    }
}
