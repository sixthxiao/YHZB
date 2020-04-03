package com.yahu.live.home;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

/**
 * ViewPager的Fragment适配器
 * Created by jp04 on 2017/3/17.
 */

public class CommonFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    private String[] titleArray;
    private List<String> titleList;

    public CommonFragmentPagerAdapter(FragmentManager fm, List<Fragment> fragments, String[] titleArray) {
        super(fm);
        this.fragments = fragments;
        this.titleArray = titleArray;
        this.notifyDataSetChanged();
    }

    public CommonFragmentPagerAdapter(FragmentManager fm, List<Fragment> fragments, List<String> titleList) {
        super(fm);
        this.fragments = fragments;
        this.titleList = titleList;
        this.notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
//        return titleList != null ? titleList.get(position) : titleArray[position];
        return "";
    }

    public void updateTitle(int index, String title) {
        if(titleArray != null) {
            titleArray[index] = title;
        } else {
            titleList.set(index, title);
        }
        this.notifyDataSetChanged();
    }

    public void refresh(List<Fragment> fragments, List<String> titles) {
        this.fragments = fragments;
        this.titleList = titles;
        this.notifyDataSetChanged();
    }

    public void refresh(boolean append, List<Fragment> fragments, List<String> titles) {
        if(!append){
            refresh(fragments, titles);
        } else {
            fragments.addAll(fragments);
            titles.addAll(titles);
            this.notifyDataSetChanged();
        }
    }

}
