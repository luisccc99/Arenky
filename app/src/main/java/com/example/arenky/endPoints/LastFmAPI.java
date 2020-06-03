package com.example.arenky.endPoints;

import com.example.arenky.music.ResponseMusic;
import com.example.arenky.music.TrackResponse;
import com.example.arenky.music.TrackResponseInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface LastFmAPI {

    @GET("/2.0/?method=geo.gettoptracks&format=json")
    Call<ResponseMusic> getTopTracks(@Query("country") String country, @Query("api_key") String key);

    @GET("/2.0/?method=track.getInfo&format=json")
    Call<TrackResponse> getTrackInfo(@Query("mbid") String id,
                                     @Query("api_key") String key);
}
