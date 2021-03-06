package com.zhaoemifeng.myliabry;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Project:Test
 * Author: zhaomeifeng
 * Date:   2016/6/1
 */
public class CommonFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragments;

    public CommonFragmentAdapter(FragmentManager fm,List<Fragment> fragments) {
        super(fm);
        mFragments=fragments;
    }
    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        int ret=0;

        if (mFragments != null) {
            ret=mFragments.size();
        }
        return ret;
    }
}