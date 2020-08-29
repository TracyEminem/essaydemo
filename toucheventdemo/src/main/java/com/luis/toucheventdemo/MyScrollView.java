package com.luis.toucheventdemo;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2020/8/29  18:51
 * desc   :
 */
public class MyScrollView extends ScrollView {
    public MyScrollView(Context context) {
        super(context);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        float x = ev.getRawX();
        float y = ev.getRawY();

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                
                break;
            case MotionEvent.ACTION_MOVE:
                break;

            case MotionEvent.ACTION_UP:
                break;

        }


        return super.dispatchTouchEvent(ev);
    }
}
