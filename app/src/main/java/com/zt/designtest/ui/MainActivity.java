package com.zt.designtest.ui;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zt.designtest.R;
import com.zt.designtest.vpadapter.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * design UI框架小使
 *  design此处通过在线集成的方式来集成到本工厂里。(向下兼容版)
 *   design:
 *        1,top的选项滑动view[TabLayout通过设置viewpager方式来实现选项滑动切换功能]
 *        2,侧滑功能view
 */

public class MainActivity extends FragmentActivity {
    private DrawerLayout drawerLayout;//转载NavigationView的控件
    private NavigationView navigationView;//导航view控件
    private TabLayout tabLayout;//tab切换view控件

    private ViewPager viewPager;
    private List<String> tabName;
    private ViewPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
        initSlideView();
    }

    private void initData() {
        tabName = new ArrayList<>();
        tabName.add("娱乐");
        tabName.add("新闻");
        tabName.add("电影");
        tabName.add("科技");
        tabName.add("电视剧");
    }

    private void initView() {
        //Viewpager的初始化
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        //TabLayout的初始化
        tabLayout = (TabLayout) findViewById(R.id.design_table);

        tabLayout.addTab(tabLayout.newTab().setText("娱乐"), true);//true默认选中
        for (int i = 1; i < tabName.size(); i++) {
            tabLayout.addTab(tabLayout.newTab().setText(tabName.get(i).toString()), false);
        }
        //设置tab文字的字体颜色(默认 选中)
        tabLayout.setTabTextColors(getResources().getColor(R.color.tabnoSelect), getResources().getColor(R.color.tabSelect));

        //设置指示器选中时颜色
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.tabSelect));

        //设置指示器高度
        // tabLayout.setSelectedTabIndicatorHeight(1);一般采用默认高度

        //设置tab可滑动
        // tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        viewPager.setAdapter(adapter = new ViewPagerAdapter(getSupportFragmentManager(), tabName));

        //TabLauout和ViewPager关联
        tabLayout.setupWithViewPager(viewPager);
    }
    //侧滑控件的初始化NavigationView需在DrawerLayout里
    private void initSlideView() {
        drawerLayout = (DrawerLayout) findViewById(R.id.id_drawerLayout);

        navigationView = (NavigationView) findViewById(R.id.design_navigation_view);
        //设置item的点击事件
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                if(item.getItemId()==R.id.id_exit_menu){
                    MainActivity.this.finish(); //退出
                    return false;
                }
                Toast.makeText(MainActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawers();//关闭侧滑
                return false;
            }
        });
        //获取侧滑头部的视图控件
        //*********************通过navigationView来获取头部布局里的控件(唯一有效方法)*******************************
        View view = navigationView.getHeaderView(0);
        ImageView imPhoto = (ImageView) view.findViewById(R.id.im_touxian);
        TextView name = (TextView) view.findViewById(R.id.tv_name);
        name.setText("修改名称...");
        imPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "头像", Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawers();
            }
        });
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = (TextView) v;
                Toast.makeText(MainActivity.this, tv.getText().toString(), Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawers();
            }
        });

    }
    //设置打开侧滑
    public void showorhintNavigationClick(View view) {
        drawerLayout.openDrawer(GravityCompat.START);
    }
}
