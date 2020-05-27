package com.example.arenky.music;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Artist {

    @SerializedName("name")
    public final String name;

    @SerializedName("mbid")
    public final String mBid;

    @SerializedName("url")
    public final String url;

    Artist(String name, String mBid, String url) {
        this.name = name;
        this.mBid = mBid;
        this.url = url;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}
