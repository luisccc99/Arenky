package com.example.arenky.fragments;

import android.app.Activity;
import android.content.Context;
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
import com.example.arenky.MusicToMain;
import com.example.arenky.R;
import com.example.arenky.endPoints.HotelsAPI;
import com.example.arenky.endPoints.LastFmAPI;
import com.example.arenky.music.ResponseMusic;
import com.example.arenky.music.TrackData;

import java.util.List;

import com.example.arenky.hotels.SearchResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MusicListFragment extends Fragment {

    public static final String TOKEN = "236a0e52b7788f04f7de13a79c79d09a";
    private static final String TAG = MusicListFragment.class.getSimpleName();
    public static final String MUSIC_BASE_URL = "http://ws.audioscrobbler.com";


    private Retrofit retrofitMusic = null;

    private MusicAdapter musicAdapter;

    private String country;

    private List<TrackData> trackData;
    private MusicToMain toMain;

    RecyclerView recyclerViewTracks;
    TextView textViewCountry, textViewInfo;

    public MusicListFragment() {
        // Required empty public constructor
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof Activity) {
            toMain = (MusicToMain) context;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_music_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerViewTracks = view.findViewById(R.id.rec_view_tracks);
        textViewCountry = view.findViewById(R.id.country_music);
        textViewCountry.append(country);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerViewTracks.setLayoutManager(layoutManager);
        cargarDatos();
    }

    private void cargarDatos() {
        if (retrofitMusic == null) {
            retrofitMusic = new retrofit2.Retrofit.Builder()
                    .baseUrl(MUSIC_BASE_URL)
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
                musicAdapter = new MusicAdapter(getContext(), trackData);
                recyclerViewTracks.setAdapter(musicAdapter);
                onElementClicked();
                Log.d(TAG, "onResponse: " + trackData.size());
            }

            @Override
            public void onFailure(@NonNull Call<ResponseMusic> call, @NonNull Throwable t) {
                Log.e(TAG, "onFailure: ", t);
            }
        });
    }

    private void onElementClicked() {
        musicAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: " + "send mbid" + trackData
                        .get(recyclerViewTracks.getChildAdapterPosition(v)).mBid);
                toMain.sendTrackData(
                        trackData.get(recyclerViewTracks.getChildAdapterPosition(v))
                );
            }
        });
    }
}
