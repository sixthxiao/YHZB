package com.yahu.live.login;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.yahu.live.TCApplication;
import com.yahu.live.bean.MixUserInfo;
import com.yahu.live.main.BaseActivity;
import com.yahu.live.scan.QrScanAty;
import com.yahu.live.utils.ConfigUtils;
import com.yahu.live.utils.SpUtils;
import com.yahu.live.R;
import com.yahu.live.TCGlobalConfig;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 *  Module:   TCLoginActivity
 *
 *  Function: 用于登录小直播的页面
 *
 *  1. 未登陆过，输入账号密码登录
 *
 *  2. 已经登陆过，小直播获取读取缓存，并且自动登录。 详见{@link TCUserMgr}
 */
public class TCLoginActivity extends BaseActivity {


    @BindView(R.id.pager_tab)
    TabLayout tabLayout;
    @BindView(R.id.pager_pager)
    ViewPager pager;
    @BindView(R.id.sao)
    ImageView sao;
    private SpUtils spUtils;
    private LoginFragPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_me);
        ButterKnife.bind(this);
        adapter = new LoginFragPagerAdapter(this.getSupportFragmentManager());
        adapter.init(tabLayout, pager);
        spUtils = SpUtils.getInstance("YAO");
        String login_state = spUtils.getString("LOGIN_STATE");

        String code = getIntent().getStringExtra("data");
        Log.i("TAG", "0000000000000" + code);
        if (login_state != null && login_state.equals("1")) {
            if (code == null) {
//                Intent intent05 = new Intent(this, HtmlActivity.class);
//                intent05.putExtra("url", TCGlobalConfig.WEB_URL);
//                startActivity(intent05);
//                finish();
            } else {
                pager.setCurrentItem(1);
                TCApplication.setUserInfo(new MixUserInfo());
                ConfigUtils.setUser(new MixUserInfo());
            }
        } else {
            TCApplication.setUserInfo(new MixUserInfo());
            ConfigUtils.setUser(new MixUserInfo());
        }
        requestBasicPermission();

    }

    @OnClick({R.id.sao,})
    public void sayHall(View view) {
        switch (view.getId()) {
            case R.id.sao: //扫码登录
                Intent intent05 = new Intent(getApplicationContext(), QrScanAty.class);
                intent05.putExtra("url", TCGlobalConfig.WEB_URL);
                startActivityForResult(intent05, 25);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == 25 && resultCode == Activity.RESULT_OK && data != null) {
            String url = data.getStringExtra("result");
            if (url != null) {
                url = url.toLowerCase();
            }
            Log.i("TAG", url);
            if (url != null) {
                if (url.startsWith("http://m.yhjg.qianhaijifen.com/passport/register/")) {
//                    Intent i = new Intent(getApplicationContext(), LoginActivity.class);
//                    i.putExtra("data", url.replace("yhjg://register/", ""));
//                    ViewPageEvent viewPageEvent = new ViewPageEvent(url.replace("yhjg://register/", ""));
//                    EventBus.getDefault().post(new MyBusEvent(MyBusEvent.REGISTER, viewPageEvent));
//                    startActivity(i);
                    spUtils.put("yao_code",
                            url.replace("http://m.yhjg.qianhaijifen.com/passport/register/", "").trim());
                    pager.setCurrentItem(1);
                } else if (url.startsWith("http")) {

//                    Intent i = new Intent(getApplicationContext(), HtmlActivity.class);
//                    i.putExtra("url", url);
//                    i.putExtra("mode", 2);
//                    startActivity(i);
                } else {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                    dialog.setTitle("扫到的内容如下：");
                    dialog.setMessage(url);
                    dialog.setIcon(R.mipmap.ic_launcher);
                    dialog.setCancelable(true);            //点击对话框以外的区域是否让对话框消失

                    //设置正面按钮
                    dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            dialog.dismiss();
                        }
                    });
                    dialog.show();
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
