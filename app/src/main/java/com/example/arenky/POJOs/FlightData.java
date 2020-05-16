package com.example.arenky.POJOs;

import com.google.gson.annotations.SerializedName;

public class FlightData {

    @SerializedName("value")
    Double value;

    @SerializedName("trip_class")
    Integer tripClass;

    @SerializedName("show_affiliates")
    Boolean showAffiliates;

    @SerializedName("return_date")
    Object returnDate;

    @SerializedName("origin")
    String origin;

    @SerializedName("number_of_changes")
    Integer numberOfChanges;

    @SerializedName("gate")
    String gate;

    @SerializedName("found_at")
    String foundAt;

    @SerializedName("duration")
    Integer duration;

    @SerializedName("distance")
    Integer distance;

    @SerializedName("destination")
    String destination;

    @SerializedName("depart_date")
    String departDate;

    @SerializedName("actual")
    Boolean actual;



}
