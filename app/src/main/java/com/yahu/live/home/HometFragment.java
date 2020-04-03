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
import com.yahu.live.main.videolist.ui.TCVideoListFragment;
import com.yahu.live.scan.QrScanAty;

import java.util.ArrayList;
import java.util.List;


/**
 *  Module:   TCVideoListFragment
 *
 *  Function: 直播列表页面，展示当前直播、回放
 *
 */
public class HometFragment extends Fragment implements View.OnClickListener {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private MyAdapter pagerAdapter;
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private String[] titles = new String[]{" 推荐 "," 热门 "," 推荐 "," 热门 "," 推荐 "," 热门 "};



    public HometFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        tabLayout = (TabLayout) view.findViewById(R.id.tablayout);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        view.findViewById(R.id.tv_search).setOnClickListener(this);
        view.findViewById(R.id.saoyisao).setOnClickListener(this);
        init();
        return view;
    }

    private void init() {

        for(int i=0;i<titles.length;i++){
            fragments.add(new HomeRecommendFragment());
            tabLayout.addTab(tabLayout.newTab());
        }
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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_search:
//                startActivity(new Intent(getApplicationContext(), NewSearchActivity.class));
                break;
            case R.id.saoyisao: //扫一扫
                Intent intent05 = new Intent(getActivity(), QrScanAty.class);
                intent05.putExtra("url", TCGlobalConfig.WEB_URL);
                startActivityForResult(intent05, 25);
                break;

        }
    }

}