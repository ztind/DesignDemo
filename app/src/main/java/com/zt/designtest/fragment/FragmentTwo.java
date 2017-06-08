package com.zt.designtest.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zt.designtest.R;

/**
 * Created by Administrator on 2016/9/4.
 */
public class FragmentTwo extends Fragment {
    private static FragmentTwo instance;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.two, container, false);
        return view;
    }
    //单列设计模式，保证只创建一个对象，优化内存
    public static FragmentTwo getInstance(){

        if(instance==null) {
            instance = new FragmentTwo();
        }
        return instance;
    }
    private FragmentTwo(){}
}
