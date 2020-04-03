package com.hepeng.baselibrary.glide;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.hepeng.baselibrary.base.BaseApplication;
import com.hepeng.baselibrary.utils.SPUtils;
import com.hepeng.life.baselibrary.R;

public class GlideUtil {

    /**
     * @param url  返回过来的图片连接
     * @return
     */
    public static void glideLoadHead(Context context, String url, ImageView imageView) {
        String fullUrl = "";
        if (!TextUtils.isEmpty(url)) {
            if (url.startsWith("http")) {
                fullUrl = url;
            } else if (url.startsWith("/")) {
                if (url.startsWith("/storage/")) {
                    fullUrl = url;
                } else {
                    fullUrl = SPUtils.getInstance(context).getCosTempBean().getDomain() + url;
                }
            } else {
                fullUrl = SPUtils.getInstance(context).getCosTempBean().getDomain() + "/store/img/" + url;
            }
        }

        Glide.with(context)
                .load(fullUrl)
                .placeholder(R.drawable.head_icon)
                .error(R.drawable.head_icon)
                .centerCrop()
                .into(imageView);
    }


    public static void glideLoad(Context context, String url, ImageView imageView, Integer type) {
        String fullUrl = "";
        if (!TextUtils.isEmpty(url)) {
            if (url.startsWith("http")) {
                fullUrl = url;
            } else if (url.startsWith("/")) {
                if (url.startsWith("/storage/")) {
                    fullUrl = url;
                } else {
                    fullUrl = SPUtils.getInstance(context).getCosTempBean().getDomain() + url;
                }
            } else {
                fullUrl = SPUtils.getInstance(context).getCosTempBean().getDomain() + (type == 1 ? "/chat/img/" : "/store/img/") + url;
            }
        }
        Glide.with(context)
                .load(fullUrl)
                .placeholder(R.drawable.zhanwei)
                .error(R.drawable.zhanwei)
                .centerCrop()
                .into(imageView);
    }

    public static void glideLoadCenterInside(Context context, String url, ImageView imageView, Integer type) {
        String fullUrl = "";
        if (!TextUtils.isEmpty(url)) {
            if (url.startsWith("http")) {
                fullUrl = url;
            } else if (url.startsWith("/")) {
                if (url.startsWith("/storage/")) {
                    fullUrl = url;
                } else {
                    fullUrl = SPUtils.getInstance(context).getCosTempBean().getDomain() + url;
                }
            } else {
                fullUrl = SPUtils.getInstance(context).getCosTempBean().getDomain() + (type == 1 ? "/chat/img/" : "/store/img/") + url;
            }
        }
        Glide.with(context)
                .load(fullUrl)
                .placeholder(R.drawable.zhanwei)
                .error(R.drawable.zhanwei)
                .centerInside()
                .into(imageView);
    }

    public static void glideClear() {
        Glide.get(BaseApplication.appContext).clearDiskCache();
        Glide.get(BaseApplication.appContext).clearMemory();
    }
}
