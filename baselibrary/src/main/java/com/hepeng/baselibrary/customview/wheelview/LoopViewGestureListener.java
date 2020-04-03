package com.hepeng.baselibrary.customview.wheelview;

import android.view.MotionEvent;

public final class LoopViewGestureListener extends android.view.GestureDetector.SimpleOnGestureListener {

    private final MyWheelView wheelView;


    public LoopViewGestureListener(MyWheelView wheelView) {
        this.wheelView = wheelView;
    }

    @Override
    public final boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        wheelView.scrollBy(velocityY);
        return true;
    }
}
