package com.zhi.widget.list.samples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zhi.volley.ZhiVolley;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ZhiVolley.getInstance().init(this);
    }
}
