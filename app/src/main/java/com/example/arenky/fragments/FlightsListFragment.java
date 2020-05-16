package com.example.arenky.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.arenky.R;

public class FlightsListFragment extends Fragment {

    public FlightsListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_flights_list, container, false);
        cargarDatos();
        return view;
    }

    private void cargarDatos() {
        // TODO: HACER LLAMADA A API CON DATOS RECIBIDOS DE FLY FRAGMENT
    }
}
