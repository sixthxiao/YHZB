package com.hepeng.baselibrary.bean;

import com.contrarywind.interfaces.IPickerViewData;

public class AreaBean implements IPickerViewData {
    private int id;
    private String title;

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

    @Override
    public String getPickerViewText() {
        return this.title;
    }
}
