package com.example.arenky.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.arenky.MusicAdapter;
import com.example.arenky.R;
import com.example.arenky.endPoints.LastFmAPI;
import com.example.arenky.music.ResponseMusic;
import com.example.arenky.music.TrackData;
import com.example.arenky.music.Tracks;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MusicListFragment extends Fragment {

    private static final String TOKEN = "236a0e52b7788f04f7de13a79c79d09a";
    private static final String TAG = MusicListFragment.class.getSimpleName();
    private Retrofit retrofitMusic = null;

    private String country;
    private List<TrackData> trackData;

    RecyclerView recyclerViewTracks;
    TextView textViewCountry;

    public MusicListFragment() {
        // Required empty public constructor
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_music_list, container, false);
        recyclerViewTracks = view.findViewById(R.id.rec_view_tracks);
        textViewCountry = view.findViewById(R.id.country_music);
        textViewCountry.append("\n" + country);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerViewTracks = view.findViewById(R.id.rec_view_tracks);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerViewTracks.setLayoutManager(layoutManager);
        cargarDatos();
    }

    private void cargarDatos() {
        if (retrofitMusic == null) {
            retrofitMusic = new retrofit2.Retrofit.Builder()
                    .baseUrl("http://ws.audioscrobbler.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        LastFmAPI lastFmAPI = retrofitMusic.create(LastFmAPI.class);

        final Call<ResponseMusic> responseCall = lastFmAPI
                .getTopTracks(country, TOKEN);
        responseCall.enqueue(new Callback<ResponseMusic>() {
            @Override
            public void onResponse(@NonNull Call<ResponseMusic> call,
                                   @NonNull Response<ResponseMusic> response) {
                assert response.body() != null;
                trackData = response.body().tracks.trackDataList;
                MusicAdapter musicAdapter = new MusicAdapter(getContext(), trackData);
                recyclerViewTracks.setAdapter(musicAdapter);

                Log.d(TAG, "onResponse: " + trackData.size());
            }

            @Override
            public void onFailure(@NonNull Call<ResponseMusic> call, @NonNull Throwable t) {
                Log.e(TAG, "onFailure: ", t);
            }
        });
    }
}
