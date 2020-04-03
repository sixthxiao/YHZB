package com.hepeng.baselibrary.utils;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;

import com.hepeng.baselibrary.base.BaseApplication;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2018/4/20.
 */

public class FileUtil {
    private final static byte[] gSyncCode = new byte[0];

    /**
     * delete file or directory
     * <li>if path is null or empty, return true</li>
     * <li>if path not exist, return true</li>
     * <li>if path exist, delete recursion. return true</li>
     */
    public static boolean deleteFile(String path) {
        synchronized (gSyncCode) {
            if (TextUtils.isEmpty(path)) {
                return true;
            }

            File file = new File(path);
            if (!file.exists()) {
                return true;
            }
            if (file.isFile()) {
                return file.delete();
            }
            if (!file.isDirectory()) {
                return false;
            }
            File[] filesList = file.listFiles();

            if (filesList != null) {
                for (File f : filesList) {
                    if (f.isFile()) {
                        f.delete();
                    } else if (f.isDirectory()) {
                        deleteFile(f.getAbsolutePath());
                    }
                }
            }

            return file.delete();
        }
    }

    //保存图片
    public static void saveBitmap(ImageView view, String filePath) {
        Drawable drawable = view.getDrawable();
        if (drawable == null) {
            return;
        }
        FileOutputStream outStream = null;
        File file = new File(filePath);
        if (file.isDirectory()) {//如果是目录不允许保存
            return;
        }
        if (!file.exists()) {
            File dir = file.getParentFile();
            if (!dir.exists()) {
                dir.mkdirs();
            }

            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            outStream = new FileOutputStream(file);
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outStream);
            outStream.flush();
            ToastUtil.showToast("保存成功");
        } catch (IOException e) {
            ToastUtil.showToast("保存失败");
            e.printStackTrace();
        } finally {
            try {
                if (outStream != null) {
                    outStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        BaseApplication.appContext.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + filePath)));
    }
}
