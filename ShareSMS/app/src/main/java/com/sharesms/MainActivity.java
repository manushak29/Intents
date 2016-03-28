package com.sharesms;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ShareActionProvider;

public class MainActivity extends AppCompatActivity {
    private ShareActionProvider mShareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //This works only for Activities, not Fragments.
    public void onShareButtonClicked(View view) {
        setShareIntent();
    }

    public void setShareIntent(){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("091882153"));
        intent.setType("vnd.android-dir/mms-sms");
        //SMS body is populated with this text.
        intent.putExtra("sms_body", "Hey There!");
        //The recipient's number is populated.
        intent.putExtra("address", "091882153");
        //How I should get real sms body?
        //intent.putExtra("sms_body", smsBody);
        intent.putExtra(Intent.EXTRA_TEXT, "Say Hi!");
        //intent.putExtra("exit_on_sent", true);
        //Launches sms application.
        startActivity(intent);
    }

/*    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_share, menu);
        MenuItem menuItem = menu.findItem(R.id.menu_item_share);
        //mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        //mShareActionProvider = (ShareActionProvider) menuItem.getActionProvider();
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem){
        Log.d("Selected", "YES");
        return super.onOptionsItemSelected(menuItem);
    }*/
}
