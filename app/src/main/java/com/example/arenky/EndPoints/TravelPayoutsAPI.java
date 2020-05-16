package com.example.arenky.EndPoints;

import com.example.arenky.POJOs.FlightResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TravelPayoutsAPI {

    @GET("/v2/prices/month-matrix?currency=MXN&show_to_affiliates=true")
    Call<FlightResponse> getCalendarOfPricesForAMonth(@Query("origin") String origin,
                                                      @Query("destination") String destination,
                                                      @Query("token") String token);

}
