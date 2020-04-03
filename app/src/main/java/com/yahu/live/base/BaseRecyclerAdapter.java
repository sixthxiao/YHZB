package com.yahu.live.base;


import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by Dun on 2018/11/28.
 */

public abstract class BaseRecyclerAdapter<T> extends BaseQuickAdapter<T, BaseViewHolder> {

    public BaseRecyclerAdapter(int layoutResId, @Nullable List<T> data) {
        super(layoutResId, data);
    }

    @Override
    public abstract void convert(BaseViewHolder helper, T item);

    public void refresh(List<T> data, boolean append) {
        if (!append) {
            setNewData(data);
        } else {
            addData(data);
        }
    }

    public void append(T data) {
        addData(data);
    }

    public int indexOf(T item) {
        return getData().indexOf(item);
    }

}
