package com.example.lifecyclediscovery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondFakeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_fake);

        Button goBackButton = (Button) findViewById(R.id.goBackSecondFakeActivityButton);

        goBackButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(SecondFakeActivity.this, "Click on go back button", Toast.LENGTH_LONG).show();
                        Log.i("CLICK BUTTON EVENT ", getLocalClassName() + " GO BACK BUTTON");
                        finish();
                    }
                }
        );

    }
}