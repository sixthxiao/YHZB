package com.yahu.live.home;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.yahu.live.R;
import com.yahu.live.adapter.FragmentLiveAttentionAdapter;
import com.yahu.live.adapter.LiveGiftAdapter;
import com.yahu.live.base.NoBindFragment;
import com.yahu.live.base.SimpleDividerDecoration;
import com.yahu.live.bean.GiftBean;
import com.yahu.live.main.videolist.utils.TCVideoInfo;
import com.yahu.live.refresh.CoolSwipeRefreshLayout;
import com.yahu.live.utils.Util;

import java.util.ArrayList;
import java.util.List;


/**
 * 礼物列表
 */

public class LiveGiftFragment extends NoBindFragment {

    private int images[] = {R.mipmap.gift_gaobai, R.mipmap.gift_aixin,
            R.mipmap.gift_feichuan, R.mipmap.gift_xiaoxing, R.mipmap.gift_zan,
            R.mipmap.gift_btang, R.mipmap.gift_chaopao, R.mipmap.gift_tq};
    private GridView mGridView;
    private LiveGiftAdapter liveGiftAdapter;
    private String[] titles = new String[]{"告白气球", "爱心", "飞船", "小星星",
            "赞", "棒棒糖", "超跑", "甜甜圈"};
    private String[] values = new String[]{"5200虎币", "10虎币", "26600虎币", "免费",
            "500虎币", "1000虎币", "13140虎币", "2000虎币"};


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getRootView() == null) {
            setRootView(R.layout.fragment_live_gift);
            initViews();
            initData();

        }
        return getRootView();
    }

    @Override
    public void initViews() {
        super.initViews();
        mGridView = (GridView) this.findViewById(R.id.grid_view);
        List<GiftBean> giftBeanArrayList = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            GiftBean giftBean = new GiftBean();
            giftBean.setImage(images[i]);
            giftBean.setTitle(titles[i]);
            giftBean.setValue(values[i]);
            giftBeanArrayList.add(giftBean);
        }
        liveGiftAdapter = new LiveGiftAdapter(getContext(), giftBeanArrayList);
        mGridView.setAdapter(liveGiftAdapter);
    }

    @Override
    public void initData() {
        super.initData();

    }

    @Override
    public void requestData() {
        super.requestData();

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
