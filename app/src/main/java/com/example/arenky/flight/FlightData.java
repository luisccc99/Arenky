package com.example.arenky.flight;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

// se implementa serializable para poder enviar un objeto a otro
public class FlightData implements Serializable {

    @SerializedName("value")
    public final Double value;

    @SerializedName("trip_class")
    public final Integer tripClass;

    @SerializedName("show_affiliates")
    public final Boolean showAffiliates;

    @SerializedName("return_date")
    public final Object returnDate;

    @SerializedName("origin")
    public final String origin;

    @SerializedName("number_of_changes")
    public final Integer numberOfChanges;

    @SerializedName("gate")
    public final String gate;

    @SerializedName("found_at")
    public final String foundAt;

    @SerializedName("duration")
    public final Integer duration;

    @SerializedName("distance")
    public final Integer distance;

    @SerializedName("destination")
    public final String destination;

    @SerializedName("depart_date")
    public final String departDate;

    @SerializedName("actual")
    public final Boolean actual;

    public FlightData(Double value, Integer tripClass, Boolean showAffiliates,
                      String returnDate, String origin, Integer numberOfChanges,
                      String gate, String foundAt, Integer duration, Integer distance,
                      String destination, String departDate, Boolean actual, Double price) {
        this.value = value;
        this.tripClass = tripClass;
        this.showAffiliates = showAffiliates;
        this.returnDate = returnDate;
        this.origin = origin;
        this.numberOfChanges = numberOfChanges;
        this.gate = gate;
        this.foundAt = foundAt;
        this.duration = duration;
        this.distance = distance;
        this.destination = destination;
        this.departDate = departDate;
        this.actual = actual;
    }
}
