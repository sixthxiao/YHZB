package com.hepeng.baselibrary.networkstate;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * 实时监听网络状态变化
 */
public class NetWorkStateReceiver extends BroadcastReceiver {

    private int type;
    private int wifiState = 0;

    @Override
    public void onReceive(Context context, Intent intent) {
        //网络状态发生变化
        if (intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
            //获得ConnectivityManager对象
            ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = connMgr.getActiveNetworkInfo();

            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                if (activeNetworkInfo.getType() == (ConnectivityManager.TYPE_WIFI)) {
                    type = 0;
                    wifiState++;
                    if (wifiState < 2) {
//                        ToastUtil.showToast("正在使用WIFI网络");
                    }
                } else if (activeNetworkInfo.getType() == (ConnectivityManager.TYPE_MOBILE)) {
                    type = 1;
                    wifiState = 0;
//                    ToastUtil.showToast("正在使用移动网络");
                }
            } else {
                type = 2;
                wifiState = 0;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(2000);
                            if (type == 2) {
//                                ToastUtil.showToast("没有可用的网络，请检查网络！");
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        }
    }
}
