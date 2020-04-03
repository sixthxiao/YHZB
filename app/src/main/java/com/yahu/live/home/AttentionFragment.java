package com.yahu.live.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.yahu.live.R;
import com.yahu.live.TCGlobalConfig;
import com.yahu.live.scan.QrScanAty;
import com.yahu.live.view.NoScrollViewPager;

import java.util.ArrayList;


/**
 * 关注列表
 */
public class AttentionFragment extends Fragment {
    private TabLayout tabLayout;
    private NoScrollViewPager viewPager;
    private MyAdapter pagerAdapter;
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private String[] titles = new String[]{"  直播关注  ","  视频关注  ",};

    public AttentionFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_attention, container, false);

        tabLayout = (TabLayout) view.findViewById(R.id.tablayout);
        viewPager = (NoScrollViewPager) view.findViewById(R.id.viewpager);
        init();
        return view;
    }

    private void init() {
        fragments.add(new LiveAttentionFragment());
        tabLayout.addTab(tabLayout.newTab());
        fragments.add(new VideoAttentionFragment());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.setupWithViewPager(viewPager,false);
        pagerAdapter = new MyAdapter(getChildFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOffscreenPageLimit(2);
        for(int i=0;i<titles.length;i++){
            tabLayout.getTabAt(i).setText(titles[i]);
        }
    }


    public class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

//        @Nullable
//        @Override
//        public CharSequence getPageTitle(int position) {
//            return strings[position];
//        }
    }


}