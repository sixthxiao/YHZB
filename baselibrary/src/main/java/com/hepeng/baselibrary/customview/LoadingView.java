package com.hepeng.baselibrary.customview;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.hepeng.life.baselibrary.R;


/**
 * Created by Administrator on 2017/8/25.
 */

public class LoadingView extends ProgressDialog {
    private Context context;
    private int theme;
    private String text;
    private TextView textView;

    public LoadingView(Context context, int theme, String text) {
        super(context, theme);
        this.context = context;
        this.theme = theme;
        this.text = text;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        setCanceledOnTouchOutside(false);//点击屏幕true-消失，false-不消失
        setCancelable(true);//点击返回键true-消失，false-不消失
        setContentView(R.layout.loading);//loading的xml文件
        textView = findViewById(R.id.tv_load_dialog);
        textView.setText(text);
    }

    public void show(String text) {
        show();
        textView.setText(text);
    }
}

