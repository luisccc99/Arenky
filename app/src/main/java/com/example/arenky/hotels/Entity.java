package com.example.arenky.hotels;

import com.google.gson.annotations.SerializedName;

class Entity {

    @SerializedName("geoId")
    public final String geoId;

    @SerializedName("destinationId")
    public final String destinationId;

    @SerializedName("landmarkCityDestinationId")
    public final Integer landmarkCityDestinationId;

    @SerializedName("type")
    public final String type;

    @SerializedName("caption")
    public final String caption;

    @SerializedName("redirectPage")
    public final String redirectPage;

    @SerializedName("latitude")
    public final Double latitude;

    @SerializedName("longitude")
    public final Double longitude;

    @SerializedName("name")
    public final String nameEntity;

    Entity(String geoId, String destinationId, Integer landmarkCityDestinationId, String type,
           String caption, String redirectPage, Double latitude, Double longitude, String name) {
        this.geoId = geoId;
        this.destinationId = destinationId;
        this.landmarkCityDestinationId = landmarkCityDestinationId;
        this.type = type;
        this.caption = caption;
        this.redirectPage = redirectPage;
        this.latitude = latitude;
        this.longitude = longitude;
        this.nameEntity = name;
    }
}
