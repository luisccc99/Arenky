package com.example.arenky.fragments;

import android.annotation.SuppressLint;
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
import android.widget.TextView;

import com.example.arenky.R;
import com.example.arenky.endPoints.HotelsAPI;
import com.example.arenky.hotels.BodySearchResults;
import com.example.arenky.hotels.HotelDataBody;
import com.example.arenky.hotels.HotelsResponse;
import com.example.arenky.hotels.HotelsResponseData;
import com.example.arenky.hotels.SearchHotelsResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HotelsListFragment extends Fragment {

    private static final String DESTINATION_ID = "destinationId";
    private static final String TAG = HotelsListFragment.class.getSimpleName();
    private Integer destinationId;

    private Retrofit retrofitHotels = null;

    private TextView textViewInfo;
    private RecyclerView recyclerViewHotels;

    public HotelsListFragment() {
        // Required empty public constructor
    }


    public static HotelsListFragment newInstance(int destinationId) {
        HotelsListFragment fragment = new HotelsListFragment();
        Bundle args = new Bundle();
        args.putInt(DESTINATION_ID, destinationId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            destinationId = getArguments().getInt(DESTINATION_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_hotels_list, container, false);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textViewInfo = view.findViewById(R.id.txt_info_hotels);
        textViewInfo.setText("destino: " + destinationId);
        recyclerViewHotels = view.findViewById(R.id.rec_view_hotels);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerViewHotels.setLayoutManager(layoutManager);
        cargarDatos();
    }

    private void cargarDatos() {
        if (retrofitHotels == null) {
            retrofitHotels = new retrofit2.Retrofit.Builder()
                    .baseUrl(HotelsQueryListSuggestions.HOTELS_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        HotelsAPI hotelsAPI = retrofitHotels.create(HotelsAPI.class);

        final Call<HotelsResponse> hotelsResponseCall = hotelsAPI
                .getHotels(destinationId);
        hotelsResponseCall.enqueue(new Callback<HotelsResponse>() {
            @Override
            public void onResponse(Call<HotelsResponse> call, Response<HotelsResponse> response) {
                assert response.body() != null;
                HotelsResponseData data = response.body().data;
                HotelDataBody body = data.body;
                BodySearchResults results = body.searchResults;
                List<SearchHotelsResult> hotels = results.hotelsResultsList;

                for (int i = 0; i < hotels.size(); i++) {
                    Log.d(TAG, "onResponse: " + hotels.get(i).hotelName + "\n" +
                            hotels.get(i).starRating);
                }
            }

            @Override
            public void onFailure(Call<HotelsResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage(), t);
            }
        });
    }
}