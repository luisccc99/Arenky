package com.example.arenky.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.arenky.R;
import com.example.arenky.endPoints.LastFmAPI;
import com.example.arenky.music.Artist;
import com.example.arenky.music.ResponseMusic;
import com.example.arenky.music.TrackData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MusicDetailFragment extends Fragment {

    private TextView txtVwName;
    private TextView txtVwArtist;
    private TextView txtVwListeners;
    private TextView txtVwDuration;
    private ImageView imgAlbum;

    private Bundle mBundle;
    private TrackData trackData;
    private Artist artist;
    private Retrofit retrofit = null;
    private static final String TAG = MusicDetailFragment.class.getSimpleName();

    public MusicDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_music_detail, container, false);
        txtVwName = view.findViewById(R.id.track_name_detail);
        txtVwArtist = view.findViewById(R.id.artist_detail);
        txtVwListeners = view.findViewById(R.id.listeners_detail);
        txtVwDuration = view.findViewById(R.id.duration_detail);
        imgAlbum = view.findViewById(R.id.album_image_detail);
        loadImageSample(view);
        mBundle = getArguments();
        trackData = null;
        setUIContent();
//        cargarImagen();
        return view;
    }

    private void loadImageSample(View v) {
        String url = "https://lastfm.freetls.fastly.net/i/u/300x300/e6b38ee9858b906470ba6826825b9354.png";

        Glide.with(v)
                .load(url)
                .centerCrop()
                .into(imgAlbum);
    }

    private void cargarImagen(View v) {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(MusicListFragment.MUSIC_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        LastFmAPI lastFmAPI = retrofit.create(LastFmAPI.class);

        final Call<ResponseMusic> responseMusicCall = lastFmAPI.getTrackInfo(artist.mBid,
                MusicListFragment.TOKEN);
        responseMusicCall.enqueue(new Callback<ResponseMusic>() {
            @Override
            public void onResponse(Call<ResponseMusic> call, Response<ResponseMusic> response) {

                Log.d(TAG, "onResponse: " + response.body().tracks);
            }

            @Override
            public void onFailure(Call<ResponseMusic> call, Throwable t) {

            }
        });

    }

    @SuppressLint("SetTextI18n")
    private void setUIContent() {
        if (mBundle != null) {
            trackData = (TrackData) mBundle.getSerializable("trackData");
            assert trackData != null;
            artist = trackData.artist;
            txtVwName.setText(trackData.name);
            txtVwArtist.setText(artist.name);
            txtVwListeners.setText("Oyentes " +
                    (Integer.parseInt(trackData.listeners) / 1_000) + " k");
            txtVwDuration.setText("Duración " +
                    (Integer.parseInt(trackData.duration) / 60) + " min "
                    + (Integer.parseInt(trackData.duration) % 60) + " seg"
            );
        }
    }
}
