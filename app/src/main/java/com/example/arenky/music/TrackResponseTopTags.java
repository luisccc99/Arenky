package com.example.arenky.music;

import com.google.gson.annotations.SerializedName;

public class TrackResponseTopTags {

    @SerializedName("tag")
    public final TrackResponseTag tag;

    public TrackResponseTopTags(TrackResponseTag tag) {
        this.tag = tag;
    }
}
