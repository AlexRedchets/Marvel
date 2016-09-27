package com.azvk.marvel.marvel;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.azvk.marvel.App;
import com.azvk.marvel.R;
import com.azvk.marvel.model.MarvelRespond;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class MarvelFragment extends Fragment implements MarvelInterface.View{

    @Inject
    MarvelPresenter presenter;

    private static final String TAG = MarvelFragment.class.getSimpleName();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        resolveDependencies();
    }

    private void resolveDependencies() {
        ((App)getActivity().getApplicationContext()).getMarvelComponent(this).inject(this);
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
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Log.e(TAG, "onViewCreated started");
        super.onViewCreated(view, savedInstanceState);

        presenter.fetchData();
    }

    @Override
    public void onComplete(MarvelRespond data) {
        Toast.makeText(getActivity(), "DONE!!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ((App)getActivity().getApplicationContext()).releaseMarvelComponent();
    }
}
