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

    public static void play() {
        mediaPlayer.start();
    }

    public static void pause() {
        mediaPlayer.pause();
    }

    public static void stop() {
        mediaPlayer.stop();
        currentTrack = null;
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

    public static void playNext() {
        try {
            position = (position+1) % tracklist.size();
            prepare(tracklist.get(position));
            play();
        } catch (IOException e) {
            position--;
            e.printStackTrace();
        }
    }

    public static void playPrevious() {
        try {
            position = (position-1) % tracklist.size();
            prepare(tracklist.get(position));
            play();
        } catch (IOException e) {
            position++;
            e.printStackTrace();
        }
    }

    public static void toolPlay(List<Track> tracklist) {
        MediaUtil.tracklist = tracklist;
        if (mediaPlayer.isPlaying()) {
            pause();
        } else {
            playNext();
        }
    }
}
