package com.example.deezersearch.Util;

import android.media.AudioManager;
import android.media.MediaPlayer;

import com.example.deezersearch.Model.Track;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class MediaUtil {

    private static MediaPlayer mediaPlayer = new MediaPlayer();
    static {
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                playNext();
            }
        });
    }
    private static Track currentTrack;
    private static int position = 0;
    private static List<Track> tracklist;

    public static void prepare(List<Track> tracklist, int position) {
        try {
            Track track = tracklist.get(position);
            prepare(track);
            MediaUtil.position = position;
            MediaUtil.tracklist = tracklist;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void prepare(Track track) throws IOException {
        mediaPlayer.reset();
        mediaPlayer.setDataSource(track.getPreview());
        mediaPlayer.prepare();
        currentTrack = track;
    }

    protected static void play() {
        mediaPlayer.start();
    }

    protected static void pause() {
        mediaPlayer.pause();
    }

    public static boolean isPaused() {
        return !mediaPlayer.isPlaying();
    }

    public static Track getCurrentTrack() {
        return currentTrack;
    }

    public static void release() {
        mediaPlayer.reset();
    }

    public static Track playNext() {
        try {
            position = (position+1) % tracklist.size();
            prepare(tracklist.get(position));
            play();
        } catch (IOException e) {
            position--;
            e.printStackTrace();
        }
        return tracklist.get(position);
    }

    public static Track playPrevious() {
        try {
            position = (position-1) % tracklist.size();
            prepare(tracklist.get(position));
            play();
        } catch (IOException e) {
            position++;
            e.printStackTrace();
        }
        return tracklist.get(position);
    }

    public static void setTracklist(List<Track> tracklist) {
        MediaUtil.tracklist = tracklist;
    }

    public static List<Track> getTracklist() {
        return tracklist;
    }

    protected static int getPosition() {
        return position;
    }
}
