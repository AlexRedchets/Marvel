package com.azvk.marvel.marvel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.azvk.marvel.R;

public class MarvelActivity extends AppCompatActivity {

    private static final String TAG = MarvelActivity.class.getSimpleName();

    protected void onCreate(Bundle savedInstanceState) {
        Log.e(TAG, "onCreate started");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marvel);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_layout, new MarvelFragment())
                    .commit();
        }
    }



    /*String stringToHash = timeStamp + privateKey + publicKey;
        String hash = DigestUtils.md5Hex(stringToHash);

        String url = String.format("http://gateway.marvel.com/v1/public/comics?ts=%d&apikey=%s&hash=%s&limit=%d", timeStamp, publicKey, hash, limit);
        //String output = new Resty().text(url).toString();
        Log.i(MarvelActivity.class.getSimpleName(), url);*/

}
