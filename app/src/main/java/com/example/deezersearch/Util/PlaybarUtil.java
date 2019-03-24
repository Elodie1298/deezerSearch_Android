package com.example.deezersearch.Util;

import android.app.Activity;
import android.support.design.widget.FloatingActionButton;
import android.view.View;

import com.example.deezersearch.Activities.TrackActivity;
import com.example.deezersearch.Model.Track;
import com.example.deezersearch.R;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class PlaybarUtil {

    private TrackActivity activity;
    private static HashMap<TrackActivity, PlaybarUtil>instances = new HashMap<>();

    private FloatingActionButton fabPlayPause;
    private FloatingActionButton fabPrev;
    private FloatingActionButton fabNext;

    private boolean isPlaying = false;

    private PlaybarUtil(TrackActivity activity) {
        this.activity = activity;
        fabPlayPause = activity.findViewById(R.id.track_tool_play);
        fabPrev = activity.findViewById(R.id.track_tool_previous);
        fabNext = activity.findViewById(R.id.track_tool_next);

        fabPlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Track> trackList = MediaUtil.getTracklist();
                int i;
                if (MediaUtil.getCurrentTrack() == null) {
                    Random r = new Random();
                    i = r.nextInt(trackList.size());
                } else {
                    i = MediaUtil.getPosition();
                }
                System.out.println("i = " + i);
                System.out.println(trackList.size());
                playpause(trackList, i);
            }
        });
        fabPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previous();
            }
        });
        fabNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
            }
        });
    }

    public static PlaybarUtil getInstance(TrackActivity activity) {

        if (instances.get(activity) == null) {
            instances.put(activity, new PlaybarUtil(activity));
        }
        return instances.get(activity);
    }

    public void playpause(List<Track> dataSet, int position) {
        Track track = dataSet.get(position);
        System.out.println("MediaUtil.getCurrentTrack() = " + MediaUtil.getCurrentTrack());
        System.out.println("track = " + track);
        if (MediaUtil.getCurrentTrack()!=null && MediaUtil.getCurrentTrack().equals(track)) {
            if (MediaUtil.isPaused()) {
                System.out.println("play");
                MediaUtil.play();
                setPauseButton();
            } else {
                System.out.println("pause");
                MediaUtil.pause();
                setPlayButton();
            }
        } else {
            System.out.println("play new");
            MediaUtil.prepare(dataSet, position);
            MediaUtil.play();
            activity.setPlayingTrackInfo(dataSet.get(position));
            setPauseButton();
        }
        isPlaying = !isPlaying;
    }

    public void previous() {
        activity.setPlayingTrackInfo(MediaUtil.playPrevious());
    }

    public void next() {
        activity.setPlayingTrackInfo(MediaUtil.playNext());
    }

    public void setPauseButton() {
        fabPlayPause.setImageResource(android.R.drawable.ic_media_pause);
    }
    public void setPlayButton() {
        fabPlayPause.setImageResource(android.R.drawable.ic_media_play);
    }
}
