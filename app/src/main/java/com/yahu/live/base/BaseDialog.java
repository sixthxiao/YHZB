package com.yahu.live.base;

import android.app.Dialog;
import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

import com.yahu.live.R;


/**
 * Created by houkeihime on 2018/11/28.
 */

public class BaseDialog extends Dialog implements View.OnClickListener{
    public BaseDialog(@NonNull Context context) {
        super(context, R.style.MyDialogStyle);
        setCanceledOnTouchOutside(true);
    }

    public void initViews(){}

    @Override
    public void onClick(View view) {

    }
}
