package com.wenthkim.blogs.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.wenthkim.blogs.R;
import com.wenthkim.blogs.adapter.TabLayoutTopAdapter;
import com.wenthkim.blogs.fragment.HomeFragment;
import com.wenthkim.blogs.fragment.MineFragment;
import com.wenthkim.blogs.fragment.ShopCarFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenth on 2016/8/27.
 */

public class TabLayoutTopActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Fragment> fragmentlists = new ArrayList<>();
    private TabLayoutTopAdapter mAdapter;
    private String[] titles = new String[]{"首页","购物车","我的"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayouttop);
        initView();
        initTab();
    }

    private void initTab() {
        HomeFragment homefragment = new HomeFragment();
        ShopCarFragment shopcarfragment = new ShopCarFragment();
        MineFragment minefragment = new MineFragment();
        fragmentlists.add(homefragment);
        fragmentlists.add(shopcarfragment);
        fragmentlists.add(minefragment);

        mAdapter = new TabLayoutTopAdapter(getSupportFragmentManager(),fragmentlists);
        //设置TabLayout的模式
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        viewPager.setAdapter(mAdapter);
        tabLayout.setupWithViewPager(viewPager);
        //如果在Adapter里面重写getPageTitle这个方法
        //下面这个循环为tab设置标题就可以不要了
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            tabLayout.getTabAt(i).setText(titles[i]);
        }
    }
    private void initView() {
        tabLayout = (TabLayout) findViewById(R.id.tab_FindFragment_title);
        viewPager = (ViewPager) findViewById(R.id.vp_FindFragment_pager);
    }

}
