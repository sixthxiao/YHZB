package com.yahu.live.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yahu.live.R;
import com.yahu.live.base.BaseRecyclerAdapter;
import com.yahu.live.main.videolist.utils.TCVideoInfo;
import com.yahu.live.utils.Util;
import com.yahu.live.utils.Utils;

import java.util.List;

/**
 * Created by Dun on 2018/12/26.
 */

public class HomeRecommendGoodsAdapter extends BaseRecyclerAdapter<TCVideoInfo> {


    private Context mContext;

    public HomeRecommendGoodsAdapter(@Nullable List<TCVideoInfo> data, Context context) {
        super(R.layout.item_home_recommend_goods, data);
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
