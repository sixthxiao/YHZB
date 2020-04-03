package com.yahu.live.wxapi;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.yahu.live.TCApplication;
import com.yahu.live.pay.CodeMsg;
import com.yahu.live.pay.PaymentActivity;
import com.yahu.live.R;

/**
 * 支付结果回调界面
 */

public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler {


    private IWXAPI api;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pay_result);
        if(TCApplication.payRequestInfo!=null){
            api = WXAPIFactory.createWXAPI(this, TCApplication.payRequestInfo.toWechatRst().getAppId());
            api.registerApp( TCApplication.payRequestInfo.toWechatRst().getAppId());
            api.handleIntent(getIntent(), this);
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        api.handleIntent(intent, this);
    }

    @Override
    public void onReq(BaseReq req) {

    }

    @Override
    public void onResp(BaseResp resp) {

        if (resp.getType() == ConstantsAPI.COMMAND_PAY_BY_WX) {
            CodeMsg msg = new CodeMsg();
            switch (resp.errCode) {
                case 0:
                    msg.code = PaymentActivity.PAY_RESULT_OK;
                    msg.msg = getString(R.string.txt_pay_success);
                    break;
                case -1:
                    msg.code = PaymentActivity.PAY_RESULT_ERROR;
                    msg.msg = getString(R.string.txt_pay_fail);
                    break;
                case -2:
                    msg.code = PaymentActivity.PAY_RESULT_CANCEL;
                    msg.msg = getString(R.string.txt_pay_cancel);
                    break;
                default:
                    msg.code = PaymentActivity.PAY_RESULT_ERROR;
                    msg.msg = getString(R.string.txt_pay_error);
                    break;
            }
            TCApplication.setPayResult(msg);
            finish();
        }
    }
}