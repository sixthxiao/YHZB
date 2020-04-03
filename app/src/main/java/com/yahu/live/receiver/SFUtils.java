package com.yahu.live.receiver;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;

import com.yahu.live.web.HtmlActivity;

import org.json.JSONObject;

import java.util.List;

/**
 * 推送消息处理工具
 */
public class SFUtils {
    // 打开 App
    private static final String LAND_TYPE_OPEN_APP = "OPEN_APP";

    // 打开 Link
    private static final String LAND_TYPE_LINK = "LINK";
    private static final int LAND_TYPE_LINK_URL = 1603;

    // 自定义
    private static final String LAND_TYPE_CUSTOMIZED = "CUSTOMIZED";


    private static final String SF_DATA = "sf_data";
    private static final String CS_DATA = "messageType";

    private static final int TYPE_OPEN_LIVE_BY_ID = 1202;

    private static final int TYPE_OPEN_NEW_GOOD = 1701;

    private static final int TYPE_OPEN_LOW_GOOD = 1702;


    /**
     * 处理 SF 配置的操作
     *
     * @param context Context
     * @param sfData  配置
     */
    public static void handleSFConfig(Context context, String sfData) {
        try {
            if (!TextUtils.isEmpty(sfData)) {
                JSONObject jsonObject = new JSONObject(sfData);
                // 解析推送过来的类型，有三种 OPEN_APP、LINK、CUSTOMIZED
                String type = jsonObject.optString("sf_landing_type");
//                String type = jsonObject.optString("messageType");
                if (LAND_TYPE_OPEN_APP.equals(type)) {//打开 App
                    openApp(context);
                } else if (LAND_TYPE_LINK.equals(type)) {//打开链接
                    // 剥离出 link_data 字段
                    String url = jsonObject.optString("sf_link_url");
                    if (!TextUtils.isEmpty(url)) {
//                        openLINK(context, url);
                        Intent intent01 = new Intent(context, HtmlActivity.class);
                        intent01.putExtra("url", url);
                        context.startActivity(intent01);
                    }

                } else if (LAND_TYPE_CUSTOMIZED.equals(type)) {//自定义的内容
                    // 剥离提取出自定义参数
                    JSONObject customized = (JSONObject) jsonObject.opt("customized");
                    openCustomized(context, customized);
                }
            }
        } catch (Exception ex) {
            //ignore
        }
    }

    /**
     * 解析 SF 配置
     *
     * @param extra 配置v
     * @return 配置值
     */
    public static String readSFConfig(String extra) {
        try {
            if (!TextUtils.isEmpty(extra)) {
                JSONObject json = new JSONObject(extra);
                if (json.has(SF_DATA)) {
                    return json.optString(SF_DATA);
                }
            }
        } catch (Exception ex) {
            //ignore
        }
        return "";
    }

    /**
     * 解析 厂商通道 配置
     *
     * @param extra 配置v
     * @return 配置值
     */
    public static JSONObject readCSConfig(String extra) {
        try {
            if (!TextUtils.isEmpty(extra)) {
                JSONObject json = new JSONObject(extra);
                if (json.has(CS_DATA)) {
                    return json;
                }
            }
        } catch (Exception ex) {
            //ignore
        }
        return null;
    }


    /**
     * 处理通知打开操作，需要保证上传事件的字段是一致的。
     * <p>
     * 事件名：AppOpenNotification
     * msg_id	消息 ID	字符串
     * msg_title	消息标题	字符串
     * msg_content	消息内容	字符串
     * push_type	消息类型	字符串
     * sf_link_url	定向跳转页面	字符串
     * sf_plan_name	计划名称	字符串
     * sf_audience_entry_time	计划受众的进入时间	日期时间
     * sf_audience_id	计划受众 id	字符串
     * sf_plan_id	计划 id	数字
     *
     * @param context             Context
     * @param sfData              SF 配置
     * @param msg_id              三方平台的通知 ID，暂时无用
     * @param notificationTitle   通知标题
     * @param notificationContent 通知内容
     */
    public static void trackAppOpenNotification(Context context, String sfData, String msg_id, String notificationTitle, String notificationContent) {
        try {
            JSONObject jsonObject = null;
            if (!TextUtils.isEmpty(sfData)) {
                jsonObject = new JSONObject(sfData);
            }
            JSONObject properties = new JSONObject();
            // 获取消息标题，并保存在事件属性 msg_title 中
            properties.put("$sf_msg_title", notificationTitle);
            // 获取消息 ID，并保存在事件属性 msg_id 中
            properties.put("$sf_msg_content", notificationContent);
            if (jsonObject != null) {
                properties.put("$sf_msg_id", jsonObject.optString("sf_msg_id"));
                properties.put("$sf_plan_id", jsonObject.optString("sf_plan_id"));
                properties.put("$sf_audience_id", jsonObject.optString("sf_plan_audience_id"));
                properties.put("$sf_link_url", jsonObject.optString("sf_link_url"));
                properties.put("$sf_plan_name", jsonObject.optString("sf_plan_name"));
                properties.put("$sf_plan_strategy_id", jsonObject.optString("sf_plan_strategy_id"));
            }
        } catch (Exception ex) {
            //ignore
        }
    }

    /**
     * 打开 App
     *
     * @param context Context
     */
    public static void openApp(Context context) {
        if (!isAppForeground(context)) {
            Intent intent = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            context.startActivity(intent);
        }
    }

    /**
     * 打开链接
     *
     * @param context Context
     * @param url     Url
     */
    private static void openLINK(Context context, String url) {
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);

    }


    /**
     * 自定义操作
     *
     * @param context Context
     * @param params  自定义的参数
     */
    public static void openCustomized(Context context, JSONObject params) {
        Intent intent = null;
        int messageType = params.optInt("messageType");

        switch (messageType) {
            case TYPE_OPEN_LIVE_BY_ID:
                int a = SFUtils.isAppAlive(context, "com.xindanci.zhubao");
                if (a != 1) {
                    Log.i("TAG", params.optString("liveId") + "------------");
                    Intent intent01 = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
                    intent01.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    context.startActivity(intent01);

//                    Intent intentNotification = new Intent(context, MainActivity.class);
//                    intentNotification.putExtra("TAG_MESSAGE", "LIVE");
//                    intentNotification.putExtra("id", params.optString("liveId"));
//                    context.startActivity(intentNotification);
                } else {

//                    intent = new Intent(context, NewLiveActivity.class);
//                    intent.putExtra("id", params.optString("liveId"));
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                    context.startActivity(intent);
                }

                break;
            case LAND_TYPE_LINK_URL://打开H5
                int b = SFUtils.isAppAlive(context, "com.xindanci.zhubao");
                if (b != 1) {
                    Intent intent01 = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
                    intent01.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    context.startActivity(intent01);

                } else {
                    String url = params.optString("url");
                    if (!TextUtils.isEmpty(url)) {
//                    openLINK(context, url);
                        Intent intent01 = new Intent(context, HtmlActivity.class);
                        intent01.putExtra("url", url);
                        context.startActivity(intent01);
                    }
                }
                break;
            default:
                //打开app
                openApp(context);
        }

    }

    /**
     * 判断 App 是否在前台，仅供参考
     *
     * @param context Context
     * @return true, 在前台 false，在后台
     */
    private static boolean isAppForeground(Context context) {
        try {
            ActivityManager activityManager =
                    (ActivityManager) context.getSystemService(Service.ACTIVITY_SERVICE);
            List<ActivityManager.RunningAppProcessInfo> runningAppProcessInfoList =
                    null;
            if (activityManager != null) {
                runningAppProcessInfoList = activityManager.getRunningAppProcesses();
            }
            if (runningAppProcessInfoList == null) {
                return false;
            }

            for (ActivityManager.RunningAppProcessInfo processInfo : runningAppProcessInfoList) {
                if (processInfo.processName.equals(context.getPackageName())
                        && (processInfo.importance ==
                        ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND)) {
                    return true;
                }
            }
            return false;
        } catch (Exception ex) {
            //ignore
        }
        return false;
    }

    /**
     * 发送广播展示数据
     *
     * @param context Context
     * @param type    哪个推送类型
     * @param message 数据
     */
    public static void sendBroadcast(Context context, String type, String message) {
        Intent intent = new Intent(context.getPackageName());
        intent.putExtra("type", type);
        intent.putExtra("message", message);
        context.sendBroadcast(intent);
    }

    /**
     * 保存 PushId
     *
     * @param context Context
     * @param type    类型，Umeng、GeTui、Jpush
     * @param pushId  PushId
     */
    public static void savePushId(Context context, String type, String pushId) {
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        sharedPreferences.edit().putString("PushId:" + type, pushId).apply();
    }

    /**
     * 获取 PushId
     *
     * @param context Context
     * @param type    类型，Umeng、GeTui、Jpush
     * @return pushId
     */
    public static String getPushId(Context context, String type) {
        return getSharedPreferences(context).getString("PushId:" + type, "");
    }


    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
    }


    /**
     * 返回app运行状态
     *
     * @param context     一个context
     * @param packageName 要判断应用的包名
     * @return int 1:前台 2:后台 0:不存在
     */
    public static int isAppAlive(Context context, String packageName) {
        ActivityManager activityManager = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> listInfos = activityManager
                .getRunningTasks(20);
        // 判断程序是否在栈顶
        if (listInfos.get(0).topActivity.getPackageName().equals(packageName)) {
            return 1;
        } else {
            // 判断程序是否在栈里
            for (ActivityManager.RunningTaskInfo info : listInfos) {
                if (info.topActivity.getPackageName().equals(packageName)) {
                    return 2;
                }
            }
            return 0;// 栈里找不到，返回3
        }
    }
}