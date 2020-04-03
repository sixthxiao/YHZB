package com.yahu.live.anchor;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yahu.live.R;


/**
 * Module:   FinishDetailDialogFragment
 * <p>
 * Function: 直播结束完成弹窗
 *
 * 统计了观看人数、点赞数量、开播时间
 */
public class FinishDetailDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Dialog mDetailDialog = new Dialog(getActivity(), R.style.dialog);
        mDetailDialog.setContentView(R.layout.dialog_publish_detail);
        mDetailDialog.setCancelable(false);

        ImageView tvCancel = (ImageView) mDetailDialog.findViewById(R.id.anchor_btn_cancel);
        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDetailDialog.dismiss();
                getActivity().finish();
            }
        });

        TextView tvDetailTime = (TextView) mDetailDialog.findViewById(R.id.tv_time);
        TextView tvDetailAdmires = (TextView) mDetailDialog.findViewById(R.id.tv_admires);
        TextView tvDetailWatchCount = (TextView) mDetailDialog.findViewById(R.id.tv_members);

        //确认则显示观看detail
        tvDetailTime.setText(getArguments().getString("time"));
        tvDetailAdmires.setText(getArguments().getString("heartCount"));
        tvDetailWatchCount.setText(getArguments().getString("totalMemberCount"));

        return mDetailDialog;
    }
}
