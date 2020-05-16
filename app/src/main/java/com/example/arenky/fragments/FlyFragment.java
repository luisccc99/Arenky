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

/**
 * A simple {@link Fragment} subclass.
 */
public class FlyFragment extends Fragment {

    public static interface FlyFragmentListener{
        void onClicked(String origin, String destination);
    }
    // en el codigo de arriba y abajo se agrega el listener para el fragment
    private FlyFragmentListener flyFragmentListener;

    Button btnBuscar;
    EditText txtOrigen;
    EditText txtDestino;

    FlightsListFragment flightsListFragment;

    private String origin;
    private String destination;

    public FlyFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof FlyFragmentListener) {
            flyFragmentListener = (FlyFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        flyFragmentListener = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fly, container, false);
        btnBuscar = view.findViewById(R.id.btnBuscar);
        txtOrigen = view.findViewById(R.id.txtOrigen);
        txtDestino = view.findViewById(R.id.txtDestino);


        btnBuscar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                origin = txtOrigen.getText() + "";
                destination = txtDestino.getText() + "";
                if (flyFragmentListener != null){
                    flyFragmentListener.onClicked(origin, destination);
                }

            }
        });
        return view;
    }
}
