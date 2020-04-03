package com.yahu.live.main;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.CallSuper;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import com.githang.statusbar.StatusBarCompat;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.yahu.live.permission.MPermission;
import com.yahu.live.permission.annotation.OnMPermissionDenied;
import com.yahu.live.permission.annotation.OnMPermissionGranted;
import com.yahu.live.permission.annotation.OnMPermissionNeverAskAgain;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.RxLifecycle;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.android.RxLifecycleAndroid;
import com.yahu.live.BuildConfig;
import com.yahu.live.R;

import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

/**
 * Created by kmlixh on 18.2.26.
 */

public abstract class BaseActivity extends AppCompatActivity implements LifecycleProvider<ActivityEvent> {
    protected final int RST_PERMISSION_STORAGE = 24;
    private final BehaviorSubject<ActivityEvent> lifecycleSubject = BehaviorSubject.create();
    private long start;
    private TextView title;

    @Override
    @NonNull
    @CheckResult
    public final Observable<ActivityEvent> lifecycle() {
        return lifecycleSubject.hide();
    }

    @Override
    @NonNull
    @CheckResult
    public final <T> LifecycleTransformer<T> bindUntilEvent(@NonNull ActivityEvent event) {
        return RxLifecycle.bindUntilEvent(lifecycleSubject, event);
    }

    @Override
    @NonNull
    @CheckResult
    public final <T> LifecycleTransformer<T> bindToLifecycle() {
        return RxLifecycleAndroid.bindActivity(lifecycleSubject);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void startInstallPermissionSettingActivity() {

        Uri packageURI = Uri.parse("package:" + BuildConfig.APPLICATION_ID);
        //注意这个是8.0新API
        Intent intent = new Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES, packageURI);
        startActivityForResult(intent, 10086);

    }
    @Override
    @CallSuper
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }
        if(getSupportActionBar()!=null){

            getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            getSupportActionBar().setCustomView(R.layout.custom_toolbar);
            Toolbar parent =(Toolbar) getSupportActionBar().getCustomView().getParent();
            parent.setPadding(0,0,0,0);
            parent.setContentInsetsAbsolute(0,0);
            getSupportActionBar().getCustomView().findViewById(R.id.tb_back).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
            title=getSupportActionBar().getCustomView().findViewById(R.id.tb_title);
        }
        StatusBarCompat.setStatusBarColor(this, getResources().getColor(R.color.colorPrimary));
        lifecycleSubject.onNext(ActivityEvent.CREATE);
    }

    @Override
    @CallSuper
    protected void onStart() {
        super.onStart();
        start = System.currentTimeMillis();
        lifecycleSubject.onNext(ActivityEvent.START);

    }

    @Override
    @CallSuper
    protected void onResume() {
        super.onResume();
        lifecycleSubject.onNext(ActivityEvent.RESUME);
    }

    @Override
    @CallSuper
    protected void onPause() {
        lifecycleSubject.onNext(ActivityEvent.PAUSE);
        super.onPause();

    }


    @Override
    @CallSuper
    protected void onStop() {
        lifecycleSubject.onNext(ActivityEvent.STOP);
        super.onStop();
    }

    @Override
    @CallSuper
    protected void onDestroy() {
        try {
            lifecycleSubject.onNext(ActivityEvent.DESTROY);
            super.onDestroy();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void showBackArrow() {
        if(getSupportActionBar()!=null){
            getSupportActionBar().getCustomView().findViewById(R.id.tb_back).setVisibility(View.VISIBLE);
        }
    }
    @Override
    public void setTitle(CharSequence title) {
        if(this.title!=null){
            this.title.setText(title);
        }
        super.setTitle(title);
    }
    public void setTitleColor(int titleColor){
        title.setTextColor(titleColor);
    }
    @Override
    public void setTitle(int titleId) {
        if(this.title!=null){
            this.title.setText(getResources().getString(titleId));
        }
        super.setTitle(titleId);
    }

    protected int getDurationOfSeconds() {
        return (int) ((System.currentTimeMillis() - start) / 1000);
    }

    protected void resetStart() {
        start = 0;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return false;
    }
    protected boolean traceBack=false;
    protected long backTime=0;
    @Override
    public void finish(){
        if(isTaskRoot()&&traceBack){
            long current=System.currentTimeMillis();
            if(current-backTime>3000){
                backTime=current;
                Toast.makeText(getApplicationContext(),"再按一次退出应用",Toast.LENGTH_SHORT).show();
            }else{
                super.finish();
            }
        }else{
            super.finish();
        }
    }


    protected String[] getRequestedPermissions(){
        return new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA
        };
    }
    protected final int BASIC_PERMISSION_REQUEST_CODE = 1001;

    protected void requestBasicPermission() {
        MPermission.with(this)
                .setRequestCode(BASIC_PERMISSION_REQUEST_CODE)
                .permissions(getRequestedPermissions())
                .request();

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        MPermission.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
    }

    @OnMPermissionGranted(BASIC_PERMISSION_REQUEST_CODE)
    public void onBasicPermissionSuccess() {
    }

    protected Boolean shouldNotifyPermission=false;
    @OnMPermissionDenied(BASIC_PERMISSION_REQUEST_CODE)
    @OnMPermissionNeverAskAgain(BASIC_PERMISSION_REQUEST_CODE)
    public void onBasicPermissionFailed() {
        if(shouldNotifyPermission){
            Toast.makeText(getApplicationContext(),"部分功能受限，请对App授权",Toast.LENGTH_SHORT).show();
        }
        MPermission.printMPermissionResult(false, this,  getRequestedPermissions());
    }

    public void setTitleSize(int size) {
        title.setTextSize(TypedValue.COMPLEX_UNIT_SP,size);
    }
}
