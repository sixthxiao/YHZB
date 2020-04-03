package com.hepeng.baselibrary.retrofit;

import android.app.ProgressDialog;
import android.content.Context;

import com.hepeng.baselibrary.utils.ToastUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import javax.net.ssl.SSLHandshakeException;

import io.reactivex.observers.DisposableObserver;
import retrofit2.HttpException;

public abstract class RequestCallBack<T> extends DisposableObserver<T> {
    /**
     * 是否需要显示默认Loading
     */
    private boolean showProgress = true;
    private Context context;
    private ProgressDialog progressDialog;
    private boolean isShowToast = true;
    private SmartRefreshLayout refreshLayout;

    public RequestCallBack() {

    }

    public RequestCallBack(boolean isShowToast) {
        this.isShowToast = isShowToast;
    }

    public RequestCallBack(Context context) {
        this.context = context;
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("正在加载中请稍后~");
    }

    public RequestCallBack(Context context, boolean isShowToast) {
        this.context = context;
        progressDialog = new ProgressDialog(context);
        this.isShowToast = isShowToast;
    }

    public RequestCallBack(SmartRefreshLayout refreshLayout) {
        this.refreshLayout = refreshLayout;
    }

    public RequestCallBack(Context context, SmartRefreshLayout refreshLayout) {
        this.context = context;
        this.refreshLayout = refreshLayout;
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("正在加载中请稍后~");
    }

    /**
     * 订阅开始时调用
     * 显示ProgressDialog
     */
    @Override
    public void onStart() {
        showProgressDialog();
    }


    /**
     * 完成，隐藏ProgressDialog
     */
    @Override
    public void onComplete() {
        dismissProgressDialog();
        finishRefreshOrLoadMore();
        progressDialog = null;
    }

    /**
     * 对错误进行统一处理
     * 隐藏ProgressDialog
     */
    @Override
    public void onError(Throwable e) {
        String errorStr = "";
        try {
            if (e instanceof SocketTimeoutException) {//请求超时
                if (isShowToast) {
                    ToastUtil.showToast("请求超时");
                }
                errorStr = "请求超时";
            } else if (e instanceof ConnectException) {//网络连接超时
                if (isShowToast) {
                    ToastUtil.showToast("网络连接超时");
                }
                errorStr = "网络连接超时";
            } else if (e instanceof SSLHandshakeException) {//安全证书异常
                if (isShowToast) {
                    ToastUtil.showToast("安全证书异常");
                }
                errorStr = "安全证书异常";
            } else if (e instanceof HttpException) {//请求的地址不存在
                int code = ((HttpException) e).code();
                if (code == 504) {
                    if (isShowToast) {
                        ToastUtil.showToast("网络异常，请检查您的网络状态");
                    }
                    errorStr = "网络异常，请检查您的网络状态";
                } else if (code == 404) {
                    if (isShowToast) {
                        ToastUtil.showToast("请求的地址不存在");
                    }
                    errorStr = "请求的地址不存在";
                } else {
                    if (isShowToast) {
                        ToastUtil.showToast(code + "");
                    }
                    errorStr = code + "";
                }
            } else if (e instanceof UnknownHostException) {//域名解析失败
                if (isShowToast) {
//                    ToastUtil.showToast("域名解析失败");
                    ToastUtil.showToast("网络异常，请检查您的网络状态");
                }
                errorStr = "网络异常，请检查您的网络状态";
            } else {
                if (isShowToast) {
                    ToastUtil.showToast(e.getMessage());
                }
                errorStr = e.getMessage();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        } finally {
            dismissProgressDialog();
            progressDialog = null;
            finishRefreshOrLoadMore();
            onFailed(errorStr);
        }

    }

    @Override
    public void onNext(T data) {
        dismissProgressDialog();
        progressDialog = null;
        finishRefreshOrLoadMore();
        onSuccess(data);
    }

    protected abstract void onSuccess(T t);

    protected abstract void onFailed(String message);

    private void showProgressDialog() {
        if (showProgress && null != progressDialog) {
            progressDialog.show();
        }
    }


    private void dismissProgressDialog() {
        if (showProgress && null != progressDialog) {
            progressDialog.dismiss();
        }
    }

    private void finishRefreshOrLoadMore() {
        if (refreshLayout != null) {
            refreshLayout.finishRefresh();
            refreshLayout.finishLoadMore();
        }
    }

}
