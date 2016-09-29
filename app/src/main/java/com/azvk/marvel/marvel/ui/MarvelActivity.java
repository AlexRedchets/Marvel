package com.azvk.marvel.marvel.ui;

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
            Log.e(TAG, "savedInstanceState == null");
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_layout, new MarvelFragment())
                    .commit();
        }
    }
}
