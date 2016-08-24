package com.wenthkim.blogs.activity;

import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wenthkim.blogs.R;
import com.wenthkim.blogs.fragment.HomeFragment;
import com.wenthkim.blogs.fragment.MineFragment;
import com.wenthkim.blogs.fragment.ShopCarFragment;

public class MainActivity extends AppCompatActivity {

    private FragmentTabHost tabhost;
    private Class[] fragments = new Class[]{
            HomeFragment.class, ShopCarFragment.class, MineFragment.class
    };
    private int[] tabimgs = new int[]{
           R.drawable.home_selector,R.drawable.shopcar_selector,
            R.drawable.mine_selector
    };
    private String[] titles = new String[]{"首页","购物车","我的"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        tabhost = (FragmentTabHost) findViewById(R.id.tabhost);
        tabhost.setup(this,getSupportFragmentManager(),android.R.id.tabcontent);
        for (int i = 0; i < fragments.length; i++) {
            View tabview = getLayoutInflater().inflate(R.layout.tab_item,null);
            ImageView tab_img = (ImageView) tabview.findViewById(R.id.tab_img);
            TextView tab_title = (TextView) tabview.findViewById(R.id.tab_title);
            tab_img.setImageResource(tabimgs[i]);
            tab_title.setText(titles[i]);
            tabhost.addTab(tabhost.newTabSpec(""+i).setIndicator(tabview),fragments[i],null);
        }
        tabhost.setCurrentTab(0);
    }
}
