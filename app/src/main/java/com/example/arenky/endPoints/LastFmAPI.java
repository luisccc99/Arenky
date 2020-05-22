package com.example.arenky.endPoints;

import com.example.arenky.music.Tracks;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface LastFmAPI {

    @GET("?method=geo.gettoptracks&format=json")
    Call<Tracks> getTopTracks(@Query("country")String country, @Query("api_key")String key);

}
