package com.yahu.live.home;


import android.app.Service;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.yahu.live.R;
import com.yahu.live.adapter.FragmentLiveAttentionAdapter;
import com.yahu.live.adapter.HomeRecommendGoodsAdapter;
import com.yahu.live.base.MyPageChangeListener;
import com.yahu.live.base.NoBindFragment;
import com.yahu.live.base.SimpleDividerDecoration;
import com.yahu.live.main.videolist.utils.TCVideoInfo;
import com.yahu.live.refresh.CoolSwipeRefreshLayout;
import com.yahu.live.utils.ImageUtils;
import com.yahu.live.utils.Util;
import com.yahu.live.view.MyAdapterDelete;
import com.yahu.live.view.OnRecyclerItemClickListener;
import com.yahu.live.view.SwipeRecyclerView;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * 直播关注列表
 */

public class LiveAttentionFragment extends NoBindFragment {
    private int mImageViewArray[] = {R.mipmap.banner, R.mipmap.banner, R.mipmap.banner, R.mipmap.banner, R.mipmap.banner};

    private SwipeRecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private MyAdapterDelete adapter;
    private CoolSwipeRefreshLayout swipeRefreshLayout;
    private ItemTouchHelper mItemTouchHelper;
    private List<TCVideoInfo> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getRootView() == null) {
            setRootView(R.layout.fragment_live_attention);
            initViews();
            initData();

        }
        return getRootView();
    }

    @Override
    public void initViews() {
        super.initViews();
        swipeRefreshLayout = initSwipeRefreshLayout();
//        layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView = (SwipeRecyclerView) findViewById(R.id.rcv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerView.addItemDecoration(new SimpleDividerDecoration(getContext(), Util.dip2px(2)));

//        recyclerView.addItemDecoration(new SimpleDividerDecoration(getContext(), Utils.dip2px(8), R.color.home_recommend_divider));
//        SimpleDividerDecorationH decoration = new SimpleDividerDecorationH(getContext(), Util.dip2px(8));
//        recyclerView.addItemDecoration(decoration);
    }

    @Override
    public void initData() {
        super.initData();
        list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            TCVideoInfo tcVideoInfo = new TCVideoInfo();
            list.add(tcVideoInfo);
        }
        fillData();
    }

    @Override
    public void requestData() {
        super.requestData();

    }

    public View inflate(int id) {
        if (getContext() == null)
            return null;
        return View.inflate(getContext(), id, null);
    }

    private void fillData() {
        if (adapter == null) {
//            adapter = new FragmentLiveAttentionAdapter(list, getContext());
//            recyclerView.setAdapter(adapter);
            adapter = new MyAdapterDelete(list, getContext());
            recyclerView.setAdapter(adapter);
//            recyclerView.addOnItemTouchListener(new OnRecyclerItemClickListener(recyclerView) {
//                @Override
//                public void onItemClick(RecyclerView.ViewHolder vh) {
//
//                }
//
//                @Override
//                public void onItemLongClick(RecyclerView.ViewHolder vh) {
//                    //判断被拖拽的是否是前两个，如果不是则执行拖拽
//                    if (vh.getLayoutPosition() != 0 && vh.getLayoutPosition() != 1) {
//                        mItemTouchHelper.startDrag(vh);
//
//                        //获取系统震动服务
//                        Vibrator vib = (Vibrator) getActivity().getSystemService(Service.VIBRATOR_SERVICE);//震动70毫秒
//                        vib.vibrate(70);
//
//                    }
//                }
//            });

            mItemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.Callback() {

                /**
                 * 是否处理滑动事件 以及拖拽和滑动的方向 如果是列表类型的RecyclerView的只存在UP和DOWN，如果是网格类RecyclerView则还应该多有LEFT和RIGHT
                 * @param recyclerView
                 * @param viewHolder
                 * @return
                 */
                @Override
                public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                    if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
                        final int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN |
                                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
                        final int swipeFlags = 0;
                        return makeMovementFlags(dragFlags, swipeFlags);
                    } else {
                        final int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
                        final int swipeFlags = 0;
//                    final int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;
                        return makeMovementFlags(dragFlags, swipeFlags);
                    }
                }

                @Override
                public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                    //得到当拖拽的viewHolder的Position
                    int fromPosition = viewHolder.getAdapterPosition();
                    //拿到当前拖拽到的item的viewHolder
                    int toPosition = target.getAdapterPosition();
                    if (fromPosition < toPosition) {
                        for (int i = fromPosition; i < toPosition; i++) {
                            Collections.swap(list, i, i + 1);
                        }
                    } else {
                        for (int i = fromPosition; i > toPosition; i--) {
                            Collections.swap(list, i, i - 1);
                        }
                    }
                    adapter.notifyItemMoved(fromPosition, toPosition);
                    return true;
                }

                @Override
                public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
//                int position = viewHolder.getAdapterPosition();
//                myAdapter.notifyItemRemoved(position);
//                datas.remove(position);
                }

                /**
                 * 重写拖拽可用
                 * @return
                 */
                @Override
                public boolean isLongPressDragEnabled() {
                    return false;
                }

                /**
                 * 长按选中Item的时候开始调用
                 *
                 * @param viewHolder
                 * @param actionState
                 */
                @Override
                public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
                    if (actionState != ItemTouchHelper.ACTION_STATE_IDLE) {
                        viewHolder.itemView.setBackgroundColor(Color.LTGRAY);
                    }
                    super.onSelectedChanged(viewHolder, actionState);
                }

                /**
                 * 手指松开的时候还原
                 * @param recyclerView
                 * @param viewHolder
                 */
                @Override
                public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                    super.clearView(recyclerView, viewHolder);
                    viewHolder.itemView.setBackgroundColor(0);
                }
            });
            mItemTouchHelper.attachToRecyclerView(recyclerView);
            //左滑删除监听
            recyclerView.setRightClickListener(new SwipeRecyclerView.OnRightClickListener() {
                @Override
                public void onRightClick(int position, String id) {
                    list.remove(position);
                    adapter.notifyItemRemoved(position);
//                        adapter.notifyDataSetChanged();
                }
            });
//            configQuickAdapter(adapter, recyclerView);
        } else {
//            adapter.refresh(list, !isFirstPage());
        }

//        if (list.size() < 35) {
//            adapter.loadMoreEnd(true);
//        } else {
//            adapter.loadMoreComplete();
//        }
        stopRefreshing(swipeRefreshLayout);
    }


    private boolean isActivityDestroyed() {
        if (getActivity() == null)
            return true;
        return getActivity().isDestroyed();
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
