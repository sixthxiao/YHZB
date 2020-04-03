package com.yahu.live.profile.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.yahu.live.R;
import com.yahu.live.common.utils.TCConstants;
import com.yahu.live.common.utils.TCUtils;

/**
 * Module:   TCLineControllerView
 *
 * Function: 设置等页面条状控制或显示信息的控件
 *
 **/
public class TCLineControllerView extends LinearLayout {

    private String name;
    private boolean isBottom;
    private String content;
    private boolean canNav;
    private boolean isSwitch;

    public TCLineControllerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.view_line_controller, this);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TC_line_view, 0, 0);
        try {
            name = ta.getString(R.styleable.TC_line_view_name);
            content = ta.getString(R.styleable.TC_line_view_content);
            isBottom = ta.getBoolean(R.styleable.TC_line_view_isBottom, false);
            canNav = ta.getBoolean(R.styleable.TC_line_view_canNav,false);
            isSwitch = ta.getBoolean(R.styleable.TC_line_view_isSwitch,false);
            setUpView();
        } finally {
            ta.recycle();
        }
    }


    private void setUpView(){
        TextView tvName = (TextView) findViewById(R.id.ctl_name);
        tvName.setText(name);
        TextView tvContent = (TextView) findViewById(R.id.ctl_content);
        tvContent.setText(TCUtils.getLimitString(content, TCConstants.USER_INFO_MAXLEN));
        View bottomLine = findViewById(R.id.ctl_bottomLine);
        bottomLine.setVisibility(isBottom ? VISIBLE : GONE);
        ImageView navArrow = (ImageView) findViewById(R.id.ctl_rightArrow);
        navArrow.setVisibility(canNav ? VISIBLE : GONE);
        LinearLayout contentPanel = (LinearLayout) findViewById(R.id.ctl_contentText);
        contentPanel.setVisibility(isSwitch ? GONE : VISIBLE);
        Switch switchPanel = (Switch) findViewById(R.id.ctl_btnSwitch);
        switchPanel.setVisibility(isSwitch?VISIBLE:GONE);
    }


    /**
     * 设置文字内容
     *
     * @param content 内容
     */
    public void setContent(String content){
        this.content = content;
        TextView tvContent = (TextView) findViewById(R.id.ctl_content);
        tvContent.setText(TCUtils.getLimitString(content, TCConstants.USER_INFO_MAXLEN));
    }

    /**
     * 获取内容
     *
     */
    public String getContent() {
        TextView tvContent = (TextView) findViewById(R.id.ctl_content);
        return tvContent.getText().toString();
    }
}
