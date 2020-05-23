package com.example.arenky.music;

import com.google.gson.annotations.SerializedName;

public class ResponseMusic {

    @SerializedName("tracks")
    public final Tracks tracks;

    public ResponseMusic(Tracks tracks) {
        this.tracks = tracks;
    }
}
