package com.example.arenky.music;

import com.google.gson.annotations.SerializedName;

public class TrackResponseTag {

    @SerializedName("name")
    public final String tagName;

    @SerializedName("url")
    public final String tagUrl;

    public TrackResponseTag(String tagName, String tagUrl) {
        this.tagName = tagName;
        this.tagUrl = tagUrl;
    }
}
