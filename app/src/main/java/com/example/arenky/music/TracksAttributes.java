package com.example.arenky.music;

import com.google.gson.annotations.SerializedName;

public class TracksAttributes {
    @SerializedName("")
    public final String country;

    public TracksAttributes(String country) {
        this.country = country;
    }
}
