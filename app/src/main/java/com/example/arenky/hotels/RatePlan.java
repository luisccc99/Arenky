package com.example.arenky.hotels;

import com.google.gson.annotations.SerializedName;

public class RatePlan {

    @SerializedName("price")
    public final Price price;

    @SerializedName("features")
    public final RatePlanFeatures features;

    public RatePlan(Price price, RatePlanFeatures features) {
        this.price = price;
        this.features = features;
    }
}
