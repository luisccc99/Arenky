package com.example.arenky.music;

import com.google.gson.annotations.SerializedName;

class ImageArtist {

    @SerializedName("#text")
    public final String text;

    @SerializedName("size")
    public final String size;

    ImageArtist(String text, String size) {
        this.text = text;
        this.size = size;
    }
}
