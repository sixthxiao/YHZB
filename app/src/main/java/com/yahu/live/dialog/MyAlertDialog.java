package com.yahu.live.dialog;

import android.content.Context;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.cy.dialog.BaseDialog;
import com.yahu.live.R;


/**
 * Created by Dun on 2018/11/28.
 */

public class MyAlertDialog extends BaseDialog implements View.OnClickListener{
    private TextView tvMessage, tvTitle;
    private Button btnCancel, btnOk;
    private View divider;
    private Object target;

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public MyAlertDialog(@NonNull Context context) {
        super(context);

        setContentView(R.layout.dialog_alert);

        this.animType(AnimInType.CENTER);
        this.canceledOnTouchOutside(true);
        initViews();
    }

    public void initViews() {
        tvMessage = findViewById(R.id.tv_message);
        tvTitle = findViewById(R.id.tv_title);
        divider = findViewById(R.id.divider);
        btnCancel = findViewById(R.id.btn_cancel);
        btnOk = findViewById(R.id.btn_ok);

        btnOk.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
    }

    public void setMessage(String text) {
        tvMessage.setText(text);
    }

    public void setMessage(Spanned spanned){
        tvMessage.setText(spanned);
    }

    public void setTitle(String text){
        if(!TextUtils.isEmpty(text)){
            tvTitle.setVisibility(View.VISIBLE);
            tvTitle.setText(text);
        }
    }

    public void setOnPositiveButton(String text) {
        btnOk.setText(text);
    }

    public void setOnPositiveButton(String text, View.OnClickListener clickListener) {
        btnOk.setText(text);
        btnOk.setOnClickListener(clickListener);
    }

    public void setOnNegativeButton(String text) {
        btnCancel.setVisibility(View.VISIBLE);
        divider.setVisibility(View.VISIBLE);
        btnCancel.setText(text);
    }

    public void setOnNegativeButton(String text, View.OnClickListener clickListener) {
        btnCancel.setVisibility(View.VISIBLE);
        divider.setVisibility(View.VISIBLE);
        btnCancel.setText(text);
        btnCancel.setOnClickListener(clickListener);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_ok:
            case R.id.btn_cancel:
                dismiss();
                break;
        }
    }
}
