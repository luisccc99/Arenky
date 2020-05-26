package com.example.arenky.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.arenky.R;

public class HomeFragment extends Fragment {
    private EditText edtTxtCountry;
    private Button btnSearchTrack;
    private String country;
    private MusicFragmentListener musicFragmentListener;

    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        edtTxtCountry = view.findViewById(R.id.country);
        btnSearchTrack = view.findViewById(R.id.btn_search_track);
        btnSearchTrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                country = edtTxtCountry.getText() + "";
                if (musicFragmentListener != null) {
                    musicFragmentListener.onButtonSearchTrackListener(country);
                }
            }
        });
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof MusicFragmentListener) {
            musicFragmentListener = (MusicFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement MusicFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        musicFragmentListener = null;
    }

    public interface MusicFragmentListener {
        void onButtonSearchTrackListener(String country);
    }
}
