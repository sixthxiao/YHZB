package com.hepeng.baselibrary.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hepeng.life.baselibrary.R;

public class NumberKeyboardView extends LinearLayout implements View.OnClickListener {

    private TextView tv_confirm;

    private InputReceiver inputReceiver;

    private boolean point_enabled = true;

    public NumberKeyboardView(Context context) {
        this(context, null, 0);
    }

    public NumberKeyboardView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NumberKeyboardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.number_keyboard_layout, this);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.NumberKeyboardView);
        point_enabled = array.getBoolean(R.styleable.NumberKeyboardView_point_enabled, true);
        //记得使用完销毁
        array.recycle();
        initView();
    }

    private void initView() {
        ImageView iv_point = findViewById(R.id.iv_point);
        tv_confirm = findViewById(R.id.tv_confirm);
        if (point_enabled) {
            iv_point.setEnabled(true);
            iv_point.setVisibility(VISIBLE);
        } else {
            iv_point.setEnabled(false);
            iv_point.setVisibility(INVISIBLE);
        }
        findViewById(R.id.tv_1).setOnClickListener(this);
        findViewById(R.id.tv_2).setOnClickListener(this);
        findViewById(R.id.tv_3).setOnClickListener(this);
        findViewById(R.id.tv_4).setOnClickListener(this);
        findViewById(R.id.tv_5).setOnClickListener(this);
        findViewById(R.id.tv_6).setOnClickListener(this);
        findViewById(R.id.tv_7).setOnClickListener(this);
        findViewById(R.id.tv_8).setOnClickListener(this);
        findViewById(R.id.tv_9).setOnClickListener(this);
        findViewById(R.id.tv_0).setOnClickListener(this);
        iv_point.setOnClickListener(this);
        findViewById(R.id.iv_delate).setOnClickListener(this);
        findViewById(R.id.iv_shrink).setOnClickListener(this);
        tv_confirm.setOnClickListener(this);
    }

    public void setConfirmBackground(String color) {
        tv_confirm.setBackgroundColor(Color.parseColor(color));
    }

    public void setConfirmEnabled(boolean boo) {
        tv_confirm.setEnabled(boo);
    }

    @Override
    public void onClick(View v) {
        String num = (String) v.getTag();
        if (num.equals("-1")) {
            inputReceiver.backspace();
        } else if (num.equals("-2")) {
            setVisibility(GONE);
            inputReceiver.shrinkKeyboard();
        } else if (num.equals("ok")) {
            inputReceiver.confirm();
        } else {
            inputReceiver.receive(num);
        }
    }


    /**
     * 设置接收器
     *
     * @param receiver
     */
    public void setInputReceiver(InputReceiver receiver) {
        this.inputReceiver = receiver;
    }

    /**
     * 输入接收器
     */
    public interface InputReceiver {
        void receive(String num);

        void confirm();

        void backspace();

        void shrinkKeyboard();
    }
}
