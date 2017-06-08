package com.zt.designtest.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.zt.designtest.R;

/**
 * AppBarLayout跟它的名字一样，把容器类的组件全部作为AppBa
 * 这里就是把Toolbar和TabLayout放到了AppBarLayout中，让他们当做一个整体作为AppBar。
 *   AppBarLayout控件实现头部两层view试图
 *
 */
public class AppBarLayoutActivity extends Activity {
    private TabLayout tabLayout;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appbarlayout);
        initView();
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });

        tabLayout = (TabLayout) findViewById(R.id.design_table_two);
        tabLayout.addTab(tabLayout.newTab().setText("北京"), false);
        tabLayout.addTab(tabLayout.newTab().setText("上海"), true);
        tabLayout.addTab(tabLayout.newTab().setText("昆明"), false);
        tabLayout.addTab(tabLayout.newTab().setText("台北"), false);
    }
}
