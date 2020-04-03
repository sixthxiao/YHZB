package com.yahu.live.login;


import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.InputType;
import android.text.Selection;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.yahu.liteav.demo.lvb.liveroom.roomutil.misc.NameGenerator;
import com.yahu.live.BuildConfig;
import com.yahu.live.TCApplication;
import com.yahu.live.TCGlobalConfig;
import com.yahu.live.bean.MixUserInfo;
import com.yahu.live.bean.VerifyInfo;
import com.yahu.live.common.net.TCHTTPMgr;
import com.yahu.live.common.utils.TCUtils;
import com.yahu.live.main.TCMainActivity;
import com.yahu.live.retrofit.HttpResponse;
import com.yahu.live.retrofit.HttpResponseObserver;
import com.yahu.live.retrofit.UserService;
import com.yahu.live.utils.ConfigUtils;
import com.yahu.live.utils.SpUtils;
import com.yahu.live.utils.Utils;
import com.yahu.live.view.Loading;
import com.yahu.live.R;

import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 登录
 */
public class LoginFragment extends Fragment {
    @BindView(R.id.lg_pwd_type)
    ImageView lg_pwd_type;
    @BindView(R.id.lg_pwd)
    EditText etPassword;
    @BindView(R.id.lg_usr)
    EditText etUsername;
    @BindView(R.id.clear_input)
    ImageView clear_input;
    @BindView(R.id.lg_submit)
    Button btnLogin;

    private SpUtils spUtils;

    public LoginFragment newInstance() {
        LoginFragment loginFragment = new LoginFragment();
        return loginFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);
        spUtils = SpUtils.getInstance("YAO");
        //检测是否存在缓存
        checkLogin();
        return view;
    }

    @OnClick({R.id.lg_pwd_type, R.id.clear_input, R.id.lg_submit, R.id.no_password})
    public void sayHall(View view) {
        switch (view.getId()) {
            case R.id.lg_submit: //登录
                submit();
                attemptNormalLogin(etUsername.getText().toString(), etPassword.getText().toString());
                break;
            case R.id.no_password: //忘记密码
//                Intent intent05 = new Intent(getActivity().getApplicationContext(), HtmlActivity.class);
//                intent05.putExtra("url", "http://m.yhjg.qianhaijifen.com/Passport/Forget");
//                startActivity(intent05);
                break;
            case R.id.clear_input:
                etUsername.setText("");
                break;
            case R.id.lg_pwd_type:
                if (etPassword.getInputType() != InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) {
                    etPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    lg_pwd_type.setImageResource(R.drawable.ic_remove_eye_dark);
                    etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    etPassword.setInputType(InputType.TYPE_TEXT_VARIATION_WEB_PASSWORD);
                    lg_pwd_type.setImageResource(R.drawable.ic_remove_eye);
                    etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                etPassword.postInvalidate();
                //防止每次切换密码可见与不可见后光标会回到行首的情况
                Editable text = etPassword.getText();
                if (text.length() > 0) {
                    Selection.setSelection(text, text.length());
                }
                break;

        }
    }

    /**
     * 登录自己的服务器
     */
    public void submit() {
        if (etUsername.length() < 5) {
            Utils.showMsg("你输入的手机号码不正确!");
            return;
        }
        if (etPassword.length() < 6) {
            Utils.showMsg("你输入的密码不正确!");
            return;
        }
        if (etUsername.length() > 0 || etPassword.length() > 0) {
            final AlertDialog dialog = Loading.show(getActivity(), "登录中。。。");
            TCApplication.getRetrofit().create(UserService.class).login(VerifyInfo.login(etUsername.getText().toString(), etPassword.getText().toString()))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new HttpResponseObserver<MixUserInfo>() {

                        @Override
                        public void onSuccess(HttpResponse<MixUserInfo> response) {
                            dialog.dismiss();
                            Toast.makeText(getActivity(), response.getMsg(), Toast.LENGTH_SHORT).show();
                            if (response.getData() != null) {
                                TCApplication.setUserInfo(response.getData());
                            }
//                            val pushService = PushServiceFactory.getCloudPushService();
                            ConfigUtils.setUser(response.getData());
//                            getActivity.(Activity.RESULT_OK);
                            spUtils.put("LOGIN_STATE", "1");
//                            Intent intent05 = new Intent(getContext(), HtmlActivity.class);
//                            intent05.putExtra("url", BuildConfig.WEB_URL);
//                            startActivity(intent05);
//                            getActivity().finish();
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

    /**
     * 用户名密码登录
     *
     * @param username 用户名
     * @param password 密码
     */
    public void attemptNormalLogin(String username, String password) {
        if (TCUtils.isUsernameVaild(username)) {
            if (TCUtils.isPasswordValid(password)) {
                if (TCUtils.isNetworkAvailable(TCApplication.getInstance())) {
                    login(username, password);
                } else {
                    Toast.makeText(TCApplication.getInstance(), "当前无网络连接", Toast.LENGTH_SHORT).show();
                }
            } else {
                showPasswordError("密码长度应为8-16位");
            }
        } else {
            showLoginError("用户名不符合规范");
        }
    }

    private void checkLogin() {
        if (TCUtils.isNetworkAvailable(TCApplication.getInstance())) {
            //返回true表示存在本地缓存，进行登录操作，显示loadingFragment
            if (TCUserMgr.getInstance().hasUser()) {

                TCUserMgr.getInstance().autoLogin(new TCHTTPMgr.Callback() {
                    @Override
                    public void onSuccess(JSONObject data) {
                        jumpToHomeActivity();
                    }

                    @Override
                    public void onFailure(int code, String msg) {
//                        showToast("自动登录失败");

                    }
                });
            } else if (TextUtils.isEmpty(TCGlobalConfig.APP_SVR_URL)) {
                jumpToHomeActivity();
//                if (TCUtils.isNetworkAvailable(TCApplication.getInstance())) {
//                    login(NameGenerator.getRandomUserID(), "");
//                }
            }
        }
    }


    /**
     * 登录成功后被调用，跳转至TCMainActivity
     */
    private void jumpToHomeActivity() {
        Intent intent = new Intent(TCApplication.getInstance(), TCMainActivity.class);
        startActivity(intent);
        getActivity().finish();
    }

    private void login(String username, String password) {
        final TCUserMgr tcLoginMgr = TCUserMgr.getInstance();
        tcLoginMgr.login(username, password, new TCHTTPMgr.Callback() {
            @Override
            public void onSuccess(JSONObject data) {

                jumpToHomeActivity();
            }

            @Override
            public void onFailure(int code, final String msg) {
                Utils.showMsg("登录失败！");
            }
        });
    }

    private void showLoginError(String errorString) {
        etUsername.setError(errorString);
    }

    private void showPasswordError(String errorString) {
        etPassword.setError(errorString);
    }
}
