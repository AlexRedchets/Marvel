package com.azvk.marvel.marvel;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.azvk.marvel.R;
import com.azvk.marvel.model.BookModel;
import com.azvk.marvel.model.MarvelRespond;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MarvelAdapter extends RecyclerView.Adapter<MarvelAdapter.ViewHolder>{

    private MarvelRespond marvelRespond;
    private Context context;
    private String TAG = MarvelAdapter.class.getSimpleName();
    private ClickListener clickListener;

    public MarvelAdapter(Context context, ClickListener clickListener) {
        this.context = context;
        this.clickListener = clickListener;
    }

    public void updateAdapter(MarvelRespond respond){
        marvelRespond = respond;
        notifyDataSetChanged();
        Log.i(TAG, "Adapter is updated");
    }

    @Override
    public int getItemCount() {
        return marvelRespond != null ? marvelRespond.getData().getResults().size() : 0;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View view = inflater.inflate(R.layout.custom_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        BookModel currentData =  marvelRespond.getData().getResults().get(position);

        holder.title.setText(currentData.getTitle());
        Picasso.with(context).load(currentData.getImages().get(0).getPath() + ".jpg").into(holder.image);

    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.comics_title)
        TextView title;
        @BindView(R.id.comics_image)
        ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            clickListener.onClick(marvelRespond.getData().getResults().get(getAdapterPosition()));
        }
    }

    public interface ClickListener {

        void onClick(BookModel bookModel);
    }
}
