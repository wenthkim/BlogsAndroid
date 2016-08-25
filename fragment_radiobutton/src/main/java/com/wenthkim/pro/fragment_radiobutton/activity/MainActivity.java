package com.wenthkim.pro.fragment_radiobutton.activity;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.TextView;

import com.wenthkim.pro.fragment_radiobutton.R;
import com.wenthkim.pro.fragment_radiobutton.fragment.HomeFragment;
import com.wenthkim.pro.fragment_radiobutton.fragment.MineFragment;
import com.wenthkim.pro.fragment_radiobutton.fragment.ShopCarFragment;
import com.wenthkim.pro.fragment_radiobutton.widget.BadgeView;
import com.wenthkim.pro.fragment_radiobutton.widget.FragmentTabHost;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {


    private FragmentTabHost tabhost;
    private Class[] fragments = new Class[]{
            HomeFragment.class, ShopCarFragment.class, MineFragment.class
    };
    private BadgeView bvShop;
    private RadioButton rdobtnHome;
    private RadioButton rdobtnCar;
    private RadioButton rdobtnMine;
    private int firstState = 0;//第一次选中第一个
    private TextView tv_tip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initTabs();
    }

    /**
     * 初始化每一个tab
     */
    private void initTabs() {
        tabhost.setup(MainActivity.this, getSupportFragmentManager(), R.id.Container);
        for (int i = 0; i < fragments.length; i++) {
           /* radiobutton+fragmenttabhost组合实际是利用fragmenttabhost来切换
           * fragment,而radiobutton则作为点击监听器
           * */
            tabhost.addTab(tabhost.newTabSpec(String.valueOf(i)).setIndicator(String.valueOf(i)),
                    fragments[i], null);
        }
        //默认情况下选择第一个
        tabhost.setCurrentTab(0);
    }

    /**
     * 初始化控件
     */
    private void initViews() {
        tabhost = (FragmentTabHost) findViewById(R.id.tabHost);
        rdobtnHome = (RadioButton) findViewById(R.id.rdoBtn_home);
        rdobtnCar = (RadioButton) findViewById(R.id.rdoBtn_shopcar);
        rdobtnMine = (RadioButton) findViewById(R.id.rdoBtn_mine);
        rdobtnHome.setOnCheckedChangeListener(this);
        rdobtnCar.setOnCheckedChangeListener(this);
        rdobtnMine.setOnCheckedChangeListener(this);
        rdobtnHome.setChecked(true);
        tv_tip = (TextView) findViewById(R.id.tv2);
        Drawable drawable = getResources().getDrawable(R.drawable.bg_tab_roundtip);
        /// 这一步必须要做,否则不会显示.
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        tv_tip.setCompoundDrawables(null, null, drawable, null);
    }

    /**
     *  重置radioButton状态
      * @param state 第几tab被点击
     */
    private void setTab(int state) {
        //如果点击的是当前选中的tab就不处理
        if (firstState == state)
            return;
        firstState = state;
        rdobtnHome.setChecked(false);
        rdobtnCar.setChecked(false);
        rdobtnMine.setChecked(false);
        switch (state) {
            case 0:
                rdobtnHome.setChecked(true);
                tabhost.setCurrentTab(0);
                break;
            case 1:
                rdobtnCar.setChecked(true);
                tabhost.setCurrentTab(1);
                break;
            case 2:
                rdobtnMine.setChecked(true);
                tabhost.setCurrentTab(2);
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        /*只要chedk有变化都会进入 先执行第一个变化的，即被点击那个*/
        if (isChecked) {
            switch (buttonView.getId()) {
                case R.id.rdoBtn_home:
                    setTab(0);
                    break;
                case R.id.rdoBtn_shopcar:
                    setTab(1);
                    break;
                case R.id.rdoBtn_mine:
                    setTab(2);
                    break;
            }
        }
    }
}
