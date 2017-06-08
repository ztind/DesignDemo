package com.zt.designtest.ui;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.zt.designtest.R;
import com.zt.designtest.vpadapter.ListViewAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/3/14.
 */

public class SwipeRefreshLayoutAty extends Activity {
    private SwipeRefreshLayout swipeRefreshLayout;
    private ListView listView;
    private ListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swiper);
        initView();
    }

    private void initView() {
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe);
        //设置刷新时动画的颜色，可以设置4个
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light,
                android.R.color.holo_orange_light, android.R.color.holo_green_light);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                Toast.makeText(SwipeRefreshLayoutAty.this, "正在刷新", Toast.LENGTH_SHORT).show();
                //refresh data
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(SwipeRefreshLayoutAty.this, "刷新完成啦!!", Toast.LENGTH_SHORT).show();
                        refreshListData();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                },300);
            }
        });
        listView = (ListView) findViewById(R.id.swipe_listview);
        initData();
        adapter = new ListViewAdapter(this,list);
        listView.setAdapter(adapter);
    }

    private ArrayList<String> list;
    private void initData() {
        list = new ArrayList<>();
        for (int i=0;i<20;i++){
            list.add("item " + i);
        }
    }
    private void refreshListData(){
        for (int i=1;i<4;i++){
            list.add(0,"refresh item " + i);
        }
        adapter.notifyDataSetChanged();
    }
}
