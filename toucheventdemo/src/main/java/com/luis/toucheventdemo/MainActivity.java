package com.luis.toucheventdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ScrollView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //scrowView 里面嵌套viewpager
        //viewpager里面嵌套viewpager
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
