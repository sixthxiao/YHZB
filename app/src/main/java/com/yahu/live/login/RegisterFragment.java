package com.yahu.live.login;


import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.yahu.live.TCApplication;
import com.yahu.live.bean.MixUserInfo;
import com.yahu.live.bean.VerifyInfo;
import com.yahu.live.common.net.TCHTTPMgr;
import com.yahu.live.common.report.TCELKReportMgr;
import com.yahu.live.common.utils.TCConstants;
import com.yahu.live.main.TCMainActivity;
import com.yahu.live.retrofit.HttpResponse;
import com.yahu.live.retrofit.HttpResponseObserver;
import com.yahu.live.retrofit.SmsService;
import com.yahu.live.retrofit.UserService;
import com.yahu.live.utils.ConfigUtils;
import com.yahu.live.utils.Constants;
import com.yahu.live.utils.SpUtils;
import com.yahu.live.utils.Utils;
import com.yahu.live.view.Loading;
import com.yahu.live.R;

import org.json.JSONObject;

import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 注册
 */
public class RegisterFragment extends Fragment {

    @BindView(R.id.lg_pwd)
    EditText etPassword;
    @BindView(R.id.lg_usr)
    EditText etUsername;
    @BindView(R.id.lg_yzm)
    EditText lg_yzm;
    @BindView(R.id.lg_yao)
    EditText lg_yao;
    @BindView(R.id.lg_submit)
    Button btnRegister;

    @BindView(R.id.clear_input)
    ImageView clear_input;
    @BindView(R.id.reg_gen_code)
    TextView reg_gen_code;
    @BindView(R.id.yao)
    LinearLayout yao;

    private Timer timer;
    private int timeOfRemaining = 0;
    private SpUtils spUtils;
    private String yaoCode = "";

    //动画
    AlphaAnimation fadeInAnimation, fadeOutAnimation;

    public RegisterFragment newInstance() {
        RegisterFragment registerFragment = new RegisterFragment();
        return registerFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register_login, container, false);
        ButterKnife.bind(this, view);
        spUtils = SpUtils.getInstance("YAO");
        fadeInAnimation = new AlphaAnimation(0.0f, 1.0f);
        fadeOutAnimation = new AlphaAnimation(1.0f, 0.0f);
        fadeInAnimation.setDuration(250);
        fadeOutAnimation.setDuration(250);
        return view;
    }

    @Override
    public void onResume() {
        yaoCode = spUtils.getString("yao_code");
        Log.i("TAG", "+++++++++++++++++++" + yaoCode);
        if (!yaoCode.equals("") && lg_yao != null) {
            lg_yao.setText(yaoCode);
            yao.setVisibility(View.GONE);
            spUtils.put("yao_code", "");
        }
        super.onResume();
    }

    @OnClick({R.id.clear_input, R.id.reg_gen_code, R.id.lg_submit})
    public void sayHall(View view) {
        switch (view.getId()) {
            case R.id.clear_input:
                etUsername.setText("");
                break;
            case R.id.reg_gen_code: //获取验证码
                getVerCode();
                break;
            case R.id.lg_submit: //注册
                register(etUsername.getText().toString(), etPassword.getText().toString());
//                submit();
                break;

        }
    }

    public void setYaoCode(String phone) {
        if (lg_yao != null) {
            lg_yao.setText(phone);
        }

    }

    /**
     * 获取验证码
     */
    public void getVerCode() {
        if (timeOfRemaining == 0 && etUsername.getText().length() == 11) {

            Pattern p = Pattern.compile("^[1][3,4,5,6,7,8,9][0-9]{9}$"); // 验证手机号
            Matcher m = p.matcher(etUsername.getText().toString());
            if (!m.matches()) {
                Utils.showMsg("手机号有误！");
                return;
            }
            final AlertDialog dialog = Loading.show(getActivity(), "发送中...");
            TCApplication.getRetrofit().create(SmsService.class).send(etUsername.getText().toString(), Constants.Register)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new HttpResponseObserver<Void>() {
                        @Override
                        public void onSuccess(HttpResponse<Void> response) {
                            dialog.dismiss();
                            Utils.showMsg(response.getMsg());
                            try {
                                if (timer != null) {
                                    timer.cancel();
                                }
                            } catch (Exception e) {

                            }
                            timer = new Timer();
                            timeOfRemaining = 90;
                            reg_gen_code.setTextColor(Color.parseColor("#909090"));
                            timer.schedule(new TimerTask() {
                                @Override
                                public void run() {
                                    timeOfRemaining--;
                                    if (timeOfRemaining == 0) {
                                        timer.cancel();
                                        reg_gen_code.post(new Runnable() {
                                            @Override
                                            public void run() {
                                                reg_gen_code.setTextColor(getResources().getColor(R.color.white));
                                                reg_gen_code.setText("获取验证码");
                                                reg_gen_code.setBackground(getResources().getDrawable(R.drawable.back_bulue));
                                            }
                                        });


                                    } else {
                                        reg_gen_code.post(new Runnable() {
                                            @Override
                                            public void run() {
                                                reg_gen_code.setBackground(getResources().getDrawable(R.drawable.back_999999));
                                                reg_gen_code.setTextColor(getResources().getColor(R.color.white));
                                                reg_gen_code.setText(timeOfRemaining + "秒后重试");
                                            }
                                        });
                                    }
                                }
                            }, 0, 1000);
                        }

                        @Override
                        public void onFail(HttpResponse response) {
                            dialog.dismiss();
                            Utils.showMsg(response.getMsg());
                        }

                        @Override
                        public void onError(Throwable e) {
                            dialog.dismiss();
                            Utils.showMsg("网络异常，请稍后重试！！");

                        }
                    });
        } else {
            Utils.showMsg("手机号有误！");
        }
    }

    public void submit() {
        if (etUsername.length() < 11) {
            Utils.showMsg("你输入的手机号码不正确！！");
            return;
        }
        if (etPassword.length() < 6) {
            Utils.showMsg("你输入的密码不正确！！");
            return;
        }

        if (lg_yzm.length() != 6) {
            Utils.showMsg("你输入的验证码不正确！！");
            return;
        }
        if (etUsername.length() > 0 || etPassword.length() > 0) {
            final AlertDialog dialog = Loading.show(getActivity(), "注册中。。。");
            VerifyInfo verifyInfo = VerifyInfo.register(etUsername.getText().toString(), etPassword.getText().toString(), lg_yzm.getText().toString(), lg_yao.getText().toString());
            Log.i("TAG", lg_yao.getText().toString() + "-----------");
            TCApplication.getRetrofit()
                    .create(UserService.class)
                    .register(VerifyInfo.register(etUsername.getText().toString(),
                            etPassword.getText().toString(),
                            lg_yzm.getText().toString(), lg_yao.getText().toString()))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new HttpResponseObserver<MixUserInfo>() {

                        @Override
                        public void onSuccess(HttpResponse<MixUserInfo> response) {
                            dialog.dismiss();
                            Utils.showMsg(response.getMsg());
                            if (response.getData() != null) {
                                TCApplication.setUserInfo(response.getData());
                            }
//                            val pushService = PushServiceFactory.getCloudPushService()
//                            pushService.bindAccount(response.data.merchantTelephone,object:CommonCallback{
//                                override fun onSuccess(p0: String?) {
//                                    Log.e("====","注册账号成功")
//                                }
//
//                                override fun onFailed(p0: String?, p1: String?) {
//                                    Log.e("====","注册账号失败！："+p0+"--"+p1)
//
//                                }
//                            });
                            ConfigUtils.setUser(response.getData());
//                            setResult(Activity.RESULT_OK);
                            spUtils.put("LOGIN_STATE", "1");
//                            Intent intent05 = new Intent(getContext(), HtmlActivity.class);
//                            intent05.putExtra("url", TCGlobalConfig.WEB_URL);
//                            startActivity(intent05);
//                            getActivity().finish();
                            //TODO 注册成功后自动登录腾讯
                            Autologin(etUsername.getText().toString(),etPassword.getText().toString());
                        }

                        @Override
                        public void onFail(HttpResponse response) {
                            dialog.dismiss();
                            Utils.showMsg(response.getMsg());
                        }

                        @Override
                        public void onError(Throwable e) {
                            dialog.dismiss();
                            Utils.showMsg("网络异常，请稍后重试！！");
                        }

                    });
        }
    }

    private void Autologin(String username,String password){
        final TCUserMgr tcLoginMgr = TCUserMgr.getInstance();
        // 注册成功之后，将自动登录。
        tcLoginMgr.login(username, password, new TCHTTPMgr.Callback() {
            @Override
            public void onSuccess(JSONObject data) {

                jumpToHomeActivity(); // 登录成功，跳转到 MainActivity
            }

            @Override
            public void onFailure(int code, final String msg) {

            }
        });
    }

    private void jumpToHomeActivity () {
        Intent intent = new Intent(TCApplication.getInstance(), TCMainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        getActivity().finish();
    }

    private void register(final String username, final String password) {
        final TCUserMgr tcLoginMgr = TCUserMgr.getInstance();
        tcLoginMgr.register(username, password, new TCHTTPMgr.Callback() {
            @Override
            public void onSuccess(JSONObject data) {
                int retCode = data.optInt("code", 0);
                String message = data.optString("message", "");
                if (retCode == 200) {
                    Utils.showMsg("成功注册");
                    // 注册成功之后，将自动登录。
                    tcLoginMgr.login(username, password, new TCHTTPMgr.Callback() {
                        @Override
                        public void onSuccess(JSONObject data) {
                            Utils.showMsg("自动登录成功");
                            jumpToHomeActivity(); // 登录成功，跳转到 MainActivity
                        }

                        @Override
                        public void onFailure(int code, final String msg) {
                            Utils.showMsg("自动登录失败");
//                            showToast("自动登录失败");
//                            showOnLoadingInUIThread(false);
//                            jumpToLoginActivity(); // 登录失败，登录界面。
                        }
                    });
                    TCELKReportMgr.getInstance().reportELK(TCConstants.ELK_ACTION_REGISTER, username, 0, "注册成功", null);
                } else {
                    if (retCode == 610) {
                        message = "用户名格式错误";
                        TCELKReportMgr.getInstance().reportELK(TCConstants.ELK_ACTION_REGISTER, username, -1, message, null);
                    } else if (retCode == 611){
                        message = "密码格式错误";
                        TCELKReportMgr.getInstance().reportELK(TCConstants.ELK_ACTION_REGISTER, username, -2, message, null);
                    } else if (retCode == 612){
                        message = "用户已存在";
                        TCELKReportMgr.getInstance().reportELK(TCConstants.ELK_ACTION_REGISTER, username, -3, message, null);
                    }
                    Utils.showMsg("注册失败");
//                    showOnLoadingInUIThread(false);
                }
            }

            @Override
            public void onFailure(int code, final String msg) {
                String errorMsg = msg;
                Utils.showMsg("注册失败");
//                showOnLoadingInUIThread(false);
            }
        });
//        showOnLoading(true);
    }

}
