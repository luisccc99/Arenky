package com.example.arenky.music;

import com.google.gson.annotations.SerializedName;

public class TrackResponseStreamable {

    @SerializedName("#text")
    public final String text;

    @SerializedName("fulltrack")
    public final String fulltrack;

    public TrackResponseStreamable(String text, String fulltrack) {
        this.text = text;
        this.fulltrack = fulltrack;
    }
}
