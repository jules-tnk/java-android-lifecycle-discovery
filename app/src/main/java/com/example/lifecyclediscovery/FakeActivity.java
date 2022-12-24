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

        Button goBackButton = (Button) findViewById(R.id.goBackButtonFakeActivity);
        Button copyButton = (Button) findViewById(R.id.copyButtonFakeActivity);
        Button startSecondFakeActivityButton = (Button) findViewById(R.id.startSecondFakeActivityButton);
        TextView destTextView = (TextView) findViewById(R.id.destTextViewFakeActivity);
        EditText editText = (EditText) findViewById(R.id.editTextFakeActivity);

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
                        Toast.makeText(FakeActivity.this, "Click on go back button", Toast.LENGTH_LONG).show();
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

}