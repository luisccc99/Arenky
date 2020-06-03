package com.example.arenky.hotels;

import com.google.gson.annotations.SerializedName;

public class GuestReviews {

    @SerializedName("unformattedRating")
    public final Double unformattedRating;

    @SerializedName("rating")
    public final Double rating;

    @SerializedName("total")
    public final Integer total;

    @SerializedName("scale")
    public final Integer scale;

    @SerializedName("badge")
    public final String badge;

    @SerializedName("badgeText")
    public final String badgeText;

    public GuestReviews(Double unformattedRating, Double rating, Integer total, Integer scale,
                        String badge, String badgeText) {
        this.unformattedRating = unformattedRating;
        this.rating = rating;
        this.total = total;
        this.scale = scale;
        this.badge = badge;
        this.badgeText = badgeText;
    }
}
