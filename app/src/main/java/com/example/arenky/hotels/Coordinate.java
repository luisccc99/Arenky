package com.example.arenky.hotels;

import com.google.gson.annotations.SerializedName;

public class Coordinate {

    @SerializedName("lat")
    public final Double lat;

    @SerializedName("lon")
    public final Double lon;

    public Coordinate(Double lat, Double lon) {
        this.lat = lat;
        this.lon = lon;
    }
}
