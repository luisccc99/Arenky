package com.example.arenky.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.arenky.R;
import com.example.arenky.music.TracksResponse;

import java.util.List;

public class MusicListFragment extends Fragment {

    private Bundle mBundleMusic;
    private String country;
    private List<TracksResponse> responses;

    RecyclerView recyclerViewTracks;
    TextView textViewCountry;


    public MusicListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_music_list, container, false);
        recyclerViewTracks = view.findViewById(R.id.rec_view_tracks);
        textViewCountry = view.findViewById(R.id.country_music);

        // obtener datos enviados desde el main activity
        mBundleMusic = getArguments();
        if (mBundleMusic != null) {
            country = mBundleMusic.getString("country");
        }

        textViewCountry.setText(country);
        textViewCountry.setHint("Musica más escuchada de " + country);

        cargarDatos();

        return view;
    }

    private void cargarDatos() {

    }
}
