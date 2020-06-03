package com.example.arenky.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.arenky.R;
import com.example.arenky.music.Artist;
import com.example.arenky.music.TrackData;

public class MusicDetailFragment extends Fragment {

    private TextView txtVwName;
    private TextView txtVwArtist;
    private TextView txtVwListeners;
    private TextView txtVwDuration;

    private Bundle mBundle;
    private TrackData trackData;

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

        mBundle = getArguments();
        trackData = null;
        setUIContent();
        return view;
    }

    @SuppressLint("SetTextI18n")
    private void setUIContent() {
        if (mBundle != null) {
            trackData = (TrackData) mBundle.getSerializable("trackData");
            assert trackData != null;
            Artist artist = trackData.artist;
            txtVwName.setText(trackData.name);
            txtVwArtist.setText(artist.name);
            txtVwListeners.setText("Oyentes " +
                    (Integer.parseInt(trackData.listeners)/1_000) + " k");
            txtVwDuration.setText("Duración " +
                    (Integer.parseInt(trackData.duration) / 60)  + " min "
                    +(Integer.parseInt(trackData.duration) % 60) + " seg"
            );
        }
    }
}
