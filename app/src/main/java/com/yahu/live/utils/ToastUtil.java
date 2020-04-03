package com.yahu.live.utils;

import android.os.Looper;
import android.view.Gravity;
import android.widget.Toast;

import com.yahu.live.TCApplication;


/**
 * Created by Administrator on 2018/4/8.
 */

public class ToastUtil {
    private static Toast toast;

    public static void showToast(String text) {
        try {
            if (toast == null) {
                toast = Toast.makeText(TCApplication.getInstance(), text, Toast.LENGTH_SHORT);
            } else {
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.setText(text);
            }
            toast.show();
        } catch (Exception e) {
            //解决在子线程中调用Toast的异常情况处理
            Looper.prepare();
            Toast toast1 = Toast.makeText(TCApplication.getInstance(), text, Toast.LENGTH_SHORT);
            toast1.setGravity(Gravity.CENTER, 0, 0);
            toast1.setText(text);
            toast1.show();
            Looper.loop();
        }
    }

    public static void showToastBot(String text) {
        try {
            if (toast == null) {
                toast = Toast.makeText(TCApplication.getInstance(), text, Toast.LENGTH_SHORT);
            } else {
                toast.setGravity(Gravity.BOTTOM, 0, 30);
                toast.setText(text);
            }
            toast.show();
        } catch (Exception e) {
            //解决在子线程中调用Toast的异常情况处理
            Looper.prepare();
            Toast toast2 = Toast.makeText(TCApplication.getInstance(), text, Toast.LENGTH_SHORT);
            toast2.setGravity(Gravity.BOTTOM, 0, 30);
            toast2.setText(text);
            toast2.show();
            Looper.loop();
        }
    }
}
