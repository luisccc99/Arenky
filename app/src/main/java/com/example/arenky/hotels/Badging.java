package com.example.arenky.hotels;

import com.google.gson.annotations.SerializedName;

public class Badging {

    @SerializedName("hotelBadge")
    public final HotelBadge badge;

    public Badging(HotelBadge badge) {
        this.badge = badge;
    }
}
