package com.yahu.live.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.os.Build;
import android.provider.MediaStore;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.yahu.live.R;

import java.util.HashMap;

/**
 * Created by Dun on 2018/11/28.
 */

public class ImageUtils {
    private static final RequestOptions normalOption = new RequestOptions();
    private static final RequestOptions fadeOption = new RequestOptions();

    public static void loadImage(Object url, ImageView imageView) {
        try {
            normalOption.error(R.drawable.ic_placeholder);
            normalOption.placeholder(R.drawable.ic_placeholder);
            Glide.with(imageView.getContext())
                    .load(url)
                    .apply(normalOption)
                    .into(imageView);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            System.gc();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void loadImage(Context context, Object url, ImageView imageView) {
        try {
            normalOption.error(R.drawable.ic_placeholder);
            normalOption.placeholder(R.drawable.ic_placeholder);
            Glide.with(context)
                    .load(url)
                    .apply(normalOption)
                    .into(imageView);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            System.gc();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }









    public static Bitmap createBitmapFromVideoPath(String url, int width, int height) {
        Bitmap bitmap = null;
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        int kind = MediaStore.Video.Thumbnails.MINI_KIND;
        try {
            if (Build.VERSION.SDK_INT >= 12) {
                retriever.setDataSource(url, new HashMap<String, String>());
            } else {
                retriever.setDataSource(url);
            }
            bitmap = retriever.getFrameAtTime();
        } catch (IllegalArgumentException ex) {
            // Assume this is a corrupt video file
        } catch (RuntimeException ex) {
            // Assume this is a corrupt video file.
        } finally {
            try {
                retriever.release();
            } catch (RuntimeException ex) {
                // Ignore failures while cleaning up.
            }
        }
        if (kind == MediaStore.Images.Thumbnails.MICRO_KIND && bitmap != null) {
            bitmap = ThumbnailUtils.extractThumbnail(bitmap, width, height,
                    ThumbnailUtils.OPTIONS_RECYCLE_INPUT);
        }
        return bitmap;
    }

}
