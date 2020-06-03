package com.example.arenky.hotels;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchHotelsResult {

    @SerializedName("id")
    public final Integer id;

    @SerializedName("name")
    public final String hotelName;

    @SerializedName("thumbnailUrl")
    public final String thumbnail;

    @SerializedName("starRating")
    public final Double starRating;

    @SerializedName("urls")
    public final ResultUrl resultUrl;

    @SerializedName("address")
    public final ResultAddress address;

    @SerializedName("guestReviews")
    public final GuestReviews reviews;

    @SerializedName("landmarks")
    public final List<Landmarks> landmarksList;

    @SerializedName("ratePlan")
    public final RatePlan ratePlan;

    @SerializedName("neighbourhood")
    public final String neighbourhood;

    @SerializedName("deals")
    public final Deal deals;

    @SerializedName("messaging")
    public final ResultMessaging messaging;

    @SerializedName("badging")
    public final Badging badging;

    @SerializedName("pimmsAttributes")
    public final String pimmsAttributes;

    @SerializedName("coordinate")
    public final Coordinate coordinate;

    @SerializedName("providerType")
    public final String providerType;

    @SerializedName("supplierHotelId")
    public final Integer supplierHotelId;

    @SerializedName("isAlternative")
    public final Boolean isAlternative;

    public SearchHotelsResult(Integer id, String hotelName, String thumbnail, Double starRating,
                              ResultUrl resultUrl, ResultAddress address, GuestReviews reviews,
                              List<Landmarks> landmarksList, RatePlan ratePlan, String neighbourhood,
                              Deal deals, ResultMessaging messaging, Badging badging,
                              String pimmsAttributes, Coordinate coordinate, String providerType,
                              Integer supplierHotelId, Boolean isAlternative) {
        this.id = id;
        this.hotelName = hotelName;
        this.thumbnail = thumbnail;
        this.starRating = starRating;
        this.resultUrl = resultUrl;
        this.address = address;
        this.reviews = reviews;
        this.landmarksList = landmarksList;
        this.ratePlan = ratePlan;
        this.neighbourhood = neighbourhood;
        this.deals = deals;
        this.messaging = messaging;
        this.badging = badging;
        this.pimmsAttributes = pimmsAttributes;
        this.coordinate = coordinate;
        this.providerType = providerType;
        this.supplierHotelId = supplierHotelId;
        this.isAlternative = isAlternative;
    }
}
