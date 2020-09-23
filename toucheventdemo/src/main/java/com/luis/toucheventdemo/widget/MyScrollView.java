package com.luis.toucheventdemo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2020/8/29  18:51
 * desc   : 处理scrollView的第一种方法，复写onIntercept方法，横向移动的时候不拦截事件
 */
public class MyScrollView extends ScrollView {
    private float mDownPosX = 0;
    private float mDownPosY = 0;

    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attributeSet){
        super(context);
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        float x = ev.getRawX();
        float y = ev.getRawY();

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mDownPosX = x;
                mDownPosY = y;

                break;
            case MotionEvent.ACTION_MOVE:
                float deltaX = Math.abs(x - mDownPosX);
                float deltaY = Math.abs(y - mDownPosY);
                //横向滑动不拦截
                if (deltaX > deltaY) {
                    return false;
                }
                break;

            case MotionEvent.ACTION_UP:
                break;

        }

        return super.onInterceptTouchEvent(ev);
    }
}
