package com.yahu.live.home;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.yahu.live.R;
import com.yahu.live.adapter.FragmentLiveAttentionAdapter;
import com.yahu.live.adapter.FragmentVideoAttentionAdapter;
import com.yahu.live.base.NoBindFragment;
import com.yahu.live.base.SimpleDividerDecoration;
import com.yahu.live.main.videolist.utils.TCVideoInfo;
import com.yahu.live.refresh.CoolSwipeRefreshLayout;
import com.yahu.live.utils.Util;

import java.util.ArrayList;
import java.util.List;


/**
 * 直播关注列表
 */

public class VideoAttentionFragment extends NoBindFragment {
    private int mImageViewArray[] = {R.mipmap.banner, R.mipmap.banner, R.mipmap.banner, R.mipmap.banner, R.mipmap.banner};

    private RecyclerView recyclerView;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    private FragmentVideoAttentionAdapter adapter;
    private CoolSwipeRefreshLayout swipeRefreshLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getRootView() == null) {
            setRootView(R.layout.fragment_video_attention);
            initViews();
            initData();

        }
        return getRootView();
    }

    @Override
    public void initViews() {
        super.initViews();
        swipeRefreshLayout = initSwipeRefreshLayout();
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
//        layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView = (RecyclerView) findViewById(R.id.rcv);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.addItemDecoration(new SimpleDividerDecoration(getContext(), Util.dip2px(2)));

//        recyclerView.addItemDecoration(new SimpleDividerDecoration(getContext(), Utils.dip2px(8), R.color.home_recommend_divider));
//        SimpleDividerDecorationH decoration = new SimpleDividerDecorationH(getContext(), Util.dip2px(8));
//        recyclerView.addItemDecoration(decoration);
    }

    @Override
    public void initData() {
        super.initData();
        List list = new ArrayList();
        for (int i= 0;i<10;i++){
            TCVideoInfo tcVideoInfo = new TCVideoInfo();
            list.add(tcVideoInfo);
        }
        fillData(list);
    }

    @Override
    public void requestData() {
        super.requestData();

    }

    public View inflate(int id) {
        if (getContext() == null)
            return null;
        return View.inflate(getContext(), id, null);
    }

    private void fillData(List<TCVideoInfo> list) {
        if (adapter == null) {
            adapter = new FragmentVideoAttentionAdapter(list, getContext());
            recyclerView.setAdapter(adapter);
            configQuickAdapter(adapter, recyclerView);
        } else {
            adapter.refresh(list, !isFirstPage());
        }

        if (list.size() < 35) {
            adapter.loadMoreEnd(true);
        } else {
            adapter.loadMoreComplete();
        }
        stopRefreshing(swipeRefreshLayout);
    }



    private boolean isActivityDestroyed() {
        if (getActivity() == null)
            return true;
        return getActivity().isDestroyed();
    }
    @Override
    public void onResume() {
        super.onResume();
    }
}
