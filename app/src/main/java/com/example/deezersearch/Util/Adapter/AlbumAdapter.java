package com.example.deezersearch.Util.Adapter;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.deezersearch.Activities.TrackActivity;
import com.example.deezersearch.Model.Album;
import com.example.deezersearch.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {

    private List<Album> dataSet;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ImageView imageView;
        public CardView cardView;
        public ViewHolder(View v) {
            super(v);
            cardView = (CardView) v;
            textView = v.findViewById(R.id.card_textView);
            imageView = v.findViewById(R.id.card_imageView);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public AlbumAdapter(List<Album> myDataset) {
        dataSet = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public AlbumAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        // create a new view
        CardView v = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_list, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textView.setText(dataSet.get(position).getTitle());
        Picasso.get().load(dataSet.get(position).getCoverBig()).into(holder.imageView);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), TrackActivity.class);
                intent.putExtra("tracklist", dataSet.get(position).getTracklist());
                intent.putExtra("cover", dataSet.get(position).getCoverMedium());
                v.getContext().startActivity(intent);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}