package com.azvk.marvel.marvel;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.azvk.marvel.App;
import com.azvk.marvel.R;
import com.azvk.marvel.model.BookModel;
import com.azvk.marvel.model.MarvelRespond;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MarvelFragment extends Fragment implements MarvelInterface.View, MarvelAdapter.ClickListener{

    @Inject
    MarvelPresenter presenter;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private MarvelAdapter adapter;

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

        recyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new MarvelAdapter(getContext(), this) ;
        recyclerView.setAdapter(adapter);

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
        adapter.updateAdapter(data);
    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ((App)getActivity().getApplicationContext()).releaseMarvelComponent();
    }

    @Override
    public void onClick(BookModel bookModel) {
        Toast.makeText(getContext(), bookModel.getTitle(), Toast.LENGTH_LONG).show();
    }
}
