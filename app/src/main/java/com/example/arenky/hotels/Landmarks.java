package com.example.arenky.hotels;

import com.google.gson.annotations.SerializedName;

public class Landmarks {

    @SerializedName("label")
    public final String label;

    @SerializedName("distance")
    public final String distance;

    public Landmarks(String label, String distance) {
        this.label = label;
        this.distance = distance;
    }
}
