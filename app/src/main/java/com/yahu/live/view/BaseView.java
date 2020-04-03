package com.yahu.live.view;


import com.tencent.qcloud.core.http.HttpResult;

/**
 * Created by Dun on 2018/11/28.
 */

public interface BaseView {

    void onResponse(int what, HttpResult result);

}
