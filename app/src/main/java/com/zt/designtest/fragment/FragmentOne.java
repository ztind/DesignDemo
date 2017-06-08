package com.zt.designtest.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.zt.designtest.ui.AppBarLayoutActivity;
import com.zt.designtest.ui.CollapsingToolbarLayoutActivity;
import com.zt.designtest.ui.CoordinatorLayoutActivity;
import com.zt.designtest.R;
import com.zt.designtest.ui.SwipeRefreshLayoutAty;

/**
 * Created by Administrator on 2016/9/4.
 * 单列设计模式：懒汉式（优选）饿汉式（创建类对象时就创建了一个静态的实列对象成员）而且要私有化构造器
 */
public class FragmentOne extends Fragment {
    private View view;
    private static FragmentOne instance;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.one, container, false);
        initView();
        return view;
    }
    public FragmentOne(){}

    //单列设计模式，保证只创建一个对象，优化内存
    public static FragmentOne getInstance(){

        if(instance==null) {
            instance = new FragmentOne();
        }
        return instance;
    }


    private void initView() {
        //SnackBar底部弹窗式消息提示框 VS TextInputLayout
        TextView snackButton = (TextView) view.findViewById(R.id.snackBut);
        snackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "底部弹窗式消息提示框SnackBar", Snackbar.LENGTH_SHORT).setAction("Action", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getContext(), "Toast", Toast.LENGTH_SHORT).show();
                    }
                }).show();
            }
        });

        //这里需要注意的是，TextInputLayout的颜色来自style中的colorAccent的颜色：
        final TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.textInput_layout);
        EditText editText = textInputLayout.getEditText();
        textInputLayout.setHint("新特性之TextInputLayout");
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (s.length() > 4) {
                    textInputLayout.setError("Password error");
                    textInputLayout.setErrorEnabled(true);
                } else {
                    textInputLayout.setErrorEnabled(false);
                }
                System.out.print("【" + s + "-----" + start + "-----" + count + "-----" + after + "】");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        //FloatingActionButton
        final FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "我是FAB", Toast.LENGTH_SHORT).show();
                fab.setImageResource(R.mipmap.ic_menu_delete);
            }
        });
        //AppBarLayout
        TextView appbarButton = (TextView) view.findViewById(R.id.appBarLayout);
        appbarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getContext().startActivity(new Intent(getActivity(), AppBarLayoutActivity.class));
            }
        });
        //CoordinatorLayout(TooBar/TabLayout的上下滑动)
        TextView coordinatorLayoutBut = (TextView) view.findViewById(R.id.CoordinatorLayout);
        coordinatorLayoutBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getContext().startActivity(new Intent(getActivity(), CoordinatorLayoutActivity.class));
            }
        });
        //CollapsingToolbarLayout(可伸缩折叠的TooBar)
        TextView CollapsingToolbarLayoutBut = (TextView) view.findViewById(R.id.CollapsingToolbarLayout);
        CollapsingToolbarLayoutBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getContext().startActivity(new Intent(getActivity(), CollapsingToolbarLayoutActivity.class));
            }
        });
        
        view.findViewById(R.id.swiper_but).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SwipeRefreshLayoutAty.class);
                getContext().startActivity(intent);
            }
        });
    }


}
