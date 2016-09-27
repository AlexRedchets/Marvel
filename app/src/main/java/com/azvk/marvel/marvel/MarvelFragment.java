package com.azvk.marvel.marvel;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.azvk.marvel.MarvelInterface;
import com.azvk.marvel.MarvelModel;
import com.azvk.marvel.R;

import java.util.List;

import butterknife.ButterKnife;

public class MarvelFragment extends Fragment implements MarvelInterface.View{

    private static final String TAG = MarvelFragment.class.getSimpleName();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG, "onCreateView started");

        View view = inflater.inflate(R.layout.fragment_marvel, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onComplete(List<MarvelModel> data) {

    }

    @Override
    public void onError(String message) {

    }
}
