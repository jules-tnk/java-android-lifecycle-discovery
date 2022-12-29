package com.example.lifecyclediscovery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button fakeActivityButton;
    private Button startDialogButton;
    private Button quitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("LIFECYCLE ", getLocalClassName() + " : onCreate");

        fakeActivityButton = (Button) findViewById(R.id.fakeActivityButton);
        startDialogButton = (Button) findViewById(R.id.startDialogButton);
        quitButton = (Button) findViewById(R.id.quitButton);

        fakeActivityButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "Click on fake activity button", Toast.LENGTH_LONG).show();
                        Log.i("CLICK BUTTON EVENT ", getLocalClassName() + " FAKE ACTIVITY BUTTON");
                        Intent fakeActivityIntent = new Intent(getApplicationContext(), FakeActivity.class);
                        startActivity(fakeActivityIntent);
                    }
                }
        );

        startDialogButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "Click on start dialog button", Toast.LENGTH_LONG).show();
                        Log.i("CLICK BUTTON EVENT ", getLocalClassName() + " START DIALOG BUTTON");
                        Intent fakeActivityIntent = new Intent(getApplicationContext(), DialogActivity.class);
                        startActivity(fakeActivityIntent);
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
        if (isFinishing()){
            System.exit(0);
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("LIFECYCLE ", getLocalClassName() + " : onRestart");
    }
}