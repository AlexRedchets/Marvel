package com.azvk.marvel.marvel.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.azvk.marvel.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MarvelDialogFragment extends DialogFragment {

    @BindView(R.id.dialog_button)
    Button button;
    @BindView(R.id.dialog_image)
    ImageView image;
    @BindView(R.id.dialog_title_input)
    TextView title;
    @BindView(R.id.dialog_format_input)
    TextView format;
    @BindView(R.id.dialog_pagecount_input)
    TextView pageCount;
    @BindView(R.id.dialog_price_input)
    TextView price;
    @BindView(R.id.dialog_creators_input)
    TextView creators;


    private static final String TAG = MarvelDialogFragment.class.getSimpleName();

    public MarvelDialogFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG, "onCreateView started");

        View view = inflater.inflate(R.layout.fragment_dialog, container, false);
        ButterKnife.bind(this, view);

        getDialog().setTitle("Information");

        button.setOnClickListener(v -> getDialog().cancel());

        Bundle args = getArguments();

        //Checking image source
        if (args.containsKey("image")){
            Picasso.with(getContext()).load(args.getString("image") + ".jpg").into(image);
        }

        //Checking title source
        if (args.containsKey("title")){
            title.setText(args.getString("title"));
        }
        else{
            title.setText(R.string.no_title);
        }

        //Checking format source
        if (args.containsKey("format")){
            format.setText(args.getString("format"));
        }
        else{
            format.setText(R.string.no_format);
        }

        //Checking pages source
        if (args.containsKey("pages")){
            pageCount.setText(String.valueOf(args.getInt("pages")));
        }
        else{
            pageCount.setText(R.string.no_pages);
        }

        //Checking price source
        if (args.containsKey("price")){
            price.setText("$" + String.valueOf(args.getDouble("price")));
        }
        else{
            price.setText(R.string.no_price);
        }

        //Checking creators source
        if (args.containsKey("creators")){
            creators.setText(args.getString("creators"));
        }
        else{
            creators.setText(R.string.no_creators);
        }

        return view;
    }
}
