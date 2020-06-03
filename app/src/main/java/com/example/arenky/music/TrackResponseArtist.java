package com.example.arenky.music;

import com.google.gson.annotations.SerializedName;

public class TrackResponseArtist {

    @SerializedName("name")
    public final String artistName;

    @SerializedName("mbid")
    public final String mbid;

    @SerializedName("url")
    public final String url;

    public TrackResponseArtist(String artistName, String mbid, String url) {
        this.artistName = artistName;
        this.mbid = mbid;
        this.url = url;
    }
}
