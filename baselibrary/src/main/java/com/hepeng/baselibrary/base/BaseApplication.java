package com.hepeng.baselibrary.base;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.multidex.MultiDex;

import com.hepeng.life.baselibrary.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshInitializer;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by Administrator on 2018/4/8.
 */

public class BaseApplication extends Application {
    public static Context appContext;
    private static BaseApplication instance;


    public static BaseApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appContext=getApplicationContext();
        instance = this;
//        initLeakCanary();
        initRefreshLayout();
    }

    //内存泄漏检测
    private void initLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }

    private static void initRefreshLayout() {//使用static代码段可以防止内存泄漏
        //设置全局默认配置（优先级最低，会被其他设置覆盖）
        SmartRefreshLayout.setDefaultRefreshInitializer(new DefaultRefreshInitializer() {
            @Override
            public void initialize(@NonNull Context context, @NonNull RefreshLayout layout) {
                //开始设置全局的基本参数（可以被下面的DefaultRefreshHeaderCreator覆盖）
                layout.setReboundDuration(800);
                layout.setHeaderHeight(70);
                layout.setFooterHeight(50);
                layout.setEnableAutoLoadMore(true);//启用列表惯性滑动到底部时自动加载更多
                layout.setEnableHeaderTranslationContent(true);//是否下拉Header的时候向下平移列表或者内容
                layout.setEnableFooterTranslationContent(true);//是否上拉Footer的时候向上平移列表或者内容
                layout.setEnableLoadMoreWhenContentNotFull(true);//是否在列表不满一页时候开启上拉加载功能
                layout.setDisableContentWhenRefresh(false);//是否在刷新的时候禁止列表的操作
                layout.setDisableContentWhenLoading(false);//是否在加载的时候禁止列表的操作
                layout.setPrimaryColorsId(R.color.color_f3f3f3, android.R.color.black);
            }
        });

        //全局设置默认的 Header
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                return new ClassicsHeader(context);
            }
        });

        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                //指定为经典Footer，默认是 BallPulseFooter
                return new ClassicsFooter(context);
            }
        });
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
