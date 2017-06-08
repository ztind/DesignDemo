package com.zt.designtest.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.zt.designtest.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/9/5.
 * CoordinatorLayout是这次新添加的一个增强型的FrameLayout。在CoordinatorLayout中，我们可以在FrameLayout的基础上完成很多新的操作。
 *
 *  创建滚动:
      CoordinatorLayout可以说是这次support library更新的重中之重。它从另一层面去控制子view之间触摸事件的布局，Design library中的很多控件都利用了它。
 */
public class CoordinatorLayoutActivity extends Activity {
    private TabLayout tabLayout;
    private ListView listView;
    private List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coordinatorlayout);
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
        hashMap.put("name", "tom");
        list.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "mack");
        list.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "小明");
        list.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "hello");
        list.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "小强");
        list.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "大哥");
        list.add(hashMap);
    }
    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tabLayout = (TabLayout) findViewById(R.id.design_table_three);
        tabLayout.addTab(tabLayout.newTab().setText("音乐"), false);
        tabLayout.addTab(tabLayout.newTab().setText("电影"), false);
        tabLayout.addTab(tabLayout.newTab().setText("新闻"), true);
        tabLayout.addTab(tabLayout.newTab().setText("动漫"), false);
        tabLayout.addTab(tabLayout.newTab().setText("游戏"), false);
        listView = (ListView) findViewById(R.id.listview);
        SimpleAdapter adapter = new SimpleAdapter(this,list, R.layout.list_item, new String[]{"name"}, new int[]{R.id.textview});
        listView.setAdapter(adapter);
    }
}
