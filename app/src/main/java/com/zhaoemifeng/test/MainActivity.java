package com.zhaoemifeng.test;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioGroup;

import com.zhaoemifeng.test.fragments.FileFragment;
import com.zhaoemifeng.test.fragments.MovieFragment;
import com.zhaoemifeng.test.fragments.PictureFragment;
import com.zhaoemifeng.test.fragments.ShareFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    private List<Fragment> mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragments = new ArrayList<>();

        // 当Activity发生重复创建或者横竖屏切换 内部的Fragment
        // 会自动创建一遍

        FragmentManager manager = getSupportFragmentManager();
        if (savedInstanceState == null) { // 第一次创建
            Fragment fragment = new MovieFragment();
            mFragments.add(fragment);

            fragment = new FileFragment();
            mFragments.add(fragment);

            fragment = new PictureFragment();
            mFragments.add(fragment);

            fragment = new ShareFragment();
            mFragments.add(fragment);

            FragmentTransaction transaction
                    = manager.beginTransaction();
            int index = 0;
            for (Fragment f : mFragments) {
                // 添加
                // 第三个参数，相当于 给Fragment设置一个 tag, 之后可以进行查找
                transaction.add(R.id.fragment_container, f, "tag" + index);
                // 隐藏
                transaction.hide(f);

                index++;
            }
            // 第一个显示
            transaction.show(mFragments.get(0));
            transaction.commit();
        } else { // 不是第一次创建，Fragment会自动的由Activity创建好
            // FragmentManager 的管理

            for (int i = 0; i < 4; i++) {
                String tag = "tag" + i;

                // 根据 add 时，设置的tag，来查找Fragment
                Fragment f = manager.findFragmentByTag(tag);

                if (f != null) {
                    mFragments.add(f);
                }
            }
        }

        // -----------------------
        // Tab 切换

        RadioGroup group = (RadioGroup) findViewById(R.id.main_tab_bar);
        if (group != null) {
            group.setOnCheckedChangeListener(this);
        }


    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        int index = 0;
        switch (checkedId) {
            case R.id.main_tab_movie:
                index = 0;
                break;
            case R.id.main_tab_file:
                index = 1;
                break;
            case R.id.main_tab_picture:
                index = 2;
                break;
            case R.id.main_tab_share:
                index = 3;
                break;
        }
        switchFragment(index);
    }

    private void switchFragment(int index){
        if(index >= 0 && index < mFragments.size()){

            int size = mFragments.size();

            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();

            for (int i = 0; i < size; i++) {

                Fragment f = mFragments.get(i);

                if(i == index){
                    // 显示
                    transaction.show(f);
                }else{
                    // 隐藏
                    transaction.hide(f);
                }
            }
            transaction.commit();

        }
    }

}
