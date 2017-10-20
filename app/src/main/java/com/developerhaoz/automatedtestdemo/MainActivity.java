package com.developerhaoz.automatedtestdemo;

import android.os.Bundle;
import android.support.annotation.VisibleForTesting;
import android.support.test.espresso.IdlingResource;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * MainActivity
 *
 * @author Haoz
 * @date 2017/10/20.
 */

public class MainActivity extends AppCompatActivity {

    private TextView mTvInfo;
    private EditText mEtInfo;
    private Button mBtnSayHello;

    private static final String TAG = "MainActivity11111";

    @VisibleForTesting
    public IdlingResource getCountingIdingResource(){
        return EspressoIdlingResource.getIdlingResource();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvInfo = (TextView) findViewById(R.id.main_tv_hello);
        mEtInfo = (EditText) findViewById(R.id.main_et_info);
        final String testUrl = "http://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/48";
        getHttpInfo(testUrl);
        Log.d(TAG, "onCreate: ");

        findViewById(R.id.main_btn_say_hello).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EspressoIdlingResource.increment();
                getHttpInfo(testUrl);
            }
        });
    }

    private void getHttpInfo(String testUrl) {
        mTvInfo.setText("dffdf");
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(testUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                mTvInfo.setText(s);
                if(!EspressoIdlingResource.getIdlingResource().isIdleNow()){
                    EspressoIdlingResource.decrement();
                }
                Log.d(TAG, "onResponse: " + s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue.add(stringRequest);
    }
}
