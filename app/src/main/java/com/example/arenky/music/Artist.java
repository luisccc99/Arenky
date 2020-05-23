package com.example.arenky.music;

import com.google.gson.annotations.SerializedName;

class Artist {

    @SerializedName("name")
    String name;

    @SerializedName("mbid")
    String mBid;

    @SerializedName("url")
    String url;
}
