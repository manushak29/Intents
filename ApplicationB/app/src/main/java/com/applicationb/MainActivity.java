package com.applicationb;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();

        if (Intent.ACTION_SEND.equals(action) && type != null) {
            if ("text/plain".equals(type)) {
                handleTextData(intent);
            } else if (type.startsWith("image/")) {
                handleBinaryData(intent);
            }
        } else if (Intent.ACTION_SEND_MULTIPLE.equals(action) && type != null) {
            if (type.startsWith("image/*")) {
                handleMultipleData(intent);
            }
        }
    }

    public void handleTextData(Intent intent) {
        String textData = intent.getStringExtra(Intent.EXTRA_TEXT);
        if (textData != null) {
            TextView textView = (TextView) findViewById(R.id.text);
            textView.setText(textData);
        }
    }

    public void handleBinaryData(Intent intent) {
        Uri imageUri = intent.getParcelableExtra(Intent.EXTRA_STREAM);
        if (imageUri != null) {
            ImageView imageView = (ImageView) findViewById(R.id.image);
            imageView.setImageURI(imageUri);
        }
    }

    public void handleMultipleData(Intent intent) {
        ArrayList<Uri> imgUris = intent.getParcelableArrayListExtra(Intent.EXTRA_STREAM);
        if(imgUris.size() != 0){
            ImageView imageView1 = (ImageView) findViewById(R.id.image1);
            imageView1.setImageURI(imgUris.get(0));
            ImageView imageView2 = (ImageView) findViewById(R.id.image2);
            imageView2.setImageURI(imgUris.get(1));
            ImageView imageView3 = (ImageView) findViewById(R.id.image3);
            imageView3.setImageURI(imgUris.get(2));
        }

    }
}

