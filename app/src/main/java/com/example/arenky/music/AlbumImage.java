package com.example.arenky.music;

import com.google.gson.annotations.SerializedName;

public class AlbumImage {

    @SerializedName("#text")
    public final String textUrl;

    @SerializedName("size")
    public final String size;

    public AlbumImage(String textUrl, String size) {
        this.textUrl = textUrl;
        this.size = size;
    }
}
