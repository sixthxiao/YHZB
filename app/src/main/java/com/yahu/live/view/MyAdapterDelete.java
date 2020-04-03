package com.yahu.live.view;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.yahu.live.R;
import com.yahu.live.bean.Subject;
import com.yahu.live.main.videolist.utils.TCVideoInfo;

import java.util.List;


/**
 * 左滑删除适配器
 */

public class MyAdapterDelete extends RecyclerView.Adapter<MyAdapterDelete.ViewHolder> {

    private List<TCVideoInfo> datas;
    private Context mContext;
    private LayoutInflater mLiLayoutInflater;

    public MyAdapterDelete(List<TCVideoInfo> datas, Context context) {
        this.datas = datas;
        this.mContext = context;
        this.mLiLayoutInflater = LayoutInflater.from(mContext);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        return new ViewHolder(mLiLayoutInflater.inflate(R.layout.item_linear, parent, false));
        return new ViewHolder(mLiLayoutInflater.inflate(R.layout.item_home_attention, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//        holder.tv_title.setText(datas.get(position).getTitle());
//        holder.img.setImageResource(datas.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title;
        ImageView img;
        LinearLayout ll_item, ll_hidden;

        public ViewHolder(View itemView) {
            super(itemView);
//            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
//            img = (ImageView) itemView.findViewById(R.id.img);
//
            ll_item = (LinearLayout) itemView.findViewById(R.id.ll_item);
            ll_hidden = (LinearLayout) itemView.findViewById(R.id.ll_hidden);
        }
    }
}
