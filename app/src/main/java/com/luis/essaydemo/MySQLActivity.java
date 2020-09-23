package com.luis.essaydemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

public class MySQLActivity extends AppCompatActivity {
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what){
                case 0x11:
                    String s = (String) msg.obj;
                    mDatatv.setText(s);
                    break;
                case 0x12:
                    String ss = (String) msg.obj;
                    mDatatv.setText(ss);
                    break;
            }
        }
    };
    private Button mGetDataBtn;
    private TextView mDatatv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_s_q_l);
        mGetDataBtn = findViewById(R.id.btn_get_data);
        mDatatv = findViewById(R.id.tv_data);

        mGetDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDataFromSql();
            }
        });

    }

    private void getDataFromSql() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 调用数据库工具类DBUtils的getInfoByName方法获取数据库表中数据
                HashMap<String, Object> map = DBUtils.getInfoByName("015000045203");
                Message message = mHandler.obtainMessage();
                if(map != null){
                    String s = "";
                    for (String key : map.keySet()){
                        s += key + ":" + map.get(key) + "\n";
                    }
                    message.what = 0x12;
                    message.obj = s;
                }else {
                    message.what = 0x11;
                    message.obj = "查询结果为空";
                }
                // 发消息通知主线程更新UI
                mHandler.sendMessage(message);
            }
        }).start();

    }
}
