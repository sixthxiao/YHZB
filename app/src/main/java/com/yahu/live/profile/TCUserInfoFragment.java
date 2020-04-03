package com.yahu.live.profile;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tencent.imsdk.TIMManager;
import com.yahu.live.R;
import com.yahu.live.TCApplication;
import com.yahu.live.TCGlobalConfig;
import com.yahu.live.anchor.prepare.TCAnchorPrepareActivity;
import com.yahu.live.common.net.TCHTTPMgr;
import com.yahu.live.common.utils.TCUtils;
import com.yahu.live.login.TCLoginActivity;
import com.yahu.live.login.TCUserMgr;
import com.yahu.live.profile.view.TCLineControllerView;
import com.tencent.rtmp.TXLiveBase;

import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Module:   TCUserInfoFragment
 * <p>
 * Function: 用户资料展示页面
 **/
public class TCUserInfoFragment extends Fragment implements View.OnClickListener {


    private static final String TAG = "TCUserInfoFragment";
    private ImageView mAvatar;
    private TextView mNickName;
    private TextView mUserId;
    private Button mBtnLogout;
    private RelativeLayout rl_user_info;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_info, container, false);
        ButterKnife.bind(this, view);
        mAvatar = (ImageView) view.findViewById(R.id.iv_ui_head);
        mNickName = (TextView) view.findViewById(R.id.tv_ui_nickname);
        mUserId = (TextView) view.findViewById(R.id.tv_ui_user_id);
        rl_user_info = (RelativeLayout) view.findViewById(R.id.rl_user_info);
        mBtnLogout = (Button) view.findViewById(R.id.lcv_ui_logout);
        rl_user_info.setOnClickListener(this);
        mBtnLogout.setOnClickListener(this);
        mNickName.setText(TCUserMgr.getInstance().getNickname());
        mUserId.setText("ID:" + TCUserMgr.getInstance().getUserId());
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        //页面展示之前，更新一下用户信息
        TCUserMgr.getInstance().fetchUserInfo(new TCHTTPMgr.Callback() {
            @Override
            public void onSuccess(JSONObject data) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mNickName.setText(TCUserMgr.getInstance().getNickname());
                        mUserId.setText("ID:" + TCUserMgr.getInstance().getUserId());
                        TCUtils.showPicWithUrl(getActivity(), mAvatar, TCUserMgr.getInstance().getAvatar(), R.drawable.face);
                    }
                });
            }

            @Override
            public void onFailure(int code, final String msg) {

            }
        });
    }


    @OnClick({R.id.start_live})
    public void sayHall(View view) {
        switch (view.getId()) {
            case R.id.start_live: //开始直播
                startActivity(new Intent(TCApplication.getInstance(), TCAnchorPrepareActivity.class));
                break;

        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_user_info: //设置用户信息

                Intent i = new Intent(getContext(), TCEditUseInfoActivity.class);
                startActivity(i);
                break;
            case R.id.lcv_ui_logout: //退出登录
                TCUserMgr.getInstance().logout();
                Intent intent = new Intent(getContext(), TCLoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                getActivity().finish();
                break;
        }
    }

    private void showTechnicalSupport() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        AlertDialog alertDialog = builder.setCancelable(false).setMessage(R.string.follow_and_send_msg_to_public_number)
                .setPositiveButton(R.string.btn_sure, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create();
        alertDialog.show();
    }

    /**
     * 显示 APP SDK 的版本信息
     */
    private void showSDKVersion() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.ConfirmDialogStyle);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setMessage("APP : " + getAppVersion() + "\r\n"
                + "RTMP SDK: " + TXLiveBase.getSDKVersionStr() + "\r\n"
                + "IM SDK: " + TIMManager.getInstance().getVersion()
        );
        builder.show();
    }

    /**
     * 获取APP版本
     *
     * @return APP版本
     */
    private String getAppVersion() {
        PackageManager packageManager = getActivity().getPackageManager();
        PackageInfo packInfo;
        String version = "";
        try {
            packInfo = packageManager.getPackageInfo(getActivity().getPackageName(), 0);
            version = packInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return version;
    }
}
