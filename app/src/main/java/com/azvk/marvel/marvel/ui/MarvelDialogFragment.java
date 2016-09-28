package com.azvk.marvel.marvel.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.azvk.marvel.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MarvelDialogFragment extends DialogFragment {

    @BindView(R.id.dialog_button)
    Button button;

    private static final String TAG = MarvelDialogFragment.class.getSimpleName();

    public MarvelDialogFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG, "onCreateView started");

        View view = inflater.inflate(R.layout.fragment_dialog, container, false);
        ButterKnife.bind(this, view);

        getDialog().setTitle("Title Sample");

        button.setOnClickListener(v -> getDialog().cancel());

        return view;
    }
}
