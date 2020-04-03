package com.yahu.live.web;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * Created by czb365 on 2018/8/16.
 */

public class CustomNavigationJsObject {
    private Activity activity;
    private static String key, value;

    public CustomNavigationJsObject(Activity activity) {
        this.activity = activity;
    }

    /**
     * @return 返回数据给前端
     * @JavascriptInterface 这个注解必须添加，否则js调不到这个方法
     * 这个方法名称也必须要和前端保持一致
     */
    @JavascriptInterface
    public void startNavigate(String startLat, String startLng, String endLat, String endLng) {
        //去做想做的事情。比如导航，直接带着开始和结束的经纬度Intent到导航activity就可以

        if (TextUtils.isEmpty(startLat) || TextUtils.isEmpty(startLng) || TextUtils.isEmpty(endLat)
                || TextUtils.isEmpty(endLng)) {//如果接收的数据不正确，给予提示
            Toast.makeText(activity, "有不正确的数据", Toast.LENGTH_LONG).show();
            return;
        }

        final AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("提示");
        builder.setMessage("请调用自己的导航\n开始经纬度:" +
                startLat + "    " + startLng +
                "\n结束经纬度:" + endLat + "    " + endLng);

        builder.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        builder.setCancelable(false);
        builder.show();

    }

    //拿到设置webView的属性
    @JavascriptInterface
    public void setExtraInfoHead(String key, String value) {
        setKey(key);
        setValue(value);
        Log.e("添加头信息", key + "," + value);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}

