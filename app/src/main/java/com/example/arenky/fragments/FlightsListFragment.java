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
import android.widget.Toast;

import com.example.arenky.FlightAdapter;
import com.example.arenky.FragToMain;
import com.example.arenky.R;
import com.example.arenky.endPoints.TravelPayoutsAPI;
import com.example.arenky.flight.FlightData;
import com.example.arenky.flight.FlightResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FlightsListFragment extends Fragment {

    private static final String TAG = FlightsListFragment.class.getSimpleName();
    private static Retrofit retrofit = null;

    private String origin;
    private String destination;

    public static List<FlightData> flightData;

    FragToMain fragToMain;

    private RecyclerView recyclerView;
    private FlightAdapter mFlightAdapter;

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public FlightsListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof Activity) {
            // si el contexto que esta llegando es una instancia de un activity
            fragToMain = (FragToMain) context;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_flights_list, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recViewFlights);
        // cuando es un activity es this pero como estamos en un fragment es getContext
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        cargarDatos();
    }

    private void cargarDatos() {
        // Aqui se hace la conexion a la API de Travel Payouts
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl("http://api.travelpayouts.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        TravelPayoutsAPI travelPayoutsAPI = retrofit.create(TravelPayoutsAPI.class);

        final Call<FlightResponse> flightResponseCall = travelPayoutsAPI
                .getCalendarOfPricesForAMonth(
                        origin, destination, "98983e1f8fecec70c5231f4a367f1b7e");

        flightResponseCall.enqueue(new Callback<FlightResponse>() {
            @Override
            public void onResponse(@NonNull Call<FlightResponse> call,
                                   @NonNull Response<FlightResponse> response) {
                assert response.body() != null;
                flightData = response.body().getDataList();
                mFlightAdapter = new FlightAdapter(getContext(), flightData);
                recyclerView.setAdapter(mFlightAdapter);

                // cada vez que se de un click en un elemento del recycler view
                clicked();

                // log para debugging
                Log.d(TAG, "onResponse:\n" +
                        "number of flights received " + flightData.size() + "\n" +
                        "success: " + response.body().getSuccess()
                );
            }

            @Override
            public void onFailure(@NonNull Call<FlightResponse> call,
                                  @NonNull Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage(), t);
            }
        });
    }

    private void clicked() {
        mFlightAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragToMain.sendFlightData(
                        // cuando se envia la view, se envia el objeto
                        flightData.get(recyclerView.getChildAdapterPosition(v)));
            }
        });
    }
}
