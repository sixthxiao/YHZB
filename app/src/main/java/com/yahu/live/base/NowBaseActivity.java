package com.yahu.live.base;

import android.animation.AnimatorSet;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
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
import com.yahu.live.view.BaseView;

import org.greenrobot.eventbus.Subscribe;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import butterknife.ButterKnife;


/**
 * Created by Dun on 2018/11/28.
 */

public class NowBaseActivity extends Activity implements BaseView, CoolSwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.OnItemClickListener, BaseQuickAdapter.RequestLoadMoreListener {
    private MyProgressDialog myProgressDialog;

    private int requestCode;

    public int page = TCGlobalConfig.FIRST_PAGE;

    public void initViews() {
        ButterKnife.bind(this);
    }

    public void initData() {
    }


    public void setMyTitle(String text) {
        TextView tvTitle = findViewById(R.id.tv_title);
        if (tvTitle != null)
            tvTitle.setText(text);
        setTitle(text);
    }


    public void showProgressDialog() {
        Util.hiddenSoftBorad(this);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (myProgressDialog == null) {
                    myProgressDialog = new MyProgressDialog(NowBaseActivity.this);
                }
                if (!myProgressDialog.isShowing())
                    myProgressDialog.show();
            }
        });

    }

    public void dismissProgressDialog() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (myProgressDialog != null && myProgressDialog.isShowing()) {
                    myProgressDialog.dismiss();
                }
            }
        });

    }

    @Override
    public void onResponse(int what, HttpResult result) {
        Util.hiddenSoftBorad(this);

        if (!NetUtils.isNetworkAvailable()) {
            ToastUtil.showToast("请检查您的网络");
        }
    }



    public CoolSwipeRefreshLayout initSwipeRefreshLayout() {
        CoolSwipeRefreshLayout swp = (CoolSwipeRefreshLayout) findViewById(R.id.swp);
        swp.setColorSchemeColors(getResources().getColor(R.color.primary));
        swp.setRefreshStyle(CoolSwipeRefreshLayout.STYLE_SMARTISAN);
        swp.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                swp.getViewTreeObserver().removeOnGlobalLayoutListener(this);
//                swp.setRefreshing(true);
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


    public CoolSwipeRefreshLayout initSwipeRefreshLayoutWithoutRefresh() {
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

    public RecyclerView initRecyclerView(RecyclerView.LayoutManager layoutManager, int dividerHeight) {
        RecyclerView recyclerView = findViewById(R.id.rcv);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new SimpleDividerDecoration(this, dividerHeight));
        return recyclerView;
    }

    public RecyclerView initRecyclerView(RecyclerView.LayoutManager layoutManager, int dividerHeight, int color) {
        RecyclerView recyclerView = findViewById(R.id.rcv);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new SimpleDividerDecoration(this, dividerHeight, color));
        return recyclerView;
    }

    public RecyclerView initRecyclerView(RecyclerView.LayoutManager layoutManager, RecyclerView.ItemDecoration itemDecoration) {
        RecyclerView recyclerView = findViewById(R.id.rcv);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(itemDecoration);
        return recyclerView;
    }

    public void configQuickAdapter(final BaseRecyclerAdapter adapter, RecyclerView recyclerView) {
        adapter.setOnItemClickListener(this);
        adapter.setLoadMoreView(new MyLoadMoreView());
        adapter.setOnLoadMoreListener(this, recyclerView);

        recyclerView.post(new Runnable() {
            @Override
            public void run() {
                adapter.setEmptyView(R.layout.layout_empty);
            }
        });
    }


    public void configQuickAdapter(final BaseRecyclerAdapter adapter, RecyclerView recyclerView, final int emptyLayout) {
        adapter.setOnItemClickListener(this);
        adapter.setLoadMoreView(new MyLoadMoreView());
        adapter.setOnLoadMoreListener(this, recyclerView);

        recyclerView.post(new Runnable() {
            @Override
            public void run() {
                adapter.setEmptyView(emptyLayout);
            }
        });
    }

    @Override
    public void onRefresh() {
        page = TCGlobalConfig.FIRST_PAGE;
        requestData();
    }

    public void requestData() {
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void onLoadMoreRequested() {
        page++;
        requestData();
    }


    public boolean isFirstPage() {
        return page == TCGlobalConfig.FIRST_PAGE;
    }

    public void stopRefreshing(CoolSwipeRefreshLayout swipeRefreshLayout) {
        swipeRefreshLayout.setRefreshing(false);

        if (findViewById(R.id.swp_loading) != null && findViewById(R.id.swp_loading) instanceof AVLoadingIndicatorView) {
            AVLoadingIndicatorView loadingView = (AVLoadingIndicatorView) findViewById(R.id.swp_loading);
            loadingView.hide();
        }
    }

    public static AnimatorSet getLoveAnim(ImageView view) {
        android.animation.ObjectAnimator animatorA = android.animation.ObjectAnimator
                .ofFloat(view, "alpha", 0f, 1f).setDuration(300);

        android.animation.ObjectAnimator animatorB = android.animation.ObjectAnimator
                .ofFloat(view, "scaleX", 0f, 1f).setDuration(300);

        android.animation.ObjectAnimator animatorC = android.animation.ObjectAnimator
                .ofFloat(view, "scaleY", 0f, 1f).setDuration(300);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animatorA, animatorB, animatorC);
        return animatorSet;
    }

    public View inflate(int res) {
        return View.inflate(this, res, null);
    }


    public static void releaseDialog(Dialog dialog) {
        if (dialog != null) {
            dialog.dismiss();
            dialog = null;
        }
    }







    public Context getContext() {
        return this;
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

    /**
     * 点击空白区域隐藏键盘.
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {  //把操作放在用户点击的时候
            View v = getCurrentFocus();      //得到当前页面的焦点,ps:有输入框的页面焦点一般会被输入框占据
            if (isShouldHideKeyboard(v, ev)) { //判断用户点击的是否是输入框以外的区域
                hideKeyboard(v.getWindowToken());   //收起键盘
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    /**
     * 根据EditText所在坐标和用户点击的坐标相对比，来判断是否隐藏键盘，因为当用户点击EditText时则不能隐藏
     *
     * @param v
     * @param event
     * @return
     */
    private boolean isShouldHideKeyboard(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {  //判断得到的焦点控件是否包含EditText
            int[] l = {0, 0};
            v.getLocationInWindow(l);
            int left = l[0],    //得到输入框在屏幕中上下左右的位置
                    top = l[1],
                    bottom = top + v.getHeight(),
                    right = left + v.getWidth();
            if (event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom) {
                // 点击位置如果是EditText的区域，忽略它，不收起键盘。
                return false;
            } else {
                return true;
            }
        }
        // 如果焦点不是EditText则忽略
        return false;
    }

    /**
     * 获取InputMethodManager，隐藏软键盘
     *
     * @param token
     */
    private void hideKeyboard(IBinder token) {
        if (token != null) {
            InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            im.hideSoftInputFromWindow(token, InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

}
