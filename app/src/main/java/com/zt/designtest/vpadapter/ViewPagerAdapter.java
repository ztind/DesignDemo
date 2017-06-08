package com.zt.designtest.vpadapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.zt.designtest.fragment.FragmentFive;
import com.zt.designtest.fragment.FragmentFour;
import com.zt.designtest.fragment.FragmentOne;
import com.zt.designtest.fragment.FragmentThree;
import com.zt.designtest.fragment.FragmentTwo;

import java.util.List;

/**
 * Created by Administrator on 2016/9/4.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    private List<String> list;
    public ViewPagerAdapter(FragmentManager fm,List<String> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 :
                return FragmentOne.getInstance();
            case 1 :
                return FragmentTwo.getInstance();
            case 2 :
                return FragmentThree.getInstance();
            case 3 :
                return FragmentFour.getInstance();
            case 4 :
                return FragmentFive.getInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    //重写获取标题的方法
    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position).toString();
    }
}
