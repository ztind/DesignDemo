package com.zt.designtest.ui;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.zt.designtest.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/9/6.
 * CAC模式实现伸缩工具栏
 */
public class CollapsingToolbarLayoutActivity extends Activity {
    private ListView listView;
    private List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collapsingtoolbarlayout);
        cjs_state();
        initData();
        initView();
    }

    private void initData() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("name", "1551");
        list.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "jack");
        list.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "jimmy");
        list.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "伸缩工具栏");
        list.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "mack");
        list.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "放大");
        list.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "你哈");
        list.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "小强");
        list.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "大哥");
        list.add(hashMap);
    }
    private void cjs_state() {
        // 4.x 全透明实现
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        }
        //5.x全透明实现
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);//calculateStatusColor(Color.WHITE, (int) alphaValue)
        }
    }
    private void initView() {
        listView = (ListView) findViewById(R.id.listview2);
        SimpleAdapter adapter = new SimpleAdapter(this,list, R.layout.list_item, new String[]{"name"}, new int[]{R.id.textview});
        listView.setAdapter(adapter);

        //使用CollapsingToolbarLayout必须把title设置到CollapsingToolbarLayout上，设置到Toolbar上则不会显示
        CollapsingToolbarLayout mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);
        mCollapsingToolbarLayout.setTitle("我的书签");

        //通过CollapsingToolbarLayout修改字体颜色
        mCollapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);//设置还没收缩时状态下字体颜色
        mCollapsingToolbarLayout.setCollapsedTitleTextColor(Color.GREEN);//设置收缩后Toolbar上字体的颜色

        Toolbar toobar = (Toolbar) findViewById(R.id.toolbar2);
        toobar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CollapsingToolbarLayoutActivity.this.finish();
            }
        });

        //fab
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.my_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "点击", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
