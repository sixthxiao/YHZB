package com.yahu.live.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.yahu.live.R;


public class BadgeView extends FrameLayout {
    ImageView image;
    TextView titleTxt;

    public BadgeView(@NonNull Context context) {
        super(context);
        init(null);
    }

    public BadgeView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public BadgeView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.badge_view, this, false);
        addView(view);
        image = view.findViewById(R.id.badge_image);
        titleTxt = view.findViewById(R.id.badge_title);
    }

    public void setTitleColor(int color) {
        this.titleTxt.setTextColor(color);
    }

    public void setImage(int resId) {
        image.setImageResource(resId);
    }

    public void setTitle(String title) {
        this.titleTxt.setText(title);
    }
}
