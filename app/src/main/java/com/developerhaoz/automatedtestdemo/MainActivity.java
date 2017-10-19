package com.developerhaoz.automatedtestdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTvInfo;
    private EditText mEtInfo;
    private Button mBtnSayHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvInfo = (TextView) findViewById(R.id.main_tv_hello);
        mEtInfo = (EditText) findViewById(R.id.main_et_info);
        findViewById(R.id.main_btn_say_hello).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }
}
