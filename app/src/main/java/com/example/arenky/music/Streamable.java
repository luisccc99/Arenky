package com.example.arenky.music;

import com.google.gson.annotations.SerializedName;

class Streamable {

    @SerializedName("#text")
    public final String text;

    @SerializedName("fulltrack")
    public final String fullTrack;

    Streamable(String text, String fullTrack) {
        this.text = text;
        this.fullTrack = fullTrack;
    }
}
