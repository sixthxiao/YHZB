package com.yahu.live.home;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.yahu.live.R;
import com.yahu.live.adapter.HomeRecommendGoodsAdapter;
import com.yahu.live.base.MyPageChangeListener;
import com.yahu.live.base.NoBindFragment;
import com.yahu.live.base.SimpleDividerDecoration;
import com.yahu.live.base.SimpleDividerDecorationH;
import com.yahu.live.main.videolist.utils.TCVideoInfo;
import com.yahu.live.refresh.CoolSwipeRefreshLayout;
import com.yahu.live.utils.ImageUtils;
import com.yahu.live.utils.Util;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import java.util.ArrayList;
import java.util.List;

import static com.tencent.liteav.basic.log.TXCLog.init;


/**
 * Banner管理界面
 * 首页 推荐
 * Created by Dun on 2019/1/8.
 */

public class HomeRecommendFragment extends NoBindFragment {
    private int mImageViewArray[] = {R.mipmap.banner, R.mipmap.banner, R.mipmap.banner, R.mipmap.banner, R.mipmap.banner};

    private MZBannerView mzBanner;
    private LinearLayout llIndicator;
    private View headerView;
    private RecyclerView recyclerView;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    private HomeRecommendGoodsAdapter adapter;
    private CoolSwipeRefreshLayout swipeRefreshLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getRootView() == null) {
            setRootView(R.layout.fragment_home_tui);
            initViews();
            initData();

        }
        return getRootView();
    }

    @Override
    public void initViews() {
        super.initViews();
        headerView = inflate(R.layout.header_home_recommend);
        swipeRefreshLayout = initSwipeRefreshLayout();
        mzBanner = (MZBannerView) headerView.findViewById(R.id.banner);
        llIndicator = headerView.findViewById(R.id.ll_indicator);
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
//        layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView = (RecyclerView) findViewById(R.id.rcv);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.addItemDecoration(new SimpleDividerDecoration(getContext(), Util.dip2px(10)));

//        recyclerView.addItemDecoration(new SimpleDividerDecoration(getContext(), Utils.dip2px(8), R.color.home_recommend_divider));
//        SimpleDividerDecorationH decoration = new SimpleDividerDecorationH(getContext(), Util.dip2px(8));
//        recyclerView.addItemDecoration(decoration);
    }

    @Override
    public void initData() {
        super.initData();
        fillActivity();
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
            adapter = new HomeRecommendGoodsAdapter(list, getContext());
            recyclerView.setAdapter(adapter);

            adapter.addHeaderView(headerView);
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

    /**
     * banner初始化
     */
    private  void  fillActivity(){
        if (isActivityDestroyed())
            return;

        ViewGroup.LayoutParams bannerParams = mzBanner.getLayoutParams();
        bannerParams.width = Util.getScreenWidth();
        bannerParams.height = Util.getScreenWidth() * 7 / 16;
        mzBanner.setLayoutParams(bannerParams);
        mzBanner.setIndicatorVisible(false);

        llIndicator.removeAllViews();

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(Util.dip2px(6), Util.dip2px(6));
        params.rightMargin = Util.dip2px(10);
        for (int i = 0; i < mImageViewArray.length; i++) {
            View view = new View(getContext());
            view.setBackgroundResource(R.drawable.sel_home_banner_indicator);
            view.setSelected(i == 0);
            llIndicator.addView(view, params);
        }

        //模拟banner数据
        List<String> images = new ArrayList<>();
        for (int i = 0;i<mImageViewArray.length;i++){
            images.add("https://about.canva.com/wp-content/uploads/sites/3/2019/04/201904%E8%8A%82%E6%97%A5%E7%83%AD%E7%82%B9banner%E8%AE%BE%E8%AE%A1%E6%A8%A1%E6%9D%BF1.jpg");
        }
        // 设置数据
        mzBanner.setPages(images, new MZHolderCreator<BannerViewHolder>() {
            @Override
            public BannerViewHolder createViewHolder() {
                return new BannerViewHolder();
            }
        });

        mzBanner.addPageChangeListener(new MyPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                for (int i = 0; i < llIndicator.getChildCount(); i++) {
                    llIndicator.getChildAt(i).setSelected(i == position);
                }
            }
        });
    }

    public class BannerViewHolder implements MZViewHolder<String> {
        private ImageView mImageView;

        @Override
        public View createView(Context context) {
            // 返回页面布局
            View view = LayoutInflater.from(context).inflate(R.layout.layout_home_recommend_banner, null);
            mImageView = (ImageView) view.findViewById(R.id.banner_image);
            return view;
        }

        @Override
        public void onBind(Context context, int position, String data) {
            // 数据绑定
            ImageUtils.loadImage(context, data, mImageView);

//            mImageView.setTag(R.id.exo_position, position);
//            广告添加点击事件
//            mImageView.setOnClickListener(HomeRecommendFragment.this);
        }
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
