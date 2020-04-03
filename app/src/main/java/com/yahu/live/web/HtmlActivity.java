package com.yahu.live.web;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.multidex.BuildConfig;

import com.alipay.sdk.app.PayTask;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.model.Response;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.vector.update_app.HttpManager;
import com.vector.update_app.UpdateAppBean;
import com.vector.update_app.UpdateAppManager;
import com.vector.update_app.UpdateCallback;
import com.yahu.live.R;
import com.yahu.live.TCApplication;
import com.yahu.live.TCGlobalConfig;
import com.yahu.live.base.PayResult;
import com.yahu.live.bean.MixUserInfo;
import com.yahu.live.bean.VersionBean;
import com.yahu.live.login.TCLoginActivity;
import com.yahu.live.main.BaseActivity;
import com.yahu.live.permission.PermissionUtil;
import com.yahu.live.utils.ConfigUtils;
import com.yahu.live.utils.SpUtils;
import com.yahu.live.view.DragView;
import com.yahu.live.view.TitleBar;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * html
 * Created by Administrator on 2018/6/15.
 */

public class HtmlActivity extends BaseActivity implements MyWebChomeClient.OpenFileChooserCallBack {
    private static final int GET_COUPON = 0;

    private WebView webView;
    private ProgressBar progressBar;
    private TitleBar titleBar;
    private Boolean TAG = false;
    private String base_url;
    private CustomNavigationJsObject customNavigationActivity;
    private SpUtils spUtils;
    private static final int REQUEST_PERMISSION_STORAGE = 0x01;

    private static final int SDK_PAY_FLAG = 1;

    private final int REQUEST_EXTERNAL_STORAGE = 1;
    private String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};


    private Intent mSourceIntent;
    private ValueCallback<Uri> mUploadMsg;
    public ValueCallback<Uri[]> mUploadMsgForAndroid5;

    // permission Code
    private static final int P_CODE_PERMISSIONS = 101;
    private static final int REQUEST_CODE_PICK_IMAGE = 0;
    private static final int REQUEST_CODE_IMAGE_CAPTURE = 1;
    private static final int FILE_CHOOSER_RESULT_CODE = 10000;


    private int versionId = 0;

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @SuppressWarnings("unused")
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: //支付完成返回
//                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
//                    Intent intent = new Intent(this, PayResultActivity.class);
//                    intent.putExtra("is_paid", payResult.getResultStatus().equals("9000"));
//                    intent.putExtra("id", orderId);
//                    startActivity(intent);
//                    finish();
                    break;
                default:
                    break;
            }
        }

    };

    private IWXAPI iwxapi;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_html);
        verifyStoragePermissions(this);
        requestPermissionsAndroidM();

        spUtils = SpUtils.getInstance("YAO");
        webView = (WebView) findViewById(R.id.wv);
//        appUtil = new AppUtilJSInterfaceX5(this, this, webView);
//        adUtil = new AdUtilJSInterfaceX5(this, this, webView);
        customNavigationActivity = new CustomNavigationJsObject(this);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        titleBar = findViewById(R.id.title_bar);
        titleBar.setTitle("雅虎金鸽");
        titleBar.setVisibility(View.GONE);
        initData();
    }


    public void initData() {
        initX5(webView);
        webView.addJavascriptInterface(this, "AppUtil");
        webView.setWebChromeClient(new MyWebChomeClient(HtmlActivity.this));
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Uri uri = Uri.parse(url);
                Uri currentUri = Uri.parse(base_url);
                if (url.startsWith("weixin://") || url.contains("alipays://platformapi")) { //如果微信或者支付宝，跳转到相应的app界面,
                    view.goBack();
                    try {
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(url));
                        startActivity(intent);
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "未安装相应的客户端！！", Toast.LENGTH_SHORT).show();
                    }
                    return true;
                }
                if (url != null && url.startsWith("http")) {
                    if (url.toLowerCase().contains("/login") || url.contains("Passport/Login") || url.contains("/WeChatOpen/Login") || url.contains("passport/login")) {

                        Intent intent05 = new Intent(getApplicationContext(), TCLoginActivity.class);
                        intent05.putExtra("url", TCGlobalConfig.WEB_URL);
                        startActivityForResult(intent05, TCGlobalConfig.RST_LOGIN);
                    } else if (url.toLowerCase().contains("passport/register")) {

                        Intent intent05 = new Intent(getApplicationContext(), TCLoginActivity.class);
                        intent05.putExtra("url", TCGlobalConfig.WEB_URL);
                        startActivityForResult(intent05, TCGlobalConfig.RST_LOGIN);
                        spUtils.put("yao_code_state", "1");
                    }
                }
                view.loadUrl(url, getHeaders());
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setProgress(100);
                progressBar.setVisibility(View.GONE);

            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar.setProgress(0);
                progressBar.setVisibility(View.VISIBLE);
            }

        });


        base_url = getUrl(getIntent());
        loadUrl();
    }


    private String getUrl(Intent intent) {
        if (intent.getExtras() != null) {
            return intent.getStringExtra("url");
        } else if (intent.getData() != null) {
            try {
                TAG = true;
                return new JSONObject(intent.getData().toString()).optJSONObject("n_extras").optString("url");
            } catch (Exception e) {
            }
        }
        return "";
    }

    /**
     * 退出登录
     */
    @JavascriptInterface
    public void logout() {
        TCApplication.setUserInfo(new MixUserInfo());
        ConfigUtils.setUser(new MixUserInfo());
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.removeAllCookie();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            cookieManager.flush();
        } else {
            CookieSyncManager.createInstance(getApplicationContext());
            CookieSyncManager.getInstance().sync();
        }
        spUtils.put("LOGIN_STATE", "0");
        Intent intent05 = new Intent(this, TCLoginActivity.class);
        startActivity(intent05);
        finish();
    }


    /**
     * log
     */
    @JavascriptInterface
    public void log(String tag) {
        Log.i("TAG", tag + "---------------");
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }


    private void initX5(WebView webView) {
        com.tencent.smtt.sdk.WebSettings webSetting = webView.getSettings();
        // 设置支持javascript脚本
        webSetting.setJavaScriptEnabled(true);
        webSetting.setJavaScriptCanOpenWindowsAutomatically(true);
        //设置支持html5本地存储
        webSetting.setDomStorageEnabled(true);

        webSetting.setAllowUniversalAccessFromFileURLs(true);
        // 允许访问文件
        webSetting.setAllowFileAccess(true);
        webSetting.setAllowFileAccessFromFileURLs(true);

        webSetting.setBlockNetworkImage(false);

        String appCachePath = TCApplication.getInstance().getCacheDir().getAbsolutePath();
        webSetting.setAppCachePath(appCachePath);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            webSetting.setLayoutAlgorithm(com.tencent.smtt.sdk.WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        } else {
            webSetting.setLayoutAlgorithm(com.tencent.smtt.sdk.WebSettings.LayoutAlgorithm.SINGLE_COLUMN);

        }
        // 支持缩放
        webSetting.setSupportZoom(false);
        // 设置显示缩放按钮
        webSetting.setBuiltInZoomControls(false);
        webSetting.setUseWideViewPort(true);

        webSetting.setSupportMultipleWindows(true);
        webSetting.setAppCacheEnabled(true);
        webSetting.setJavaScriptCanOpenWindowsAutomatically(true);
        webSetting.setGeolocationEnabled(true);
        webSetting.setCacheMode(WebSettings.LOAD_DEFAULT);
        //是否阻止图像的显示
        webSetting.setBlockNetworkImage(false);
        webSetting.setLoadsImagesAutomatically(true); //支持自动加载图片
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webSetting.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);

        }
        webSetting.setDefaultTextEncodingName("utf-8");
//        String ua = webSetting.getUserAgentString();
//        webSetting.setUserAgentString("Android");


    }

    private void loadUrl() {

//        setCookieToWebView();
        HashMap extraHeaders = getHeaders();
//        if (customNavigationActivity != null && customNavigationActivity.getKey() != null) {
//            extraHeaders.put(customNavigationActivity.getKey(), customNavigationActivity.getValue());
//        }

        webView.loadUrl(base_url, extraHeaders);
    }

    public HashMap<String, String> getHeaders() {
        HashMap map = new HashMap<String, String>();
        JSONObject json = new JSONObject();
        try {
            json.put("company", "yhjg");
            json.put("support", "jiahang");
            json.put("version", BuildConfig.VERSION_NAME);
            json.put("version-sn", BuildConfig.VERSION_CODE);
            json.put("system", "android");
            json.put("device", Build.BRAND + ";" + Build.DEVICE);
            json.put("source", "webview");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        map.put("client-agent", json.toString());
        if (TCApplication.getUserInfo() != null) {
            map.put("Authorization", TCApplication.getUserInfo().getToken());
        }
        return map;
    }

    /**
     * cookie
     * 设置
     */
    public void setCookieToWebView() {
        CookieManager cookieManager = CookieManager.getInstance();
        String cookies = cookieManager.getCookie(TCGlobalConfig.WEB_URL);
        cookieManager.removeAllCookie();
        if (cookies == null || !cookies.contains("Authorization=" + TCApplication.getUserInfo().getToken())) {
            cookieManager.setAcceptCookie(true);
            cookieManager.setCookie(TCGlobalConfig.WEB_URL, "Authorization=" + TCApplication.getUserInfo().getToken());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                cookieManager.flush();
            } else {
                CookieSyncManager.createInstance(getApplicationContext());
                CookieSyncManager.getInstance().sync();
            }
        }
        String cookies01 = cookieManager.getCookie(TCGlobalConfig.WEB_URL);
        Log.i("TAG", cookies01);
    }

    @Override
    public void openFileChooserCallBack(ValueCallback<Uri> uploadMsg, String acceptType) {
        mUploadMsg = uploadMsg;
//        openImageChooserActivity();
    }

    @Override
    public boolean openFileChooserCallBackAndroid5(WebView webView, ValueCallback<Uri[]> filePathCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        mUploadMsgForAndroid5 = filePathCallback;
        Log.d("q", "q-----------------------------------");
//        showOptions();
//        openImageChooserActivity();
        return true;
    }


    private void restoreUploadMsg() {
        if (mUploadMsg != null) {
            mUploadMsg.onReceiveValue(null);
            mUploadMsg = null;

        } else if (mUploadMsgForAndroid5 != null) {
            mUploadMsgForAndroid5.onReceiveValue(null);
            mUploadMsgForAndroid5 = null;
        }
    }

    private void requestPermissionsAndroidM() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            List<String> needPermissionList = new ArrayList<>();
            needPermissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            needPermissionList.add(Manifest.permission.READ_EXTERNAL_STORAGE);
            needPermissionList.add(Manifest.permission.CAMERA);

            PermissionUtil.requestPermissions(HtmlActivity.this, P_CODE_PERMISSIONS, needPermissionList);

        } else {
            return;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        switch (requestCode) {
            case P_CODE_PERMISSIONS:
                requestResult(permissions, grantResults);
                restoreUploadMsg();
                break;
            case REQUEST_PERMISSION_STORAGE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //获取权限
                    isAccept(permissions, grantResults);
                } else {
                    Toast.makeText(HtmlActivity.this,
                            "权限被禁止，不能正常使用APP",
                            Toast.LENGTH_SHORT).show();
                }
                break;

            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    public void requestResult(String[] permissions, int[] grantResults) {
        ArrayList<String> needPermissions = new ArrayList<String>();

        for (int i = 0; i < grantResults.length; i++) {
            if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                if (PermissionUtil.isOverMarshmallow()) {

                    needPermissions.add(permissions[i]);
                }
            }
        }

        if (needPermissions.size() > 0) {
            StringBuilder permissionsMsg = new StringBuilder();

            for (int i = 0; i < needPermissions.size(); i++) {
                String strPermissons = needPermissions.get(i);

                if (Manifest.permission.WRITE_EXTERNAL_STORAGE.equals(strPermissons)) {
                    permissionsMsg.append("," + getString(R.string.permission_storage));

                } else if (Manifest.permission.READ_EXTERNAL_STORAGE.equals(strPermissons)) {
                    permissionsMsg.append("," + getString(R.string.permission_storage));

                } else if (Manifest.permission.CAMERA.equals(strPermissons)) {
                    permissionsMsg.append("," + getString(R.string.permission_camera));

                }
            }

            String strMessage = "请允许使用\"" + permissionsMsg.substring(1).toString() + "\"权限, 以正常使用APP的所有功能.";

            Toast.makeText(HtmlActivity.this, strMessage, Toast.LENGTH_SHORT).show();

        } else {
            return;
        }
    }


    /**
     * 监听返回处理
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == event.KEYCODE_BACK) {//监听返回键，如果可以后退就后退
            if (webView.canGoBack()) {
                webView.goBack();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }


    public void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE);
        }
    }






    public boolean isAccept(@NonNull String[] permissions, @NonNull int[] grantResults) {
        for (int i = 0; i < grantResults.length; i++) {
            if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                if (!ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 支付宝支付
     * @param orderInfo
     */
    private void aliPay(final String orderInfo) {

        Runnable payRunnable = new Runnable() {
            @Override
            public void run() {
                PayTask payTask = new PayTask(HtmlActivity.this);
                Map<String, String> result = payTask.payV2(orderInfo, true);
                Log.i("msp", result.toString());
                Message msg = new Message();
                msg.what = SDK_PAY_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };
        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }

    /**
     * 微信支付
     * @param jsonObject
     */
    private void weChatPay(JSONObject jsonObject) {
        if (iwxapi == null) {
            iwxapi = WXAPIFactory.createWXAPI(this, null);
            iwxapi.registerApp(TCGlobalConfig.WX_KEY);
        }
        PayReq request = new PayReq();
        request.appId = jsonObject.optString("appid");
        request.partnerId = jsonObject.optString("partnerId");
        request.prepayId = jsonObject.optString("prepayId");
        request.packageValue = "Sign=WXPay";
        request.nonceStr = jsonObject.optString("nonceStr");
        request.timeStamp = jsonObject.optString("timeStamp");
        request.sign = jsonObject.optString("sign");
        iwxapi.sendReq(request);
    }

}


