package com.yahu.live.base;

import com.chad.library.adapter.base.loadmore.LoadMoreView;
import com.yahu.live.R;

/**
 * Created by Dun on 2018/12/20.
 */

public class MyLoadMoreView extends LoadMoreView {

    @Override
    public int getLayoutId() {
        return R.layout.layout_load_more;
    }

    @Override
    protected int getLoadingViewId() {
        return R.id.load_more;
    }

    @Override
    protected int getLoadFailViewId() {
        return R.id.load_fail;
    }

    @Override
    protected int getLoadEndViewId() {
        return R.id.load_end;
    }
}
