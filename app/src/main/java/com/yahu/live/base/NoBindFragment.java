package com.yahu.live.base;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.loadmore.LoadMoreView;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.qcloud.core.http.HttpResult;
import com.wang.avi.AVLoadingIndicatorView;
import com.yahu.live.R;
import com.yahu.live.TCGlobalConfig;
import com.yahu.live.dialog.MyProgressDialog;
import com.yahu.live.event.MyBusEvent;
import com.yahu.live.refresh.CoolSwipeRefreshLayout;
import com.yahu.live.utils.NetUtils;
import com.yahu.live.utils.ToastUtil;
import com.yahu.live.utils.Util;
import com.yahu.live.utils.UtilImage;
import com.yahu.live.utils.Utils;
import com.yahu.live.view.BaseView;
import com.yahu.live.view.Loading;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import q.rorbin.badgeview.QBadgeView;


/**
 * Created by Dun on 2018/11/28.
 */

public class NoBindFragment extends Fragment implements View.OnClickListener, BaseView, BaseQuickAdapter.OnItemClickListener, BaseQuickAdapter.RequestLoadMoreListener, BaseQuickAdapter.OnItemChildClickListener {
    private View rootView;

    public int page = 1;

    public View getRootView() {
        return rootView;
    }

    public void setRootView(View rootView) {
        this.rootView = rootView;
    }

    public void setRootView(int resId) {
        setRootView(inflate(resId));
    }

//    private IWXAPI api;
    private MyProgressDialog myProgressDialog;

    public void initViews() {
    }

    public void initData() {
    }

    public void onClick(View view) {

    }

    public void showProgressDialog() {
        if (myProgressDialog == null) {
            myProgressDialog = new MyProgressDialog(getContext());
        }
        if (!myProgressDialog.isShowing())
            myProgressDialog.show();
    }

    public void dismissProgressDialog() {
        if (myProgressDialog != null && myProgressDialog.isShowing()) {
            myProgressDialog.dismiss();
        }
    }

    @Override
    public void onResponse(int what, HttpResult result) {
        Util.hiddenSoftBorad(getContext());

        if (!NetUtils.isNetworkAvailable()) {
            ToastUtil.showToast("请检查您的网络");
        }
    }

    public void requestData() {
    }

    public View inflate(int id) {
        if (getContext() == null)
            return null;
        return View.inflate(getContext(), id, null);
    }

    public View findViewById(int id) {
        if (rootView == null)
            return null;
        return rootView.findViewById(id);
    }

    public RecyclerView initRecyclerView(RecyclerView.LayoutManager layoutManager, int dividerHeight) {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rcv);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new SimpleDividerDecoration(getContext(), dividerHeight));
        return recyclerView;
    }

    public RecyclerView initRecyclerView(RecyclerView.LayoutManager layoutManager, int dividerHeight, int color) {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rcv);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new SimpleDividerDecoration(getContext(), dividerHeight, color));
        return recyclerView;
    }

    public RecyclerView initRecyclerView(RecyclerView.LayoutManager layoutManager, RecyclerView.ItemDecoration itemDecoration) {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rcv);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(itemDecoration);
        return recyclerView;
    }


    public CoolSwipeRefreshLayout initSwipeRefreshLayout() {
        CoolSwipeRefreshLayout swp = (CoolSwipeRefreshLayout) findViewById(R.id.swp);
        swp.setColorSchemeColors(getResources().getColor(R.color.primary));
        swp.setRefreshStyle(CoolSwipeRefreshLayout.STYLE_SMARTISAN);
        swp.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                swp.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                requestData();
            }
        });
        swp.setOnRefreshListener(new CoolSwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swp.setRefreshing(true);
                page = TCGlobalConfig.FIRST_PAGE;
                requestData();
            }
        });
        return swp;
    }

    public CoolSwipeRefreshLayout initSwipeRefreshLayout(boolean refresh) {
        CoolSwipeRefreshLayout swp = (CoolSwipeRefreshLayout) findViewById(R.id.swp);
        swp.setColorSchemeColors(getResources().getColor(R.color.primary));
        swp.setRefreshStyle(CoolSwipeRefreshLayout.STYLE_SMARTISAN);
        swp.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                swp.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                requestData();
            }
        });
        swp.setOnRefreshListener(new CoolSwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swp.setRefreshing(true);
                page = TCGlobalConfig.FIRST_PAGE;
                requestData();
            }
        });
        return swp;
    }

    public void configQuickAdapter(final BaseRecyclerAdapter adapter, RecyclerView recyclerView) {
        adapter.setOnItemClickListener(this);
        adapter.setOnLoadMoreListener(this, recyclerView);
        adapter.setLoadMoreView(new MyLoadMoreView());
        recyclerView.post(new Runnable() {
            @Override
            public void run() {
                adapter.setEmptyView(R.layout.layout_empty);
            }
        });
    }

    public void configQuickAdapter(final BaseRecyclerAdapter adapter, RecyclerView recyclerView, int emptyLayout) {
        adapter.setOnItemClickListener(this);
        adapter.setOnLoadMoreListener(this, recyclerView);
        adapter.setLoadMoreView(new MyLoadMoreView());
        recyclerView.post(new Runnable() {
            @Override
            public void run() {
                adapter.setEmptyView(emptyLayout);
            }
        });
    }

    public void configQuickAdapter(final BaseRecyclerAdapter adapter, RecyclerView recyclerView, int emptyLayout, LoadMoreView loadMoreView) {
        adapter.setOnItemClickListener(this);
        adapter.setOnLoadMoreListener(this, recyclerView);
        adapter.setLoadMoreView(loadMoreView);
        recyclerView.post(new Runnable() {
            @Override
            public void run() {
                adapter.setEmptyView(emptyLayout);
            }
        });
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void onLoadMoreRequested() {
        page++;
        requestData();
    }

    public boolean isFirstPage() {
        return this.page == TCGlobalConfig.FIRST_PAGE;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        api = WXAPIFactory.createWXAPI(getContext(), FCConsts.WX_KEY);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();


    }

    @Override
    public void onStart() {
        super.onStart();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void onEventMainThread(BaseVO baseVO) {
    }


    public void stopRefreshing(CoolSwipeRefreshLayout swipeRefreshLayout) {
        swipeRefreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(false);
            }
        }, 200);

        if (findViewById(R.id.swp_loading) != null && findViewById(R.id.swp_loading) instanceof AVLoadingIndicatorView) {
            AVLoadingIndicatorView loadingView = (AVLoadingIndicatorView) findViewById(R.id.swp_loading);
            loadingView.hide();
        }
    }




    private QBadgeView badgeView = null;

    public void setBadgeView(QBadgeView badgeView) {
        this.badgeView = badgeView;
    }


    @Subscribe
    public void onBusEvent(MyBusEvent event) {
        switch (event.event) {
            case MyBusEvent.NETWORK_ENABLE:
                page = TCGlobalConfig.FIRST_PAGE;
                requestData();
                break;
        }
    }

//    /**
//     * 分享视频
//     *
//     * @param key
//     * @param shareUrl
//     * @return
//     */
//    public boolean shareVideoToWeChat(int key, String shareUrl) {
//        WXVideoObject video = new WXVideoObject();
//        video.videoUrl = shareUrl;
//
//        WXMediaMessage msg = new WXMediaMessage(video);
//
//        msg.mediaTagName = "mediaTagName";
//        msg.messageAction = "MESSAGE_ACTION_SNS_VIDEO#gameseq=1491995805&GameSvrEntity=87929&RelaySvrEntity=2668626528&playersnum=10";
//
//        msg.title = "玩转翡翠直播购，买翡翠也上瘾了，上瘾了";
//        msg.description = "玩转翡翠源头直播，天天看美货，源头现场直播";
//        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
//        Bitmap thumbBmp = Bitmap.createScaledBitmap(bmp, 150, 150, true);
//        bmp.recycle();
//        msg.thumbData = UtilImage.bmpToByteArray(thumbBmp, true);
//
//        SendMessageToWX.Req req = new SendMessageToWX.Req();
//        req.transaction = "video" + System.currentTimeMillis();
//        req.message = msg;
//        req.scene = key == FCBaseActivity.WECHAT_FRIENDS ? SendMessageToWX.Req.WXSceneSession : SendMessageToWX.Req.WXSceneTimeline;
//        return api.sendReq(req);
//    }

//    public boolean shareUrlToWechat(int key, String shareUrl, String title, String message) {
//        StringBuffer url = new StringBuffer();
//        url.append(shareUrl);
//        WXWebpageObject webpage = new WXWebpageObject();
//        webpage.webpageUrl = url.toString();
//        WXMediaMessage msg = new WXMediaMessage(webpage);
//
//        msg.title = title;
//        msg.description = message;
//        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
//        msg.setThumbImage(bmp);
//
//        SendMessageToWX.Req req = new SendMessageToWX.Req();
//        req.transaction = "webpage" + System.currentTimeMillis();
//        req.message = msg;
//        req.scene = (key == FCBaseActivity.WECHAT_FRIENDS) ? SendMessageToWX.Req.WXSceneSession : SendMessageToWX.Req.WXSceneTimeline;
//        return api.sendReq(req);
//    }


}
