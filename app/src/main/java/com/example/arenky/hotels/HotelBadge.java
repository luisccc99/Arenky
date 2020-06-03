package com.example.arenky.hotels;

import com.google.gson.annotations.SerializedName;

public class HotelBadge {

    @SerializedName("type")
    public final String type;

    @SerializedName("label")
    public final String badgeLabel;

    public HotelBadge(String type, String badgeLabel) {
        this.type = type;
        this.badgeLabel = badgeLabel;
    }
}
