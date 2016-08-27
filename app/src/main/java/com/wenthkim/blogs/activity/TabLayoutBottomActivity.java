package com.wenthkim.blogs.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.wenthkim.blogs.R;
import com.wenthkim.blogs.adapter.TabLayoutAdapter;
import com.wenthkim.blogs.fragment.HomeFragment;
import com.wenthkim.blogs.fragment.MineFragment;
import com.wenthkim.blogs.fragment.ShopCarFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenth on 2016/8/27.
 */

public class TabLayoutBottomActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Class[] fragments = new Class[]{
            HomeFragment.class, ShopCarFragment.class, MineFragment.class
    };
    private List<Fragment> fragmentlists = new ArrayList<>();
    private TabLayoutAdapter mAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayoutbttom);
        initView();
        initTabLayout();
    }

    private void initView() {
        tabLayout = (TabLayout) findViewById(R.id.tab_FindFragment_title);
        viewPager = (ViewPager) findViewById(R.id.vp_FindFragment_pager);
    }

    private void initTabLayout() {
        HomeFragment homefragment = new HomeFragment();
        ShopCarFragment shopcarfragment = new ShopCarFragment();
        MineFragment minefragment = new MineFragment();
        fragmentlists.add(homefragment);
        fragmentlists.add(shopcarfragment);
        fragmentlists.add(minefragment);
        mAdapter = new TabLayoutAdapter(getSupportFragmentManager(),fragmentlists,this);
        //设置TabLayout的模式
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        viewPager.setAdapter(mAdapter);
        tabLayout.setupWithViewPager(viewPager);
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            //为每个tab设置自定义视图，获取自定视图的方法写在Adapter里面
            //同样也可以直接写在Activity里面
            tab.setCustomView(mAdapter.getCustomView(i));
        }
    }
}
