package com.example.custom.heard.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.custom.heard.R;

public class HeardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heard);
        Log.e("TAG","this is tag");
        Log.e("TAG","this is tag2");


        Log.e("TAG","this is tag3");
    }
}
