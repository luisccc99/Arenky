package com.example.arenky.music;

import com.google.gson.annotations.SerializedName;

public class TrackResponse {

    @SerializedName("track")
    public final TrackResponseInfo track;

    public TrackResponse(TrackResponseInfo track) {
        this.track = track;
    }
}
