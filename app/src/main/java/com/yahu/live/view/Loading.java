package com.yahu.live.view;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;

public class Loading {
    public static AlertDialog show(Context context, String msg){
        ProgressDialog dialog= ProgressDialog.show(context,"",msg);
        return dialog;
    }
}
