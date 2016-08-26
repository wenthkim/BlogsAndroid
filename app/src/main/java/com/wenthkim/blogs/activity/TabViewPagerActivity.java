package com.wenthkim.blogs.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.wenthkim.blogs.R;
import com.wenthkim.blogs.adapter.ViewPagerAdaper;
import com.wenthkim.blogs.fragment.HomeFragment;
import com.wenthkim.blogs.fragment.MineFragment;
import com.wenthkim.blogs.fragment.ShopCarFragment;
import com.wenthkim.blogs.widget.FragmentTabHost;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenth on 2016/8/26.
 */

public class TabViewPagerActivity extends AppCompatActivity {

    private ViewPager viewpager;
    private FragmentTabHost tabhost;
    private Class[] fragments = new Class[]{
            HomeFragment.class, ShopCarFragment.class, MineFragment.class
    };
    private int[] tabimgs = new int[]{
            R.drawable.home_selector,R.drawable.shopcar_selector,
            R.drawable.mine_selector
    };
    private String[] titles = new String[]{"首页","购物车","我的"};
    private List<Fragment> fragmentlists = new ArrayList<Fragment>();
    private ViewPagerAdaper mAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabviewpager);
        initView();
        initTabs();
        initViewPager();
    }

    /**
     * 初始化viewpager
     */
    private void initViewPager() {
        HomeFragment homefragment = new HomeFragment();
        MineFragment minefragment = new MineFragment();
        ShopCarFragment shopcarfragment = new ShopCarFragment();
        fragmentlists.add(homefragment);
        fragmentlists.add(shopcarfragment);
        fragmentlists.add(minefragment);
        mAdapter = new ViewPagerAdaper(getSupportFragmentManager(),fragmentlists);
        viewpager.setAdapter(mAdapter);
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                //当滑动到该的时候，设置对应的tab
                    tabhost.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * 设置tab
     */
    private void initTabs() {
        tabhost.setup(this,getSupportFragmentManager(),R.id.viewpager);
        for (int i = 0; i < fragments.length; i++) {
            View tabview = getLayoutInflater().inflate(R.layout.tab_item,null);
            ImageView tab_img = (ImageView) tabview.findViewById(R.id.tab_img);
            TextView tab_title = (TextView) tabview.findViewById(R.id.tab_title);
            tab_img.setImageResource(tabimgs[i]);
            tab_title.setText(titles[i]);
            tabhost.addTab(tabhost.newTabSpec(""+i).setIndicator(tabview),fragments[i],null);
        }
        tabhost.getTabWidget().setDividerDrawable(null);
        tabhost.setCurrentTab(0);
        tabhost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                int position = tabhost.getCurrentTab();
                viewpager.setCurrentItem(position);
            }
        });
    }

    private void initView() {
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        tabhost = (FragmentTabHost) findViewById(R.id.tabhost);
    }

}
