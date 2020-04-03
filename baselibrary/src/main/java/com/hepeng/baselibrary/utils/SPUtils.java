package com.hepeng.baselibrary.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;

import com.hepeng.baselibrary.bean.CosTempBean;
import com.hepeng.baselibrary.bean.DoctorInfoBean;
import com.hepeng.baselibrary.bean.RegionListBean;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HePeng on 2017/10/19.
 */

public class SPUtils {
    private static SPUtils instance;
    private static final String SP_NAME = "gyzx";
    private static final String SP_LODINNAME = "gyzxlogin";
    private static SharedPreferences mSp;
    private static SharedPreferences login;

    public static synchronized SPUtils getInstance(Context context) {
        if (instance == null) {
            instance = new SPUtils();
            mSp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
            login = context.getSharedPreferences(SP_LODINNAME, Context.MODE_PRIVATE);
        }
        return instance;
    }

    //判断是否是第一次打开
    public boolean isFristUseApp() {
        return login.getBoolean("isFristUseApp", true);
    }

    public void setFristUseApp(boolean boo) {
        login.edit().putBoolean("isFristUseApp", boo).commit();
    }

    public String getLoginAccount() {
        return login.getString("LoginAccount", "");
    }

    public void setLoginAccount(String str) {
        login.edit().putString("LoginAccount", str).commit();
    }

    public String getLoginpwd() {
        return login.getString("Loginpwd", "");
    }

    public void setLoginpwd(String str) {
        login.edit().putString("Loginpwd", str).commit();
    }

    public int getLaunchCount() {
        return login.getInt("launchCount", 0);
    }

    public void setLaunchCount(int count) {
        login.edit().putInt("launchCount", count).commit();
    }

    public int getFansNum() {
        return mSp.getInt("fansNum", 0);
    }

    public void setFansNum(int num) {
        mSp.edit().putInt("fansNum", num).commit();
    }

    public void putToken(String token) {
        mSp.edit().putString("token", token).commit();
    }

    public String getToken() {
        return mSp.getString("token", "");
    }

    public void putString(String key, String value) {
        mSp.edit().putString(key, value).commit();
    }

    public String getString(String key, String defVal) {
        return mSp.getString(key, defVal);
    }

    public void putInt(String key, int value) {
        mSp.edit().putInt(key, value).commit();
    }

    public int getInt(String key, int defVal) {
        return mSp.getInt(key, defVal);
    }

    public void putBoolean(String key, boolean value) {
        mSp.edit().putBoolean(key, value).commit();
    }

    public boolean getBoolean(String key, boolean defVal) {
        return mSp.getBoolean(key, defVal);
    }

    public void putAddressListBean(List<RegionListBean> regionListBeans) {
        //创建字节输出流
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        //创建字节对象输出流
        ObjectOutputStream out = null;
        try {
            //然后通过将字对象进行64转码，写入key值为key的sp中
            out = new ObjectOutputStream(baos);
            out.writeObject(regionListBeans);
            String objectVal = new String(Base64.encode(baos.toByteArray(), Base64.DEFAULT));
            mSp.edit().putString("addressList", objectVal).commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    baos.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public List<RegionListBean> getAddressListBean() {
        if (mSp.contains("addressList")) {
            String objectVal = mSp.getString("addressList", null);
            byte[] buffer = Base64.decode(objectVal, Base64.DEFAULT);
            //一样通过读取字节流，创建字节流输入流，写入对象并作强制转换
            ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(bais);
                List<RegionListBean> regionListBeans = (List<RegionListBean>) ois.readObject();
                return regionListBeans;
            } catch (StreamCorruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (bais != null) {
                        bais.close();
                    }
                    if (ois != null) {
                        ois.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public void putDoctorInfoBean(DoctorInfoBean doctorInfoBean) {
        //创建字节输出流
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        //创建字节对象输出流
        ObjectOutputStream out = null;
        try {
            //然后通过将字对象进行64转码，写入key值为key的sp中
            out = new ObjectOutputStream(baos);
            out.writeObject(doctorInfoBean);
            String objectVal = new String(Base64.encode(baos.toByteArray(), Base64.DEFAULT));
            mSp.edit().putString("doctorInfoBean", objectVal).commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    baos.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public DoctorInfoBean getDoctorInfoBean() {
        if (mSp.contains("doctorInfoBean")) {
            String objectVal = mSp.getString("doctorInfoBean", null);
            byte[] buffer = Base64.decode(objectVal, Base64.DEFAULT);
            //一样通过读取字节流，创建字节流输入流，写入对象并作强制转换
            ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(bais);
                DoctorInfoBean doctorInfoBean = (DoctorInfoBean) ois.readObject();
                return doctorInfoBean;
            } catch (StreamCorruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (bais != null) {
                        bais.close();
                    }
                    if (ois != null) {
                        ois.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public void putObjectBean(String key, Object val) {
        //创建字节输出流
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        //创建字节对象输出流
        ObjectOutputStream out = null;
        try {
            //然后通过将字对象进行64转码，写入key值为key的sp中
            out = new ObjectOutputStream(baos);
            out.writeObject(val);
            String objectVal = new String(Base64.encode(baos.toByteArray(), Base64.DEFAULT));
            mSp.edit().putString(key, objectVal).commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    baos.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Object getObjectBean(String key) {
        if (mSp.contains(key)) {
            String objectVal = mSp.getString(key, null);
            byte[] buffer = Base64.decode(objectVal, Base64.DEFAULT);
            //一样通过读取字节流，创建字节流输入流，写入对象并作强制转换
            ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(bais);
                Object object = ois.readObject();
                return object;
            } catch (StreamCorruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (bais != null) {
                        bais.close();
                    }
                    if (ois != null) {
                        ois.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public void putCostempBean(CosTempBean cosTempBean) {
        //创建字节输出流
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        //创建字节对象输出流
        ObjectOutputStream out = null;
        try {
            //然后通过将字对象进行64转码，写入key值为key的sp中
            out = new ObjectOutputStream(baos);
            out.writeObject(cosTempBean);
            String objectVal = new String(Base64.encode(baos.toByteArray(), Base64.DEFAULT));
            mSp.edit().putString("cosTempBean", objectVal).commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    baos.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public CosTempBean getCosTempBean() {
        if (mSp.contains("cosTempBean")) {
            String objectVal = mSp.getString("cosTempBean", null);
            byte[] buffer = Base64.decode(objectVal, Base64.DEFAULT);
            //一样通过读取字节流，创建字节流输入流，写入对象并作强制转换
            ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(bais);
                CosTempBean cosTempBean = (CosTempBean) ois.readObject();
                return cosTempBean;
            } catch (StreamCorruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (bais != null) {
                        bais.close();
                    }
                    if (ois != null) {
                        ois.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public void putHistoryList(List<String> list) {
        //创建字节输出流
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        //创建字节对象输出流
        ObjectOutputStream out = null;
        try {
            //然后通过将字对象进行64转码，写入key值为key的sp中
            out = new ObjectOutputStream(baos);
            out.writeObject(list);
            String objectVal = new String(Base64.encode(baos.toByteArray(), Base64.DEFAULT));
            mSp.edit().putString("historyList", objectVal).commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    baos.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public List<String> getHistoryList() {
        if (mSp.contains("historyList")) {
            String objectVal = mSp.getString("historyList", null);
            byte[] buffer = Base64.decode(objectVal, Base64.DEFAULT);
            //一样通过读取字节流，创建字节流输入流，写入对象并作强制转换
            ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(bais);
                List<String> historyList = (List<String>) ois.readObject();
                return historyList;
            } catch (StreamCorruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (bais != null) {
                        bais.close();
                    }
                    if (ois != null) {
                        ois.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return new ArrayList<>();
    }

    public void clear() {
        mSp.edit().clear().commit();
    }

}
