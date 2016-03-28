package com.intentexplicittask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Anna on 28/03/2016.
 */
public class DataReceiver extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_receiver);

        Intent intent = getIntent();
        String text = intent.getStringExtra("text");
        if(text != null){
            TextView textview = (TextView)findViewById(R.id.text);
            textview.setText(text);
        }

        int num = intent.getIntExtra("number", -1);
        if(num != -1){
            TextView number = (TextView)findViewById(R.id.number);
            number.setText(String.valueOf(num));
        }
    }

    public void onChangeDataClicked(View view){
        Intent intent = new Intent();
        intent.putExtra("text", "What's up?");
        intent.putExtra("number", 1000);
        setResult(RESULT_OK, intent);
        finish();
    }
}
