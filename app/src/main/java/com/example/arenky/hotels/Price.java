package com.example.arenky.hotels;

import com.google.gson.annotations.SerializedName;

public class Price {

    @SerializedName("current")
    public final String current;

    @SerializedName("exactCurrent")
    public final Double exactCurrent;

    public Price(String current, Double exactCurrent) {
        this.current = current;
        this.exactCurrent = exactCurrent;
    }
}
