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
import com.example.arenky.music.TrackResponse;
import com.example.arenky.music.TrackResponseInfo;

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
    private String mbid;
    private Retrofit retrofit = null;
    private static final String TAG = MusicDetailFragment.class.getSimpleName();

    public MusicDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_music_detail, container, false);
        txtVwName = view.findViewById(R.id.track_name_detail);
        txtVwArtist = view.findViewById(R.id.artist_detail);
        txtVwListeners = view.findViewById(R.id.listeners_detail);
        txtVwDuration = view.findViewById(R.id.duration_detail);
        imgAlbum = view.findViewById(R.id.album_image_detail);
        mBundle = getArguments();
        trackData = null;
        setUIContent(view);
        return view;
    }

    private void loadImageSample(View v, String url) {
        Glide.with(v)
                .load(url)
                .centerCrop()
                .placeholder(R.drawable.cargar)
                .into(imgAlbum);
    }

    private void cargarImagen(final View v, String id) {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(MusicListFragment.MUSIC_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        LastFmAPI lastFmAPI = retrofit.create(LastFmAPI.class);

        final Call<TrackResponse> responseCall = lastFmAPI
                .getTrackInfo(id, MusicListFragment.TOKEN);

        responseCall.enqueue(new Callback<TrackResponse>() {
            @Override
            public void onResponse(Call<TrackResponse> call, Response<TrackResponse> response) {
                assert response.body() != null;
                Log.d(TAG, "onResponse: " + response.body().track.mbid);
                loadImageSample(v, response.body().track.album.albumImage.get(3).textUrl);
            }

            @Override
            public void onFailure(Call<TrackResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage(), t);
            }
        });


    }

    @SuppressLint("SetTextI18n")
    private void setUIContent(View view) {
        if (mBundle != null) {
            trackData = (TrackData) mBundle.getSerializable("trackData");
            assert trackData != null;
            artist = trackData.artist;
            mbid = trackData.mBid;
            cargarImagen(view, mbid);

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
