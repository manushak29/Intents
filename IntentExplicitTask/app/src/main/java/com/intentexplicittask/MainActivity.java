package com.intentexplicittask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 501;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onChangeClicked(View view) {
        Intent intent = new Intent(this, DataReceiver.class);
        intent.putExtra("text", "Bla Bla");
        intent.putExtra("number", 10);
        startActivityForResult(intent, REQUEST_CODE);
    }


    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (REQUEST_CODE == requestCode && resultCode == RESULT_OK) {
            String text = intent.getStringExtra("text");
            if (text != null) {
                TextView textView = (TextView) findViewById(R.id.text);
                textView.setText(text);
            }

            int num = intent.getIntExtra("number", -1);
            if (num != -1) {
                TextView number = (TextView) findViewById(R.id.number);
                number.setText(String.valueOf(num));
            }
        }
    }
}
