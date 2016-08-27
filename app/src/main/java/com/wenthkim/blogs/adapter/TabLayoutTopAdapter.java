package com.wenthkim.blogs.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wenthkim.blogs.R;

import java.util.List;

/**
 * Created by wenth on 2016/8/27.
 */

public class TabLayoutTopAdapter extends FragmentPagerAdapter {
    private List<Fragment> list_fragment;

    private String[] titles = new String[]{"首页","购物车","我的"};

    public TabLayoutTopAdapter(FragmentManager fm, List<Fragment> list_fragment) {
        super(fm);
        this.list_fragment = list_fragment;
    }

    @Override
    public Fragment getItem(int position) {
        return list_fragment.get(position);
    }

    @Override
    public int getCount() {
        return list_fragment.size();
    }

    /**
     * 返回页面的标题 如果选择在Activity里面直接
     * 用for (int i = 0; i < tabLayout.getTabCount(); i++) {
        tabLayout.getTabAt(i).setText(titles[i]);
       }设置的话就不用重写这个方法
     * @param position
     * @return
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position%titles.length];
    }
}
