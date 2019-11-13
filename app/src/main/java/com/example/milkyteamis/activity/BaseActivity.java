package com.example.milkyteamis.activity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.milkyteamis.R;
import com.example.milkyteamis.util.ActivityCollector;

public class BaseActivity extends AppCompatActivity {

    private boolean hasBackButton;
    protected ActivityCollector activityCollector = ActivityCollector.getInstance();
    protected Typeface tfRegular;
    protected Typeface tfLight;
    Toolbar mToolbar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tfRegular = Typeface.createFromAsset(getAssets(),"OpenSans-Regular.ttf");
        tfLight = Typeface.createFromAsset(getAssets(),"OpenSans-Light.ttf");
        mToolbar = (android.support.v7.widget.Toolbar)findViewById(R.id.toolbar);
        initStatusTransparent();
        activityCollector.add(this);

    }



    /**
     * 设置toolbar
     *
     * @param title  toolbar 标题
     * @param isBack true 显示返回键 / false 不显示
     *               注意：toolbar的id必须为R.id.toolbar / toolbar中的标题id必须为R.id.tv_toolbar_title
     */
    protected void setToolbarAndTitle(CharSequence title,boolean isBack) {
        ((TextView) findViewById(R.id.tv_toolbar_title)).setText(title);
        if(isBack)
            displayHomeButton();
    }


    /**
     * 导航栏返回封装，一键设置activity带返回键
     */
    protected void displayHomeButton() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            setSupportActionBar(mToolbar);
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            hasBackButton = true;
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        this.finish();
        return super.onSupportNavigateUp();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(hasBackButton && item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void initStatusTransparent() {
        // 为window设立半透明状态栏的标签
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //兼容5.0及以上支持全透明
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        View v = findViewById(R.id.toolbar);
        if (v != null) {
            v.setPadding(0, getStatusBarHeight(), 0, 10);
            v.requestLayout();
        }
    }

    protected int getStatusBarHeight() {
        int statusBarHeight = -1;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            statusBarHeight = getResources().getDimensionPixelSize(resourceId);
        }
        return statusBarHeight;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
