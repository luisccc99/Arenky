package com.example.arenky.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.arenky.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FlyFragment extends Fragment {

    Button btnBuscar;
    EditText txtOrigen;
    EditText txtDestino;

    public FlyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fly, container, false);
        btnBuscar = view.findViewById(R.id.btnBuscar);
        txtOrigen = view.findViewById(R.id.txtOrigen);
        txtDestino = view.findViewById(R.id.txtDestino);
        txtPrueba = view.findViewById(R.id.txtPrueba);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view != null){
                    FragmentTransaction mFragmentTransaction = getFragmentManager().beginTransaction();
                    Fragment flightsListFragment = new FlightsListFragment();
                    mFragmentTransaction.replace(R.id.container, flightsListFragment);
                    mFragmentTransaction.addToBackStack(null);
                    mFragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                    mFragmentTransaction.commit();
                }
            }
        });
        return view;
    }
}
