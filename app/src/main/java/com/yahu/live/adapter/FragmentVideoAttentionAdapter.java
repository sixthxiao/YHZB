package com.yahu.live.adapter;

import android.content.Context;
import android.view.View;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseViewHolder;
import com.yahu.live.R;
import com.yahu.live.base.BaseRecyclerAdapter;
import com.yahu.live.main.videolist.utils.TCVideoInfo;

import java.util.List;

/**
 * 直播关注列表适配器
 */

public class FragmentVideoAttentionAdapter extends BaseRecyclerAdapter<TCVideoInfo> {


    private Context mContext;

    public FragmentVideoAttentionAdapter(@Nullable List<TCVideoInfo> data, Context context) {
        super(R.layout.item_home_attention_video, data);
        mContext = context;

    }

    @Override
    public void convert(BaseViewHolder helper, TCVideoInfo item) {
        View root = helper.getView(R.id.root);
//        ImageView ivCover = helper.getView(R.id.iv);
//        helper.setText(R.id.tv_title, item.name);

//        helper.setText(R.id.tv_price, "¥" + CoolPublicMethod.getMoney(item.price));

    }
}
