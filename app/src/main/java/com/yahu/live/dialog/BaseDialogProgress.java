package com.yahu.live.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

import com.yahu.live.R;


/**
 * Created by houkeihime on 2018/11/28.
 */

public class BaseDialogProgress extends Dialog implements View.OnClickListener{
    public BaseDialogProgress(@NonNull Context context) {
        super(context, R.style.MyDialogStyle);
        setCanceledOnTouchOutside(true);
    }

    public void initViews(){}

    @Override
    public void onClick(View view) {

    }
}
