package com.luis.toucheventdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ScrollView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //scrowView 里面嵌套viewpager,有两种方法可以处理？一、自定义父View,重写onInterCeptTouchEvent方法,横向移动的时候不拦截触摸事件。二、自定义子view,复写dispatchTouchEvent方法，横向移动的时候请求父view不要拦截触摸事件，否则请求父view拦截
        //viewpager里面嵌套viewpager, 详细见widget包中ChildViewPager控件，子viewPager中复写dispatchTouchEvent方法，判断是第一页或者最后一页则请求父view拦截触摸事件，这样触摸事件就不会下发到子View中
        ScrollView sv = findViewById(R.id.sv);
        ViewPager vp = findViewById(R.id.vp);

        ArrayList<View> list = new ArrayList<>();
        LayoutInflater layoutInflater = getLayoutInflater();
        list.add(layoutInflater.inflate(R.layout.view_vp,null,false));
        list.add(layoutInflater.inflate(R.layout.view_vp,null,false));
        list.add(layoutInflater.inflate(R.layout.view_vp,null,false));
        list.add(layoutInflater.inflate(R.layout.view_vp,null,false));
        list.add(layoutInflater.inflate(R.layout.view_vp,null,false));

        VpAdapter vpAdapter = new VpAdapter(list);
        vp.setAdapter(vpAdapter);
    }
}
