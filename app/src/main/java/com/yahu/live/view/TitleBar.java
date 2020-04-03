package com.yahu.live.view;

import android.content.Context;
import android.content.res.TypedArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yahu.live.R;


public class TitleBar extends FrameLayout {
    LinearLayout leftHolder, rightHolder;
    TextView titleTxt,leftTxt,rightTxt;
    ImageView leftImg,rightImg;

    public TitleBar(@NonNull Context context) {
        super(context);
        init(null);
    }

    public TitleBar(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public TitleBar(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        float height= TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,56f,getContext().getResources().getDisplayMetrics());
        super.onMeasure(widthMeasureSpec, MeasureSpec.makeMeasureSpec((int) height, MeasureSpec.getMode(heightMeasureSpec)));
    }

    public void init(@Nullable AttributeSet attrs){
        Context context=getContext();
        View v= LayoutInflater.from(context).inflate(R.layout.title_bar,this,false);
        addView(v);
        leftHolder = (LinearLayout) v.findViewById(R.id.tb_left);
        rightHolder = (LinearLayout) v.findViewById(R.id.tb_right);
        titleTxt= (TextView) v.findViewById(R.id.tb_title);
        leftImg= (ImageView) v.findViewById(R.id.tb_l_img);
        leftTxt= (TextView) v.findViewById(R.id.tb_l_txt);
        rightImg= (ImageView) v.findViewById(R.id.tb_r_img);
        rightTxt= (TextView) v.findViewById(R.id.tb_r_txt);

        TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.TitleBarStyle);
        int left =ta.getResourceId(R.styleable.TitleBarStyle_tbLeftIcon, R.drawable.ic_baseline_chevron_left_30);
        if(left>0){
            setLeftImageResouce(left);
        }
        int right =ta.getResourceId(R.styleable.TitleBarStyle_tbRightIcon,-1);
        if(right>0){
            setRightImageResouce(right);
        }
        String leftText=ta.getString(R.styleable.TitleBarStyle_tbLeftText);
        if(leftText!=null&&leftText.length()>0){
            setLeftText(leftText);
        }
        String rightText=ta.getString(R.styleable.TitleBarStyle_tbRightText);
        if(rightText!=null&&rightText.length()>0){
            setRightText(rightText);
        }
        String title=ta.getString(R.styleable.TitleBarStyle_tbTitle);
        titleTxt.setText(title);


    }
    public void setTitleColor(int color){
        titleTxt.setTextColor(color);
    }
    public LinearLayout getLeftHolder() {
        return leftHolder;
    }

    public LinearLayout getRightHolder() {
        return rightHolder;
    }

    public TextView getTitleTxt() {
        return titleTxt;
    }
    public void setTitle(String title){
        titleTxt.setText(title);
    }
    public void setLeftImageResouce(int resId){
        leftImg.setImageResource(resId);
        leftImg.setVisibility(VISIBLE);
        leftTxt.setVisibility(GONE);
    }
    public void setRightImageResouce(int resId) {
        rightImg.setImageResource(resId);
        rightImg.setVisibility(VISIBLE);
        rightTxt.setVisibility(GONE);
    }
    public void setLeftText(String text){
        leftImg.setVisibility(GONE);
        leftTxt.setText(text);
        leftTxt.setVisibility(VISIBLE);
    }
    public void setRightText(String text){
        rightImg.setVisibility(GONE);
        rightTxt.setText(text);
        rightTxt.setVisibility(VISIBLE);
    }
    public void setLeftOnClickListener(OnClickListener leftOnClickListener) {
        leftHolder.setOnClickListener(leftOnClickListener);
    }


    public void setRightOnClickListener(OnClickListener rightOnClickListener) {
        rightHolder.setOnClickListener(rightOnClickListener);
    }
}
