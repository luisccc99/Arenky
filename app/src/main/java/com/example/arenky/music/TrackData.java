package com.example.arenky.music;

import com.google.gson.annotations.SerializedName;

public class TrackData {

    @SerializedName("name")
    public final String name;

    public TrackData(String name) {
        this.name = name;
    }
}
