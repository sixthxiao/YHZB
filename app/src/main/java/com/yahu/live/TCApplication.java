package com.yahu.live;

import android.content.Context;
import android.util.Log;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.smtt.sdk.QbSdk;
import com.yahu.liteav.demo.lvb.liveroom.MLVBLiveRoomImpl;
import com.yahu.live.bean.MixUserInfo;
import com.yahu.live.common.report.TCELKReportMgr;
import com.yahu.live.common.utils.TCConstants;
import com.yahu.live.login.TCUserMgr;
import com.yahu.live.pay.CodeMsg;
import com.yahu.live.pay.PayRequestInfo;
import com.yahu.live.retrofit.HttpInterceptor;
import com.yahu.live.utils.Utils;
import com.tencent.rtmp.TXLiveBase;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 测试提交修改
 * Module:   TCApplication
 *
 * Function: 初始化 App 所需要的组件
 *
 * 1. 【重要】初始化直播需要的 Licence : {@link TXLiveBase#setLicence(Context, String, String)}
 *
 * 2. 初始化 App 用户逻辑管理类。
 *
 * 3. 初始化 bugly 组件上报 crash。
 *
 * 4. 初始化友盟分享组件，分享内容到 QQ 或 微信。
 *
 * 5. 初始化小直播ELK上报数据系统，此系统用于 Demo 收集使用数据；您可以不关注相关代码。
 */
public class TCApplication extends MultiDexApplication {

    /**
     * bugly 组件的 AppId
     *
     * bugly sdk 系腾讯提供用于 APP Crash 收集和分析的组件。
     */
    public static final String BUGLY_APPID = "1400012894";

    private static final String TAG = "TCApplication";

    private static TCApplication instance;

    private static Retrofit retrofit;

    public static Gson gson;

    private static MixUserInfo userInfo = new MixUserInfo();

    public static PayRequestInfo payRequestInfo;
    private static CodeMsg payResult;
    private int shareResult = 1000;

    public static void setPayResult(CodeMsg payResult) {
        TCApplication.payResult = payResult;
    }

    public static CodeMsg getPayResult() {
        return payResult;
    }

    static {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                layout.setPrimaryColorsId(R.color.colorPrimary, android.R.color.white);//全局设置主题颜色
                MaterialHeader header = new MaterialHeader(context);
                header.setColorSchemeResources(R.color.colorPrimary);
                return header;
            }
        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                //指定为经典Footer，默认是 BallPulseFooter
                return new ClassicsFooter(context).setDrawableSize(20);
            }
        });
        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();
    }

    @Override
    protected void attachBaseContext(Context base) {
        MultiDex.install(base);
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        // 必须：初始化 LiteAVSDK Licence。 用于直播推流鉴权。
        TXLiveBase.getInstance().setLicence(this, TCGlobalConfig.LICENCE_URL, TCGlobalConfig.LICENCE_KEY);

        // 必须：初始化 MLVB 组件
        MLVBLiveRoomImpl.sharedInstance(this);

        // 必须：初始化全局的 用户信息管理类，记录个人信息。
        TCUserMgr.getInstance().initContext(getApplicationContext());

        // 可选：初始化 bugly crash上报系统。
        initBuglyCrashReportSDK();

        // 可选：初始化小直播上报组件
        initXZBAppELKReport();
        //初始化工具类
        Utils.init(this);

        initX5();
    }

    private void initX5() {
        //x5內核初始化回调
        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {

            @Override
            public void onViewInitFinished(boolean arg0) {
                // TODO Auto-generated method stub
                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
                Log.d("app", " onViewInitFinished is " + arg0);
            }

            @Override
            public void onCoreInitFinished() {
                // TODO Auto-generated method stub
            }
        };
        //x5内核初始化接口
        QbSdk.initX5Environment(getApplicationContext(), cb);
    }

    public static TCApplication getInstance() {
        return instance;
    }

    public static MixUserInfo getUserInfo() {
        return userInfo;
    }

    public int getShareResult() {
        return shareResult;
    }

    public synchronized void setShareResult(int shareResult) {
        this.shareResult = shareResult;
    }


    public static void setUserInfo(MixUserInfo userInfo) {
        TCApplication.userInfo = userInfo;
    }


    public static Retrofit getRetrofit() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(30, TimeUnit.SECONDS);
        builder.readTimeout(30, TimeUnit.SECONDS);
        builder.addInterceptor(new HttpInterceptor());
        retrofit = new Retrofit.Builder()
                .client(builder.build())
                .baseUrl("http://api.yhjg.qianhaijifen.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit;
    }


    /**
     * 初始化 bugly crash 组件：用于上报小直播的 crash。
     */
    private void initBuglyCrashReportSDK() {
        CrashReport.UserStrategy strategy = new CrashReport.UserStrategy(getApplicationContext());
        strategy.setAppVersion(TXLiveBase.getSDKVersionStr());
        //TODO
        // 若您需要使用的话，请将 BUGLY_APPID 替换为您的 appid，否则会出现无法上报的问题。
        CrashReport.initCrashReport(getApplicationContext(), BUGLY_APPID, true, strategy);
    }

    /**
     *
     * 初始化 ELK 数据上报：仅仅适用于数据收集上报，您可以不关注；或者将相关代码删除。
     */
    private void initXZBAppELKReport() {
        TCELKReportMgr.getInstance().init(this);
        TCELKReportMgr.getInstance().registerActivityCallback(this);
        TCELKReportMgr.getInstance().reportELK(TCConstants.ELK_ACTION_START_UP, TCUserMgr.getInstance().getUserId(), 0, "启动成功", null);
    }

}
