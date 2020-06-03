package com.example.arenky.hotels;

import com.google.gson.annotations.SerializedName;

public class RatePlanFeatures {

    @SerializedName("paymentPreference")
    public final Boolean paymentPreference;

    @SerializedName("noCCRequired")
    public final Boolean noCCRequired;

    public RatePlanFeatures(Boolean paymentPreference, Boolean noCCRequired) {
        this.paymentPreference = paymentPreference;
        this.noCCRequired = noCCRequired;
    }
}
