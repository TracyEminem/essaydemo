package com.luis.toucheventdemo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2020/8/31  10:21
 * desc   : 处理scrollView的第一种方法，复写onDispatchTouchEvent方法，横向移动的时候请求父类不要拦截，纵向移动请求父类拦截
 */
public class MyViewPager extends ViewPager {
    private static final String TAG = MyViewPager.class.getSimpleName();

    int lastX = -1;
    int lastY = -1;

    public MyViewPager(@NonNull Context context) {
        super(context);
    }

    /**
     * 必须要复写，不然在xml中引用该控件会报inflateException
     * @param context
     * @param attrs
     */
    public MyViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        int x = (int) ev.getRawX();
        int y = (int) ev.getRawY();
        int dealtX = 0;
        int dealtY = 0;

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                dealtX = 0;
                dealtY = 0;
                // 保证子View能够接收到Action_move事件
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                dealtX += Math.abs(x - lastX);
                dealtY += Math.abs(y - lastY);
                Log.i(TAG, "dealtX:=" + dealtX);
                Log.i(TAG, "dealtY:=" + dealtY);
                // 这里是够拦截的判断依据是左右滑动，读者可根据自己的逻辑进行是否拦截
                if (dealtX >= dealtY) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                } else {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_CANCEL:
                break;
            case MotionEvent.ACTION_UP:
                break;

        }

        return super.dispatchTouchEvent(ev);
    }
}
