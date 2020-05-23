package com.example.arenky.music;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

class AttributeArtist {

    @SerializedName("rank")
    public final String rank;

    AttributeArtist(String rank) {
        this.rank = rank;
    }

    @NonNull
    @Override
    public String toString() {
        return rank;
    }
}
