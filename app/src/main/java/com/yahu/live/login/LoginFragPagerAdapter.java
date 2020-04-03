package com.yahu.live.login;


import androidx.annotation.NonNull;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class LoginFragPagerAdapter extends FragmentStatePagerAdapter {
    List<Fragment> fragmentList = new ArrayList<>();
    private String[] titles = {"登录", "注册"};
    private LoginFragment login;
    private RegisterFragment registerFragment;

    public LoginFragPagerAdapter(@NonNull FragmentManager fm) {

        super(fm);
    }

    {
        login = new LoginFragment();
        registerFragment = new RegisterFragment();
        fragmentList.add(login);
        fragmentList.add(registerFragment);
    }



    public void init(TabLayout tablayout, ViewPager viewpager) {
        if (tablayout == null) {
            return;
        }
        tablayout.removeAllTabs();
        for (int i = 0;i<titles.length;i++) {
            tablayout.addTab(tablayout.newTab().setText(titles[i]));
        }
        viewpager.setAdapter(this);
        viewpager.setOffscreenPageLimit(2);
        viewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));
        tablayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewpager));
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    public void setYaoCode(String phone){
//        registerFragment.setYaoCode(phone);
    }
}
