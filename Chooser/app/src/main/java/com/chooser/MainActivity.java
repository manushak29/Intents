package com.chooser;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSendTextClicked(View view) {
        Log.d("Text", "Clicked");
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, "You're Awesome!");
        intent.setType("text/plain");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(Intent.createChooser(intent, "Choose App..."));
        }

    }

    public void onSendImageClicked(View view) {
        Log.d("Image", "Clicked");
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        Uri imgUri = Uri.parse("android.resource://com.chooser/drawable/image");
        intent.putExtra(intent.EXTRA_STREAM, imgUri);
        intent.setType("image/jpeg");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(Intent.createChooser(intent, "Share Via..."));
        }

    }

    public void onSendMultipleClicked(View view) {
        Log.d("Multiple", "Clicked");

        ArrayList<Uri> imageUris = new ArrayList<>();
        Uri imgUri1 = Uri.parse("android.resource://com.chooser/drawable/image1");
        Uri imgUri2 = Uri.parse("android.resource://com.chooser/drawable/image2");
        Uri imgUri3 = Uri.parse("android.resource://com.chooser/drawable/image3");
        imageUris.add(imgUri1);
        imageUris.add(imgUri2);
        imageUris.add(imgUri3);
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND_MULTIPLE);
        intent.setType("image/*");
        intent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, imageUris);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(Intent.createChooser(intent, "Share images to.."));
        }
    }

    /*QUESTIONS*/
    //This prevents chooser from showing up. Why?
    //intent.setPackage("bla");
    //Does not work. What to write instead?
    //intent.setPackageName("com.facebook.katana");
}
