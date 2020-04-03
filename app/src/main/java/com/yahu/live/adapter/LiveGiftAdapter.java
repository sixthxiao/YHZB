package com.yahu.live.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseViewHolder;
import com.yahu.live.R;
import com.yahu.live.base.BaseRecyclerAdapter;
import com.yahu.live.bean.GiftBean;
import com.yahu.live.main.videolist.utils.TCVideoInfo;

import java.util.List;

/**
 * 礼物适配器
 */

public class LiveGiftAdapter extends BaseAdapter {


    private List<GiftBean> provinceBeanList;
    private LayoutInflater layoutInflater;

    public LiveGiftAdapter(Context context, List<GiftBean> provinceBeanList) {
        this.provinceBeanList = provinceBeanList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return provinceBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return provinceBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_gift_live, null);
            holder = new ViewHolder();
            holder.title = (TextView) convertView.findViewById(R.id.title);
            holder.value = (TextView) convertView.findViewById(R.id.value);
            holder.image = (ImageView) convertView.findViewById(R.id.image);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        GiftBean provinceBean = provinceBeanList.get(position);
        if (provinceBean != null) {
            holder.title.setText(provinceBean.getTitle());
            holder.value.setText(provinceBean.getValue());
            holder.image.setImageResource(provinceBean.getImage());
        }
        return convertView;
    }

    class ViewHolder {
        TextView title;
        TextView value;
        ImageView image;
    }


}
