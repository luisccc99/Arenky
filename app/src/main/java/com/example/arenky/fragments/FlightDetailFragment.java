
package com.example.arenky.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.arenky.R;
import com.example.arenky.flight.FlightData;

/**
 * A simple {@link Fragment} subclass.
 */
public class FlightDetailFragment extends Fragment {

    private FlightData flightData;

    public void setFlightData(FlightData flightData) {
        this.flightData = flightData;
    }

    public FlightDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_flight_detail, container, false);

        return view;
    }
}
