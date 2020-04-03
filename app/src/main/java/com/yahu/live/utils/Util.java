package com.yahu.live.utils;

import android.Manifest;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.DownloadManager;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import com.yahu.live.TCApplication;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.IntBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import javax.microedition.khronos.opengles.GL10;


/**
 * Created by Dun on 2018/11/28.
 */

public class Util {
    private static Toast toast;

    public static Context getContext() {
        return TCApplication.getInstance();
    }


    public static Drawable getDrawable(int res) {
        return getContext().getResources().getDrawable(res);
    }

    public static Drawable getBoundedDrawable(int res) {
        Drawable drawable = getDrawable(res);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        return drawable;
    }

    public static int dip2px(float dip) {
        float density = getContext().getResources().getDisplayMetrics().density;
        return (int) (dip * density + 0.5f);
    }



    private static WindowManager getWindowManager() {
        return (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
    }

    public static int getScreenWidth() {
        return getWindowManager().getDefaultDisplay().getWidth();
    }

    public static int getScreenHeight() {
        return getWindowManager().getDefaultDisplay().getHeight();
    }

    public static int getColor(int res) {
        return getContext().getResources().getColor(res);
    }

    public static ColorStateList getColorState(int res) {
        return getContext().getResources().getColorStateList(res);
    }


    public static void hiddenSoftBorad(Context context) {
        try {
            ((InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(
                    ((Activity) context).getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        } catch (Exception e) {

        }
    }

    public static String getString(int res) {
        return getContext().getResources().getString(res);
    }

    public static String[] getStringArray(int res) {
        return getContext().getResources().getStringArray(res);
    }

    public static int getDrawableResourceIdByName(String name) {
        int id = getContext().getResources().getIdentifier(name, "drawable", getContext().getPackageName());
        return id;
    }
    /**
     * 转换时间戳
     * @param dateString
     * @param pattern
     * @return
     */
    public static long getStringToDate(String dateString, String pattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        Date date = new Date();
        try{
            date = dateFormat.parse(dateString);
        } catch(ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date.getTime();
    }


    /**
     * 把毫秒数转换成时分秒
     * @param millis
     * @return
     */
    public static String millisToStringShort(long millis) {
        StringBuilder strBuilder = new StringBuilder();
        long temp = millis;
        long hper = 60 * 60 * 1000;
        long mper = 60 * 1000;
        long sper = 1000;
        if (temp / hper > 0) {
            strBuilder.append(temp / hper).append("时");
        }
        temp = temp % hper;

        if (temp / mper > 0) {
            strBuilder.append(temp / mper).append("分");
        }
        temp = temp % mper;
        if (temp / sper > 0) {
            strBuilder.append(temp / sper).append("秒");
        }
        return strBuilder.toString();
    }



    public static void copyText(String text) {
        ClipboardManager cm = (ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData mClipData = ClipData.newPlainText("Label", text);
        cm.setPrimaryClip(mClipData);

    }

    public static boolean isStringEmpty(String s) {
        if (s == null || "null".equals(s))
            return true;
        return TextUtils.isEmpty(s);
    }

    public static int sp2px(float spValue) {
        final float fontScale = getContext().getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    private static Random random = new Random();

    public static String getRandomName() {
        StringBuilder stringBuilder = new StringBuilder("Dt");
        for (int i = 0; i < 8; i++) {
            stringBuilder.append(random.nextInt(10));
        }
        return stringBuilder.toString();
    }

    public static String getVersionName() {
        PackageManager manager = getContext().getPackageManager();
        try {
            PackageInfo info = manager.getPackageInfo(getContext().getPackageName(), 0);
            return info.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void installApk(Context context, long downloadApkId) {
        DownloadManager dManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        Uri downloadFileUri = dManager.getUriForDownloadedFile(downloadApkId);
        if (downloadFileUri != null) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setDataAndType(downloadFileUri, "application/vnd.android.package-archive");
            context.startActivity(intent);
        } else {
            Log.e("DownloadManager", "download error");
        }
    }



    public static String md5(String string) {
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(string.getBytes());
            StringBuilder result = new StringBuilder();
            for (byte b : bytes) {
                String temp = Integer.toHexString(b & 0xff);
                if (temp.length() == 1) {
                    temp = "0" + temp;
                }
                result.append(temp);
            }
            return result.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String getMobileInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append(Build.MANUFACTURER + " ");
            stringBuilder.append(Build.MODEL + " ");
            stringBuilder.append(Build.BRAND);
        } catch (Exception e) {

        }
        return stringBuilder.toString();
    }



    public static void toMarket(Context context, String appPkg, String marketPkg) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.APP_MARKET");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }


    public static Bitmap SavePixels(int x, int y, int w, int h, GL10 gl) {
        int b[] = new int[w * (y + h)];
        int bt[] = new int[w * h];
        IntBuffer ib = IntBuffer.wrap(b);
        ib.position(0);
        gl.glReadPixels(x, 0, w, y + h, GL10.GL_RGBA, GL10.GL_UNSIGNED_BYTE, ib);

        for (int i = 0, k = 0; i < h; i++, k++) {//remember, that OpenGL bitmap is incompatible with Android bitmap
            //and so, some correction need.
            for (int j = 0; j < w; j++) {
                int pix = b[i * w + j];
                int pb = (pix >> 16) & 0xff;
                int pr = (pix << 16) & 0x00ff0000;
                int pix1 = (pix & 0xff00ff00) | pr | pb;
                bt[(h - k - 1) * w + j] = pix1;
            }
        }


        Bitmap sb = Bitmap.createBitmap(bt, w, h, Bitmap.Config.ARGB_8888);
        return sb;
    }

    public static File saveBitmapToFile(Bitmap bitmap) {
        String mPath = Environment.getExternalStorageDirectory().toString() + "/" + UUID.randomUUID() + ".png";
        File imgFile = new File(mPath);
        OutputStream os = null;
        try {
            os = new FileOutputStream(imgFile);
            bitmap.compress(Bitmap.CompressFormat.PNG, 70, os);
            os.flush();
            os.close();

            getContext().sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(imgFile)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return imgFile;
    }


    public static boolean isAppForeground() {
        ActivityManager activityManager = (ActivityManager) getContext().getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> tasks = activityManager.getRunningTasks(1);
        if (tasks != null && !tasks.isEmpty()) {
            ComponentName componentName = tasks.get(0).topActivity;
            return componentName != null && componentName.getPackageName().equals("com.xindanci.zhubao");

        }
        return false;
    }

    public static View inflate(Context context, int layoutRes) {
        return View.inflate(context, layoutRes, null);
    }



}
