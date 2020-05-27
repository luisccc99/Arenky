
package com.example.arenky.fragments;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.arenky.R;
import com.example.arenky.flight.FlightData;

import java.util.List;

public class FlightDetailFragment extends Fragment {

    private Bundle flightBundle;
    private FlightData flightData;

    private TextView txtVwGate;
    private TextView txtVwFoundAt;
    private TextView txtVwPrice;
    private TextView txtVwTripClass;
    private TextView txtVwTOrigin;
    private TextView txtVwDestination;
    private TextView txtVwDepart;
    private TextView txtVwReturn;
    private TextView txtVwDistance;
    private TextView txtVwDuration;
    private TextView txtVwActual;

    public FlightDetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_flight_detail, container, false);
        txtVwGate = view.findViewById(R.id.gate_details);
        txtVwFoundAt = view.findViewById(R.id.found_at_detail);
        txtVwPrice = view.findViewById(R.id.price_detail);
        txtVwTripClass = view.findViewById(R.id.trip_class_detail);
        txtVwTOrigin = view.findViewById(R.id.origin_detail);
        txtVwDestination = view.findViewById(R.id.destination_detail);
        txtVwDepart = view.findViewById(R.id.depart_date_detail);
        txtVwReturn = view.findViewById(R.id.return_date_detail);
        txtVwDistance = view.findViewById(R.id.distance_detail);
        txtVwDuration = view.findViewById(R.id.duration_detail);
        txtVwActual = view.findViewById(R.id.actual_detail);

        //crear objeto bundle para recibir datos
        flightBundle = getArguments();
        flightData = null;

        setUIContent();
        return view;
    }


    @SuppressLint("SetTextI18n")
    private void setUIContent() {
        // verificar existencia de argumentos enviados
        if (flightBundle != null) {
            flightData = (FlightData) flightBundle.getSerializable("flightData");

            assert flightData != null;
            txtVwGate.setText(flightData.gate);
            txtVwFoundAt.append(" " + flightData.foundAt);
            txtVwPrice.append(" " + flightData.value + " MXN");
            switch (flightData.tripClass) {
                case 0:
                    txtVwTripClass.append(" económica");
                    break;
                case 1:
                    txtVwTripClass.append(" negocios");
                    break;
                case 2:
                    txtVwTripClass.append(" primera");
                    break;
            }

            txtVwTOrigin.append(" " + flightData.origin);
            txtVwDestination.append(" " + flightData.destination);
            txtVwDepart.append(" " + flightData.departDate);
            txtVwReturn.append(" " + flightData.returnDate);
            txtVwDistance.append(" " + flightData.distance + " km");
            txtVwDuration.append(" " + flightData.duration + " min");

            if (flightData.actual) {
                txtVwActual.setBackgroundColor(Color.rgb(1, 137, 123));
            } else {
                txtVwActual.append("No", 0, 2);
                txtVwActual.setBackgroundColor(Color.rgb(216, 27, 96));
            }

        }
    }

}
