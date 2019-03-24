package com.example.deezersearch.Util.Adapter;

import android.provider.MediaStore;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.deezersearch.Activities.TrackActivity;
import com.example.deezersearch.Model.Track;
import com.example.deezersearch.R;
import com.example.deezersearch.Util.MediaUtil;

import java.io.IOException;
import java.util.List;

public class TrackAdapter extends RecyclerView.Adapter<TrackAdapter.ViewHolder> {

    private List<Track> dataSet;
    private ViewGroup parent;
    private TrackActivity trackActivity;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ConstraintLayout constraintLayout;
        ImageButton imageButton;
        ViewHolder(View v) {
            super(v);
            constraintLayout = (ConstraintLayout) v;
            textView = v.findViewById(R.id.track_title);
            imageButton = v.findViewById(R.id.play_button);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public TrackAdapter(List<Track> myDataset, TrackActivity context) {
        dataSet = myDataset;
        trackActivity = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public TrackAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
        this.parent = parent;
        ConstraintLayout v = (ConstraintLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.music_list, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textView.setText(dataSet.get(position).getTitle());
        final ImageButton imageButton = holder.imageButton;
        holder.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Track track = dataSet.get(position);
                if (MediaUtil.getCurrentTrack()!=null && MediaUtil.getCurrentTrack().equals(track)) {
                    if (MediaUtil.isPaused()) {
                        MediaUtil.play();
                        imageButton.setImageResource(android.R.drawable.ic_media_pause);
                    } else {
                        MediaUtil.pause();
                        imageButton.setImageResource(android.R.drawable.ic_media_play);
                    }
                } else {
                    MediaUtil.stop();
                    MediaUtil.prepare(dataSet, position);
                    MediaUtil.play();
                    trackActivity.setPlayingTrack(dataSet.get(position));
                    imageButton.setImageResource(android.R.drawable.ic_media_pause);
                }
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}