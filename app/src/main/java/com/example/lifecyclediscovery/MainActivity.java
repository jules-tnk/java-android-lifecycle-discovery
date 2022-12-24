package com.example.lifecyclediscovery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("LIFECYCLE ", getLocalClassName() + " : onCreate");

        Button fakeActivityButton = (Button) findViewById(R.id.fakeActivityButton);
        Button startDialogButton = (Button) findViewById(R.id.startDialogButton);
        Button quitButton = (Button) findViewById(R.id.quitButton);

        fakeActivityButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "Click on fake activity button", Toast.LENGTH_LONG).show();
                        Log.i("CLICK BUTTON EVENT ", getLocalClassName() + " FAKE ACTIVITY BUTTON");
                    }
                }
        );

        startDialogButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "Click on start dialog button", Toast.LENGTH_LONG).show();
                        Log.i("CLICK BUTTON EVENT ", getLocalClassName() + " START DIALOG BUTTON");
                    }
                }
        );
        quitButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.i("CLICK BUTTON EVENT ", getLocalClassName() + " QUIT BUTTON");
                        finish();
                    }
                }
        );
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("LIFECYCLE ", getLocalClassName() + " : onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("LIFECYCLE ", getLocalClassName() + " : onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("LIFECYCLE ", getLocalClassName() + " : onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("LIFECYCLE ", getLocalClassName() + " : onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("LIFECYCLE ", getLocalClassName() + " : onDestroy");
        if (!isFinishing()){
            System.exit(0);
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("LIFECYCLE ", getLocalClassName() + " : onRestart");
    }
}