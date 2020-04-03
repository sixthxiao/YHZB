package com.yahu.live.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.yahu.live.R;


public class SimpleDividerDecorationH extends RecyclerView.ItemDecoration {
    private int space = 0;
    private int pos;
    private Paint dividerPaint;
    private Context mContext;

    public SimpleDividerDecorationH(Context context, int space) {
        this.mContext = context;
        dividerPaint = new Paint();
        dividerPaint.setColor(context.getResources().getColor(R.color.new_background_color));
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

        outRect.bottom = space;
        StaggeredGridLayoutManager.LayoutParams params = (StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams();
        //该View在整个RecyclerView中位置。
//        pos = parent.getChildAdapterPosition(view);
        //解决瀑布流分割线不一样宽问题getSpanIndex()
        pos = params.getSpanIndex();

        //取模

        //两列的左边一列
        if (pos % 2 == 0) {
//            outRect.left = space;
            outRect.right = space / 2;
        }

        //两列的右边一列
        if (pos % 2 == 1 ) {
            outRect.left = space / 2;
//            outRect.right = space;
        }
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        for (int i = 0; i < parent.getChildCount(); i++) {
            View child = parent.getChildAt(i);//这里应该用这个方法获取child，而onDrawOver不一样
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) child.getLayoutParams();
            int position = layoutParams.getViewAdapterPosition();
            if (position == 0) {
                c.drawColor(mContext.getResources().getColor(R.color.white));
            }else {
                c.drawColor(mContext.getResources().getColor(R.color.new_background_color));
            }
        }



    }
}

