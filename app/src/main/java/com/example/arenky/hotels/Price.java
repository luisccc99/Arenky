package com.example.arenky.hotels;

import com.google.gson.annotations.SerializedName;

public class Price {

    @SerializedName("current")
    public final String current;

    @SerializedName("exactCurrent")
    public final Double exactCurrent;

    @SerializedName("old")
    public final String old;

    public Price(String current, Double exactCurrent, String old) {
        this.current = current;
        this.exactCurrent = exactCurrent;
        this.old = old;
    }
}
