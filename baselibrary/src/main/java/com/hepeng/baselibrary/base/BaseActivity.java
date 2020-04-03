package com.hepeng.baselibrary.base;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hepeng.baselibrary.customview.LoadingView;
import com.hepeng.baselibrary.networkstate.NetWorkStateReceiver;
import com.hepeng.baselibrary.utils.SPUtils;
import com.hepeng.baselibrary.utils.StatusBarUtil;
import com.hepeng.life.baselibrary.R;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder unbinder;
    protected Context context;
    public SPUtils spUtils;
    public LoadingView loading;

    protected ImageView back;
    protected TextView title;
    protected TextView right;
    protected RelativeLayout top_root_view;
    protected NetWorkStateReceiver netWorkStateReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//强制为竖屏
        // 设置全屏
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // 沉㓎式状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }
        //设置状态栏字体颜色为黑色
        StatusBarUtil.StatusBarLightMode(this, true);

        setContentView(setLayout());
        ActivityManager.getActivityManager().addActivity(this);

        unbinder = ButterKnife.bind(this);

        if (isBindEventBus()) {
            EventBus.getDefault().register(this);
        }
        context = this;
        spUtils = SPUtils.getInstance(context);
        loading = new LoadingView(context, R.style.customDialog, "加载中....");
        initView();
        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (netWorkStateReceiver == null) {
            netWorkStateReceiver = new NetWorkStateReceiver();
        }
        IntentFilter filter = new IntentFilter();
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(netWorkStateReceiver, filter);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        if (newConfig.fontScale != 1) {//非默认值
            getResources();
        }
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public Resources getResources() {
        Resources res = super.getResources();
        if (res.getConfiguration().fontScale != 1) {//非默认值
            Configuration newConfig = new Configuration();
            newConfig.setToDefaults();//设置默认
            res.updateConfiguration(newConfig, res.getDisplayMetrics());
        }
        return res;
    }

    protected abstract int setLayout();

    /**
     * 初始化组件
     */
    protected abstract void initView();

    /**
     * 加载数据
     */
    protected abstract void initData();


    //绑定EventBus
    protected abstract boolean isBindEventBus();

    protected void initTopbar(int titleStr, int textRight, int textRightColor, View.OnClickListener listener, boolean showLine) {
        top_root_view = (RelativeLayout) findViewById(R.id.top_root_view);
        back = (ImageView) findViewById(R.id.back);
        title = (TextView) findViewById(R.id.title);
        right = (TextView) findViewById(R.id.right);
        View line = findViewById(R.id.line);
        if (showLine) {
            line.setVisibility(View.VISIBLE);
        } else {
            line.setVisibility(View.GONE);
        }

        title.setText(getResources().getString(titleStr));

        if (listener != null) {
            right.setText(getResources().getString(textRight));
            right.setVisibility(View.VISIBLE);
            right.setOnClickListener(listener);
            if (textRightColor != 0) {
                right.setTextColor(getResources().getColor(textRightColor));
            }
        }
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    protected void setTitle(String text) {
        title.setText(text);
    }

    protected void setRightTxt(String text) {
        right.setText(text);
    }

    public View getEmptyLayout(int resource) {
        View emptyView = View.inflate(context, R.layout.empty_layout, null);
        ((ImageView) emptyView.findViewById(R.id.iv_empty)).setImageResource(resource);
        return emptyView;
    }

//    //点击软键盘以外的区域关闭软键盘
//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
//            View v = getCurrentFocus();
//            if (Util.isShouldHideInput(v, ev)) {
//                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
//                if (imm != null) {
//                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
//                }
//            }
//            return super.dispatchTouchEvent(ev);
//        }
//        // 必不可少，否则所有的组件都不会有TouchEvent了
//        if (getWindow().superDispatchTouchEvent(ev)) {
//            return true;
//        }
//        return onTouchEvent(ev);
//    }

    protected void loadingShow() {
        if (loading != null && !loading.isShowing()) {
            loading.show();
        }
    }

    protected void loadingShow(String txt) {
        if (loading != null && !loading.isShowing()) {
            loading.show(txt);
        }
    }

    protected void loadingDismiss() {
        if (loading != null && loading.isShowing()) {
            loading.dismiss();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
        loading.cancel();
        loading = null;
        if (isBindEventBus()) {
            EventBus.getDefault().unregister(this);
        }
        unregisterReceiver(netWorkStateReceiver);
        //  结束Activity&从栈中移除该Activity
        ActivityManager.getActivityManager().finishActivity(this);
    }

    /**
     * startActivity
     *
     * @param clazz
     */
    protected void readyGo(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    /**
     * startActivity with bundle
     *
     * @param clazz
     * @param bundle
     */
    protected void readyGo(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * startActivity then finish
     *
     * @param clazz
     */
    protected void readyGoThenKill(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
        finish();
    }

    /**
     * startActivity with bundle then finish
     *
     * @param clazz
     * @param bundle
     */
    protected void readyGoThenKill(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
        finish();
    }

    /**
     * startActivityForResult
     *
     * @param clazz
     * @param requestCode
     */
    protected void readyGoForResult(Class<?> clazz, int requestCode) {
        Intent intent = new Intent(this, clazz);
        startActivityForResult(intent, requestCode);
    }

    /**
     * startActivityForResult with bundle
     *
     * @param clazz
     * @param requestCode
     * @param bundle
     */
    protected void readyGoForResult(Class<?> clazz, int requestCode, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }
}
