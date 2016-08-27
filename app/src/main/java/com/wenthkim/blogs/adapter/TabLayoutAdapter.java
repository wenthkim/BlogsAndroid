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
public class TabLayoutAdapter extends FragmentPagerAdapter {
    private List<Fragment> list_fragment;

    /**
     * 这些资源可以在这里定义，可以在Activity中通过构造方法传进来
     */
    private int[] tabimgs = new int[]{
            R.drawable.home_selector_32,R.drawable.shopcar_selector_32,
            R.drawable.mine_selector_32
    };
    private String[] titles = new String[]{"首页","购物车","我的"};
    private Context context;
    public TabLayoutAdapter(FragmentManager fm,List<Fragment> list_fragment,Context context) {
        super(fm);
        this.list_fragment = list_fragment;
        this.context = context;
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
     * 这个提示tab的自定义视图
     * @param position
     * @return
     */
    public View getCustomView(int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.tab_custom_view,null);
        ImageView img = (ImageView) view.findViewById(R.id.tab_img);
        TextView txtview = (TextView) view.findViewById(R.id.tab_text);
        img.setImageResource(tabimgs[position]);
        txtview.setText(titles[position]);
        return view;
    }
}
