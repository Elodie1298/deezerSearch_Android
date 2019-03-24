package com.example.deezersearch.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.deezersearch.Model.Track;
import com.example.deezersearch.Model.TrackData;
import com.example.deezersearch.R;
import com.example.deezersearch.Util.Adapter.TrackAdapter;
import com.example.deezersearch.Util.GsonRequest;
import com.example.deezersearch.Util.MediaUtil;
import com.example.deezersearch.Util.PlaybarUtil;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TrackActivity extends AppCompatActivity {
    private static String url;
    private static String cover;
    private RecyclerView recyclerView;
    private static List<Track> tracklist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);

        Intent myIntent = getIntent();
        url = myIntent.getStringExtra("tracklist");
        cover = myIntent.getStringExtra("cover");
        ImageView coverView = findViewById(R.id.track_tool_cover);
        Picasso.get().load(cover).into(coverView);

        recyclerView = findViewById(R.id.music_list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        final RequestQueue queue = Volley.newRequestQueue(this);

        String requestUrl = url;
        final TrackActivity context = this;
        GsonRequest gsonRequest =
                new GsonRequest(requestUrl, TrackData.class, null,
                        new Response.Listener() {
                            @Override
                            public void onResponse(Object response) {
                                tracklist = ((TrackData) response).getTracks();
                                MediaUtil.setTracklist(tracklist);
                                RecyclerView.Adapter adapter = new TrackAdapter(tracklist, context);
                                recyclerView.setAdapter(adapter);
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println(error);
                    }
                });

        queue.add(gsonRequest);

        PlaybarUtil.getInstance(this);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                || keyCode == KeyEvent.KEYCODE_HOME
                || keyCode == KeyEvent.KEYCODE_APP_SWITCH) {
            MediaUtil.release();
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void setPlayingTrackInfo(Track track) {
        TextView title = findViewById(R.id.track_tool_title);
        TextView artist = findViewById(R.id.track_tool_artist);

        title.setText(track.getTitle());
        artist.setText(track.getArtist().getName());
    }
}
