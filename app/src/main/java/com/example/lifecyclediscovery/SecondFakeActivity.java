package com.example.lifecyclediscovery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SecondFakeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_fake);
    }
}