package com.example.lifecyclediscovery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FakeActivity extends AppCompatActivity {
    private Button goBackButton;
    private Button copyButton;
    private Button startSecondFakeActivityButton;
    private TextView destTextView;
    private EditText editText;

    private String textToCopy;
    private final String TEXT_TO_COPY_KEY="COPIED_TEXT";

    public String getTextToCopy() {
        return textToCopy;
    }

    public void setTextToCopy(String textToCopy) {
        this.textToCopy = textToCopy;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fake);

        goBackButton = (Button) findViewById(R.id.goBackButtonFakeActivity);
        copyButton = (Button) findViewById(R.id.copyButtonFakeActivity);
        startSecondFakeActivityButton = (Button) findViewById(R.id.startSecondFakeActivityButton);
        destTextView = (TextView) findViewById(R.id.destTextViewFakeActivity);
        editText = (EditText) findViewById(R.id.editTextFakeActivity);

        if (savedInstanceState!=null){
            String copiedText = savedInstanceState.getString(TEXT_TO_COPY_KEY);
            if (copiedText!=null){
                destTextView.setText(copiedText);
            }
        }

        goBackButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(FakeActivity.this,
                                "Click on go back button",
                                Toast.LENGTH_LONG).show();
                        Log.i("CLICK BUTTON EVENT ", getLocalClassName() + " GO BACK BUTTON");
                        finish();
                    }
                }
        );

        copyButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Toast.makeText(FakeActivity.this, "Click on copy button", Toast.LENGTH_LONG).show();
                        Log.i("CLICK BUTTON EVENT ", getLocalClassName() + " COPY BUTTON");
                        String textToCopy = String.valueOf(editText.getText());
                        destTextView.setText(textToCopy);
                        setTextToCopy(textToCopy);
                    }
                }
        );
        startSecondFakeActivityButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent fakeActivityIntent = new Intent(getApplicationContext(), SecondFakeActivity.class);
                        startActivity(fakeActivityIntent);
                    }
                }
        );
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(TEXT_TO_COPY_KEY, getTextToCopy());
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
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("LIFECYCLE ", getLocalClassName() + " : onRestart");
    }

}