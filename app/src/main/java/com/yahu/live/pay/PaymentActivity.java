package com.yahu.live.pay;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import butterknife.ButterKnife;
import com.alipay.sdk.app.PayTask;

import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.yahu.live.TCApplication;
import com.yahu.live.main.BaseActivity;
import com.yahu.live.R;

import java.util.Map;

public class PaymentActivity extends BaseActivity {
    //以下支付结果码已经充分兼容微信支付
    public static final int PAY_RESULT_WAIT = 5;
    public static final int PAY_RESULT_OK = 0;
    public static final int PAY_RESULT_CANCEL = -2;
    public static final int PAY_RESULT_ERROR = -1;
    public static final int PAY_RESULT_FAIL = 1;//支付失败
    public static final int PAY_RESULT_UNKNOWN = 2;
    public static final int PAY_NOT_INSTALL_WX = 3;

    Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case PAY_RESULT_WAIT:
                    break;
                case PAY_RESULT_OK:
                    setResult(RESULT_OK);
                    break;
                case PAY_RESULT_UNKNOWN:
                case PAY_RESULT_CANCEL:
                case PAY_RESULT_ERROR:
                case PAY_RESULT_FAIL:
                default:
                    setResult(RESULT_CANCELED);
                    break;
            }
            finish();
        }
    };
    private IWXAPI api;
    private PayRequestInfo payRequestInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        ButterKnife.bind(this);
        payRequestInfo = getIntent().getParcelableExtra("request");
        TCApplication.payRequestInfo=payRequestInfo;
        if (payRequestInfo.getType() .equals("weixin")) {//微信支付
            WechatOrderRst appRst=payRequestInfo.toWechatRst();
            api = WXAPIFactory.createWXAPI(this, appRst.getAppId());
            api.registerApp(appRst.getAppId());
            if (!api.isWXAppInstalled()) {
                Message msg = new Message();
                msg.what = PAY_NOT_INSTALL_WX;
                msg.obj = "未安装微信";
                mHandler.sendMessage(msg);
                return;
            }
            PayReq request = new PayReq();
            request.appId = appRst.getAppId();
            request.partnerId = appRst.getPartnerId();
            request.prepayId = appRst.getPrepayId();
            request.packageValue = appRst.getPackageValue();
            request.nonceStr = appRst.getNonceStr();
            request.timeStamp = appRst.getTimestamp();
            request.sign = appRst.getSign();
            api.sendReq(request);
        } else {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    PayTask alipay = new PayTask(PaymentActivity.this);
                    Map<String, String> result = alipay.payV2(payRequestInfo.getPayInfo(), true);
                    String resultStatus = result.get("resultStatus");
                    CodeMsg msg = new CodeMsg();
                    switch (resultStatus) {
                        case "9000":
                            msg.setCode(PAY_RESULT_WAIT);
                            msg.setMsg("正在查询交易结果");
                            break;
                        case "8000":
                        case "6004":
                            msg.code = PAY_RESULT_UNKNOWN;
                            msg.msg = "支付处理中";
                            break;
                        case "4000":
                            msg.code = PAY_RESULT_FAIL;
                            msg.msg = "支付失败";
                            break;
                        case "5000":
                            msg.code = PAY_RESULT_ERROR;
                            msg.msg = "重复请求";
                            break;
                        case "6001":
                            msg.code = PAY_RESULT_CANCEL;
                            msg.msg = "支付已取消";
                            break;
                        case "6002":
                            msg.code = PAY_RESULT_ERROR;
                            msg.msg = "网络错误";
                            break;
                        default:
                            msg.code = PAY_RESULT_ERROR;
                            msg.msg = "发生未知错误";
                            break;
                    }
                    TCApplication.setPayResult(msg);
                    mHandler.sendEmptyMessage(msg.code);
                }
            }).start();
        }

    }


    @Override
    protected void onResume() {
        super.onResume();
        if(payRequestInfo.getType().equals("weixin")){
            CodeMsg msg = TCApplication.getPayResult();
            if (payRequestInfo != null && msg != null) {
                mHandler.sendEmptyMessage(msg.code);
            }
        }
    }
}
