package com.example.deezersearch.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.deezersearch.Model.AlbumData;
import com.example.deezersearch.R;
import com.example.deezersearch.Util.Adapter.AlbumAdapter;
import com.example.deezersearch.Util.GsonRequest;

public class ArtistActivity extends AppCompatActivity {
    private static String url = "https://api.deezer.com/2.0/search/album?q=artist:";
    private RecyclerView recyclerView;
    private String artistName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);

        Intent myIntent = getIntent();
        artistName = myIntent.getStringExtra("artist");

        recyclerView = findViewById(R.id.album_list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        final RequestQueue queue = Volley.newRequestQueue(this);

        String requestUrl = url + "'" + artistName + "'";
        GsonRequest gsonRequest =
                new GsonRequest(requestUrl, AlbumData.class, null,
                        new Response.Listener() {
                            @Override
                            public void onResponse(Object response) {
                                RecyclerView.Adapter adapter = new AlbumAdapter(((AlbumData) response).getAlbums());
                                recyclerView.setAdapter(adapter);
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        queue.add(gsonRequest);
    }
}
