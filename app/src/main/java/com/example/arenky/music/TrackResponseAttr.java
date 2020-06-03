package com.example.arenky.music;

import com.google.gson.annotations.SerializedName;

public class TrackResponseAttr {

    @SerializedName("position")
    public final String position;


    public TrackResponseAttr(String position) {
        this.position = position;
    }
}
