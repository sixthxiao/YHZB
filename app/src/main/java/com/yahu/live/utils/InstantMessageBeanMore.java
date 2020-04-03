package com.yahu.live.utils;

import android.text.TextUtils;

import com.yahu.live.R;

import java.util.HashMap;

/**
 * Created by Dun on 2019/2/23.
 */

public class InstantMessageBeanMore {

    private static HashMap<String, Integer> vipMap = new HashMap<>();
    public String gradeTitle = "";
    public int gradeIcon = -1;
    public String userName = "";

    static {
        String[] grades = Utils.getStringArray(R.array.grade_name_list);
        String[] icons = Utils.getStringArray(R.array.grade_icon_list_gif);
        for (int i = 0; i < grades.length; i++) {
            vipMap.put(grades[i].toLowerCase(), Utils.getDrawableResourceIdByName(icons[i]));
        }
    }


    public InstantMessageBeanMore(String title, String name) {

        gradeIcon = vipMap.get(title) == null ? -1 : vipMap.get(title);
        userName = name;
    }

    public boolean hasGrade() {
        return this.gradeIcon != -1;
    }

    public static Integer getGradeIcon(String grade) {
        return vipMap.get(grade) == null ? -1 : vipMap.get(grade);
    }

}
