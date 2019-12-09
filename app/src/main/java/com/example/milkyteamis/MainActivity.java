package com.example.milkyteamis;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.example.milkyteamis.activity.BaseActivity;
import com.example.milkyteamis.activity.GoodsActivity;
import com.example.milkyteamis.activity.OrderActivity;
import com.example.milkyteamis.activity.OrderInfoActivity;

public class MainActivity extends BaseActivity {

    //启动从登陆界面开始

    //初始化页面控件
    ImageView iv_order,iv_report,iv_chpasswd,iv_goods,iv_ordersInfo,iv_toolbar_back;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usermenu);
        toolbar = findViewById(R.id.toolbar);
        super.setToolbarAndTitle("菜单",true);
        initView();
        initListener();
    }

    private void initView(){
        iv_order = findViewById(R.id.iv_order);
        iv_chpasswd = findViewById(R.id.iv_chpasswd);
        iv_report = findViewById(R.id.iv_report);
        iv_goods = findViewById(R.id.iv_goods);
        iv_ordersInfo = findViewById(R.id.iv_orderInfo);
        iv_toolbar_back = findViewById(R.id.iv_toolbar_back);
        iv_toolbar_back.setVisibility(View.INVISIBLE);
    }

    private void initListener(){
        iv_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, OrderActivity.class);
                startActivity(i);
            }
        });

        iv_chpasswd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        iv_ordersInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, OrderInfoActivity.class);
                startActivity(i);
            }
        });

        iv_goods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, GoodsActivity.class);
                startActivity(i);
            }
        });
        iv_report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
