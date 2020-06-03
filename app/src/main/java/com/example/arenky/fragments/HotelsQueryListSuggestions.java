package com.example.arenky.fragments;

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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.arenky.R;
import com.example.arenky.SuggestionsAdapter;
import com.example.arenky.endPoints.HotelsAPI;
import com.example.arenky.hotels.EntityHotel;
import com.example.arenky.hotels.SearchResponse;
import com.example.arenky.hotels.SuggestionsFromSearch;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class HotelsQueryListSuggestions extends Fragment {

    private static final String TAG = HotelsQueryListSuggestions.class.getSimpleName();
    private static final String HOTELS_BASE_URL = "https://hotels4.p.rapidapi.com";

    private Retrofit retrofitSuggestions = null;
    private SuggestionsAdapter suggestionsAdapter;

    private TextView textViewInfo;
    private RecyclerView recyclerViewSuggestions;

    private String query = "";

    private List<SuggestionsFromSearch> suggestions;

    public HotelsQueryListSuggestions() {
        // Required empty public constructor
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_hotels_query_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textViewInfo = view.findViewById(R.id.txt_view_info);
        recyclerViewSuggestions = view.findViewById(R.id.rec_view_suggestions);
        textViewInfo.append(query);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerViewSuggestions.setLayoutManager(layoutManager);
        cargarDatos();

    }

    private void cargarDatos() {
        if (retrofitSuggestions == null) {
            retrofitSuggestions = new retrofit2.Retrofit.Builder()
                    .baseUrl(HOTELS_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        HotelsAPI hotelsAPI = retrofitSuggestions.create(HotelsAPI.class);

        final Call<SearchResponse> responseCall = hotelsAPI
                .getSuggestions("es_MX", query);
        responseCall.enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(@NonNull Call<SearchResponse> call,
                                   @NonNull Response<SearchResponse> response) {
                assert response.body() != null;
                suggestions = response.body().suggestions;
                Log.d(TAG, "onResponse: " + suggestions.size());
                SuggestionsFromSearch cityGroup = suggestions.get(0);
                List<EntityHotel> entityHotels = cityGroup.entitiesList;
                suggestionsAdapter = new SuggestionsAdapter(getContext(), entityHotels);
                recyclerViewSuggestions.setAdapter(suggestionsAdapter);
                for (int i = 0; i < entityHotels.size(); i++) {
                    Log.d(TAG, "onResponse: \n" + i + " " + entityHotels.get(i));
                }
            }

            @Override
            public void onFailure(@NonNull Call<SearchResponse> call, @NonNull Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage()
                        + "\n" + t.getLocalizedMessage(), t);
            }
        });
    }


}