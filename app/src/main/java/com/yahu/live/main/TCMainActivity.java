package com.yahu.live.main;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.hardware.biometrics.BiometricPrompt;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.provider.Settings;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.model.Response;
import com.tencent.android.tpush.XGIOperateCallback;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.XGPushManager;
import com.yahu.liteav.demo.lvb.liveroom.IMLVBLiveRoomListener;
import com.yahu.liteav.demo.lvb.liveroom.MLVBLiveRoom;
import com.yahu.liteav.demo.lvb.liveroom.roomutil.commondef.AnchorInfo;
import com.yahu.liteav.demo.lvb.liveroom.roomutil.commondef.AudienceInfo;
import com.yahu.liteav.demo.lvb.liveroom.roomutil.commondef.MLVBCommonDef;
import com.yahu.live.TCApplication;
import com.yahu.live.TCGlobalConfig;
import com.yahu.live.bean.VersionBean;
import com.vector.update_app.HttpManager;
import com.vector.update_app.UpdateAppBean;
import com.vector.update_app.UpdateAppManager;
import com.vector.update_app.UpdateCallback;
import com.yahu.live.BuildConfig;
import com.yahu.live.R;
import com.yahu.live.common.utils.TCUtils;
import com.yahu.live.home.AttentionFragment;
import com.yahu.live.home.HometFragment;
import com.yahu.live.login.TCLoginActivity;
import com.yahu.live.main.videolist.ui.TCVideoListFragment;
import com.yahu.live.login.TCUserMgr;
import com.yahu.live.profile.TCUserInfoFragment;
import com.yahu.live.scan.QrScanAty;
import com.yahu.live.utils.SpUtils;
import com.yahu.live.view.NoScrollViewPager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static android.Manifest.permission.USE_FINGERPRINT;

/**
 * Module:   TCMainActivity
 * <p>
 * Function: 主界面：直播列表、回放列表、个人信息页
 */
public class TCMainActivity extends FragmentActivity {
    static final int NUM_ITEMS = 5;
    private int versionId = 0; //版本id
    private final Class mFragmentArray[] = {TCVideoListFragment.class, TCVideoListFragment.class, TCUserInfoFragment.class, TCUserInfoFragment.class, TCUserInfoFragment.class};
    private int mImageViewArray[] = {R.drawable.tab_video, R.drawable.tab_video, R.drawable.tab_video, R.drawable.tab_video, R.drawable.tab_user};

    private String strings[] = {"首页", "直播", "关注", "视频", "我的"};
    private List<Fragment> fragmentList = new ArrayList<Fragment>();
    private TabLayout tab_layout;
    private SpUtils spUtils;

                   //使用handler的Looper处理指纹识别硬件的信息；为null，则使用app的main Looper处理；

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        //After LOLLIPOP not translucent status bar
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //Then call setStatusBarColor.
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(getResources().getColor(R.color.main_color));
        }
        spUtils = SpUtils.getInstance("YAO");
        setContentView(R.layout.activity_main);
        fragmentList.add(new HometFragment());
        fragmentList.add(new TCVideoListFragment());
        fragmentList.add(new AttentionFragment());
        fragmentList.add(new TCVideoListFragment());
        fragmentList.add(new TCUserInfoFragment());

        tab_layout = findViewById(R.id.main_tab);
        tab_layout.addTab(tab_layout.newTab().setText("首页").setIcon(R.drawable.ic_home_homepage));
        tab_layout.addTab(tab_layout.newTab().setText("直播").setIcon(R.drawable.ic_home_live));
        tab_layout.addTab(tab_layout.newTab().setText("关注").setIcon(R.drawable.ic_home_attention));
        tab_layout.addTab(tab_layout.newTab().setText("视频").setIcon(R.drawable.ic_home_video));
        tab_layout.addTab(tab_layout.newTab().setText("我的").setIcon(R.drawable.ic_home_me));
        // 修改样式，主要是调近了图标与文字之间的距离
        tab_layout.getTabAt(0).setCustomView(getTabView("首页", R.drawable.ic_home_homepage));
        tab_layout.getTabAt(1).setCustomView(getTabView("直播", R.drawable.ic_home_live));
        tab_layout.getTabAt(2).setCustomView(getTabView("关注", R.drawable.ic_home_attention));
        tab_layout.getTabAt(3).setCustomView(getTabView("视频", R.drawable.ic_home_video));
        tab_layout.getTabAt(4).setCustomView(getTabView("我的", R.drawable.ic_home_me));
        NoScrollViewPager viewPager = findViewById(R.id.viewPager);

        MyAdapter fragmentAdater = new MyAdapter(getSupportFragmentManager());
        viewPager.setAdapter(fragmentAdater);
        //这个方法会remove掉tabitem
//        tab_layout.setupWithViewPager(viewPager);
        TextView textView = tab_layout.getTabAt(0).getCustomView().findViewById(R.id.textview);
        textView.setTextColor(getResources().getColor(R.color.main_color));
        tab_layout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //选中某个tab
                viewPager.setCurrentItem(tab.getPosition());
                TextView textView = tab_layout.getTabAt(tab.getPosition()).getCustomView().findViewById(R.id.textview);
                textView.setTextColor(getResources().getColor(R.color.main_color));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //当tab从选择到未选择
                TextView textView = tab_layout.getTabAt(tab.getPosition()).getCustomView().findViewById(R.id.textview);
                textView.setTextColor(getResources().getColor(R.color.main_505050));
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //已经选中tab后的重复点击tab
            }
        });
        if (Build.VERSION.SDK_INT >= 23) {
            int REQUEST_CODE_CONTACT = 101;
            String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
            //验证是否许可权限
            for (String str : permissions) {
                if (this.checkSelfPermission(str) != PackageManager.PERMISSION_GRANTED) {
                    //申请权限
                    this.requestPermissions(permissions, REQUEST_CODE_CONTACT);
                    return;
                }
            }
        }
//        checkPermission();

        //设置魅族APPID和APPKEY
        XGPushConfig.enableOtherPush(this, true);
        XGPushConfig.setMzPushAppId(this, "APP_ID");
        XGPushConfig.setMzPushAppKey(this, "APP_KEY");

        //小米配置
        XGPushConfig.setMiPushAppId(getApplicationContext(), "APPID");
        XGPushConfig.setMiPushAppKey(getApplicationContext(), "APPKEY");
        //打开第三方推送
        XGPushConfig.enableOtherPush(getApplicationContext(), true);

        //推送
        XGPushConfig.enableDebug(this, true);
        XGPushManager.registerPush(this, new XGIOperateCallback() {
            @Override
            public void onSuccess(Object data, int flag) {
                //token在设备卸载重装的时候有可能会变
                Log.d("TAG", "注册成功，设备token为：" + data);
            }

            @Override
            public void onFail(Object data, int errCode, String msg) {
                Log.d("TAG", "注册失败，错误码：" + errCode + ",错误信息：" + msg);
            }
        });
    }

    // Tab自定义view
    public View getTabView(String title, int image_src) {
        View v = LayoutInflater.from(getApplicationContext()).inflate(R.layout.tab_item_view, null);
        TextView textView = (TextView) v.findViewById(R.id.textview);
        textView.setText(title);
        ImageView imageView = (ImageView) v.findViewById(R.id.imageview);
        imageView.setImageResource(image_src);
        return v;
    }


    /**
     * 检查应用内安装APP权限
     */
    public void checkPermission() {
        boolean haveInstallPermission;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            haveInstallPermission = getPackageManager().canRequestPackageInstalls();
            if (!haveInstallPermission) {
                //没有权限让调到设置页面进行开启权限；
                Uri packageURI = Uri.parse("package:" + getPackageName());
                Intent intent = new Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES, packageURI);
                startActivityForResult(intent, 10086);
            } else {
                updateAPK();
            }
        } else {
            updateAPK();
        }
    }

    private void updateAPK() {
        new UpdateAppManager
                .Builder()
                //必须设置，当前Activity
                .setActivity(TCMainActivity.this)
                //必须设置，实现httpManager接口的对象
                .setHttpManager(new UpdateAppHttpUtil())
                //必须设置，更新地址
                .setUpdateUrl(TCGlobalConfig.UPDATE_VERSION_URL)

                //以下设置，都是可选
                //设置请求方式，默认get
                .setPost(false)
                //添加自定义参数，默认version=1.0.0（app的versionName）；apkKey=唯一表示（在AndroidManifest.xml配置）
//                .setParams(params)
                //设置点击升级后，消失对话框，默认点击升级后，对话框显示下载进度
//                .hideDialogOnDownloading()
                //设置头部，不设置显示默认的图片，设置图片后自动识别主色调，然后为按钮，进度条设置颜色
//                .setTopPic(R.mipmap.top_8)
                //为按钮，进度条设置颜色，默认从顶部图片自动识别。
                //.setThemeColor(ColorUtil.getRandomColor())
                //设置apk下砸路径，默认是在下载到sd卡下/Download/1.0.0/test.apk
                .setTargetPath(getDiskCacheDir(this))
                //设置appKey，默认从AndroidManifest.xml获取，如果，使用自定义参数，则此项无效
                //.setAppKey("ab55ce55Ac4bcP408cPb8c1Aaeac179c5f6f")
                //不显示通知栏进度条
                .dismissNotificationProgress()
                //是否忽略版本
                //.showIgnoreVersion()

                .build()
                //检测是否有新版本
                .checkNewApp(new UpdateCallback() {
                    /**
                     * 解析json,自定义协议
                     *
                     * @param json 服务器返回的json
                     * @return UpdateAppBean
                     */
                    @Override
                    protected UpdateAppBean parseJson(String json) {
                        Gson gson = new Gson();
                        VersionBean versionBean = gson.fromJson(json, VersionBean.class);
                        if (versionBean != null && versionBean.getResults().isForce_update()) {
                            versionId = Integer.parseInt(versionBean.getResults().getId());

//                            submit();
                        } else {
                            versionId = 0;
//                            submit();
                        }

                        UpdateAppBean updateAppBean = new UpdateAppBean();
                        updateAppBean
                                //（必须）是否更新Yes,No
                                .setUpdate(versionBean.getResults().getVersionCode() > BuildConfig.VERSION_CODE ? "Yes" : "No")
                                //（必须）新版本号，
                                .setNewVersion(versionBean.getResults().getVersion())
                                //（必须）下载地址
                                .setApkFileUrl(versionBean.getResults().getUrl())
                                //（必须）更新内容
                                .setUpdateLog(versionBean.getResults().getDetail())
                                //大小，不设置不显示大小，可以不设置
                                //.setTargetSize(versionBean.getTarget_size())
                                //是否强制更新，可以不设置
                                .setConstraint(versionBean.getResults().isForce_update());
                        //设置md5，可以不设置
                        //.setNewMd5(versionBean.getMd5());

                        return updateAppBean;
                    }
                });
    }

    public String getDiskCacheDir(Context context) {
        String cachePath = null;
//        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
//                || !Environment.isExternalStorageRemovable()) {
//            cachePath = context.getExternalCacheDir().getPath();
//        } else {
//            cachePath = context.getCacheDir().getPath();
//        }
        cachePath = TCApplication.getInstance().getCacheDir().getAbsolutePath();
        return cachePath;
    }

    class UpdateAppHttpUtil implements HttpManager {

        @Override
        public void asyncGet(@NonNull String url, @NonNull Map<String, String> params, @NonNull final Callback callBack) {

            OkGo.<String>get(url)
                    .params(params)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(Response<String> response) {
                            callBack.onResponse(response.body());
                        }

                        @Override
                        public void onError(Response<String> response) {
                            super.onError(response);
                            callBack.onError(response.body());
                        }
                    });

        }

        @Override
        public void asyncPost(@NonNull String url, @NonNull Map<String, String> params, @NonNull final Callback callBack) {
            OkGo.<String>get(url)
                    .params(params)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(Response<String> response) {
                            callBack.onResponse(response.body());
                        }

                        @Override
                        public void onError(Response<String> response) {
                            super.onError(response);
                            callBack.onError(response.body());
                        }
                    });
        }

        @Override
        public void download(@NonNull String url, @NonNull String path, @NonNull String fileName, @NonNull final FileCallback callback) {
            OkGo.<File>get(url)
                    .execute(new com.lzy.okgo.callback.FileCallback() {
                        @Override
                        public void onStart(com.lzy.okgo.request.base.Request<File, ? extends com.lzy.okgo.request.base.Request> request) {
                            super.onStart(request);
                            callback.onBefore();
                        }

                        @Override
                        public void onSuccess(Response<File> response) {

                            callback.onResponse(response.body());
                        }

                        @Override
                        public void downloadProgress(Progress progress) {
                            super.downloadProgress(progress);
                            callback.onProgress(progress.fraction, progress.totalSize);
                        }

                        @Override
                        public void onError(Response<File> response) {
                            super.onError(response);
                            callback.onError("下载失败");
                        }
                    });
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        // 如果您的 App 没有做判断是否账号重复的登录的逻辑
        // 那么 MLVB 会监听是否有同一个人登录，所以在 resume 的时候需要重新设置 MLVB Room 的监听
        MLVBLiveRoom.sharedInstance(this).setListener(new IMLVBLiveRoomListener() {
            @Override
            public void onError(int errCode, String errMsg, Bundle extraInfo) {
                if (errCode == MLVBCommonDef.LiveRoomErrorCode.ERROR_IM_FORCE_OFFLINE) {
                    TCUtils.showKickOut(TCMainActivity.this);
                }
            }

            @Override
            public void onWarning(int warningCode, String warningMsg, Bundle extraInfo) {

            }

            @Override
            public void onDebugLog(String log) {

            }

            @Override
            public void onRoomDestroy(String roomID) {

            }

            @Override
            public void onAnchorEnter(AnchorInfo anchorInfo) {

            }

            @Override
            public void onAnchorExit(AnchorInfo anchorInfo) {

            }

            @Override
            public void onAudienceEnter(AudienceInfo audienceInfo) {

            }

            @Override
            public void onAudienceExit(AudienceInfo audienceInfo) {

            }

            @Override
            public void onRequestJoinAnchor(AnchorInfo anchorInfo, String reason) {

            }

            @Override
            public void onKickoutJoinAnchor() {

            }

            @Override
            public void onRequestRoomPK(AnchorInfo anchorInfo) {

            }

            @Override
            public void onQuitRoomPK(AnchorInfo anchorInfo) {

            }

            @Override
            public void onRecvRoomTextMsg(String roomID, String userID, String userName, String userAvatar, String message) {

            }

            @Override
            public void onRecvRoomCustomMsg(String roomID, String userID, String userName, String userAvatar, String cmd, String message) {

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (TextUtils.isEmpty(TCUserMgr.getInstance().getUserToken())) {
            if (TCUtils.isNetworkAvailable(this) && TCUserMgr.getInstance().hasUser()) {
                TCUserMgr.getInstance().autoLogin(null);
            }
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == 10086) {
            //检查版本更新
            updateAPK();
        } else if (requestCode == 25 && resultCode == Activity.RESULT_OK && data != null) {
            String url = data.getStringExtra("result");
            if (url != null) {
                url = url.toLowerCase();
            }
            Log.i("TAG", url);
            if (url != null) {
                if (url.startsWith("http://m.yhjg.qianhaijifen.com/passport/register/")) {
                    Intent i = new Intent(getApplicationContext(), TCLoginActivity.class);
                    i.putExtra("data", url.replace("http://m.yhjg.qianhaijifen.com/passport/register/", ""));
//                    ViewPageEvent viewPageEvent = new ViewPageEvent(url.replace("yhjg://register/", ""));
//                    EventBus.getDefault().post(new MyBusEvent(MyBusEvent.REGISTER, viewPageEvent));
                    spUtils.put("yao_code", url.replace("http://m.yhjg.qianhaijifen.com/passport/register/", "").trim());
                    spUtils.put("state", 1);
                    startActivity(i);

                } else if (url.startsWith("http")) {

//                    Intent i = new Intent(getApplicationContext(), HtmlActivity.class);
//                    i.putExtra("url", url);
//                    i.putExtra("mode", 2);
//                    startActivity(i);
                } else {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                    dialog.setTitle("扫到的内容如下：");
                    dialog.setMessage(url);
                    dialog.setIcon(R.mipmap.ic_launcher);
                    dialog.setCancelable(true);            //点击对话框以外的区域是否让对话框消失

                    //设置正面按钮
                    dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            dialog.dismiss();
                        }
                    });
                    dialog.show();
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

//        @Nullable
//        @Override
//        public CharSequence getPageTitle(int position) {
//            return strings[position];
//        }
    }


    @RequiresPermission(USE_FINGERPRINT) //限定需要权限
    public void authenticate(
            @Nullable BiometricPrompt.CryptoObject crypto,             //加密类对象；
            @Nullable CancellationSignal cancel,       //用来取消当前扫描操作（30s才超时）；
            int flags,                                 //标识位，暂时设置为0即可；
            @NonNull BiometricPrompt.AuthenticationCallback callback,  //认证结果回调；
            @Nullable Handler handler){

    }
}
