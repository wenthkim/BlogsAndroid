package com.wenthkim.blogs.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.TextView;

import com.wenthkim.blogs.R;

/**
 * Created by wenth on 2016/8/26.
 */

public class CustomViewDemo extends AppCompatActivity implements GestureDetector.OnGestureListener{

    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customviewdemo);
        textView = (TextView) findViewById(R.id.tv);
        test();
    }
    /*
        自定义view常用工具
        Configuration
        ViewConfiguration
        GestureDetector
        VelocityTracker
        Scroller
        ViewDragHelper*/
    private void test() {
        Configuration configration = getResources().getConfiguration();
        //获取国家代码
        int ccode = configration.mcc;
        //获取网络号
        int mnc = configration.mnc;
        //判断是否坚屏
        if (configration.orientation == Configuration.ORIENTATION_PORTRAIT) {
         //   textView.setText("code:"+ccode +"   mnc:"+mnc + "true");
        }

        ViewConfiguration  viewConfiguration= ViewConfiguration.get(this);
//获取touchSlop。该值表示系统所能识别出的被认为是滑动的最小距离
        int touchSlop = viewConfiguration.getScaledTouchSlop();
//获取Fling速度的最小值和最大值
        int minimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        int maximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
//判断是否有物理按键
        boolean isHavePermanentMenuKey=viewConfiguration.hasPermanentMenuKey();

        //双击间隔时间.在该时间内是双击，否则是单击
        int doubleTapTimeout=ViewConfiguration.getDoubleTapTimeout();
//按住状态转变为长按状态需要的时间
        int longPressTimeout=ViewConfiguration.getLongPressTimeout();
//重复按键的时间
        int keyRepeatTimeout=ViewConfiguration.getKeyRepeatTimeout();
    }



    //手指按下时调用该方法
    @Override
    public boolean onDown(MotionEvent e) {
        System.out.println("手指按下");
        return false;
    }
    //手指在屏幕上按下,且未移动和松开时调用该方法
    @Override
    public void onShowPress(MotionEvent e) {
        System.out.println("onShowPress");
    }
    // //轻击屏幕时调用该方法
    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        System.out.println("onSingleTapUp");
        return false;
    }
    //手指在屏幕上滚动时会调用该方法

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        System.out.println("onScroll");
        return false;
    }
    //长按时调用
    @Override
    public void onLongPress(MotionEvent e) {
        System.out.println("onLongPress");
}
    //手指在屏幕上拖动时会调用该方法
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        System.out.println("onFling");
        return false;
    }
}
