package com.yahu.live.dialog;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.yahu.live.R;
import com.yahu.live.utils.Util;


/**
 * Created by Dun on 2018/11/28.
 */

public class MyProgressDialog extends BaseDialogProgress {

    public MyProgressDialog(@NonNull Context context) {
        super(context);

        int size = Util.dip2px(50);
        View rootView = Util.inflate(context, R.layout.dialog_progress);
        setContentView(rootView, new ViewGroup.LayoutParams(size, size));

        getWindow().setBackgroundDrawableResource(R.drawable.shape_dialog_progress);
    }
}
