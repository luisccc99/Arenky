package com.example.arenky.hotels;

import com.google.gson.annotations.SerializedName;

public class ResultAddress {

    @SerializedName("streetAddress")
    public final String streetAddress;

    @SerializedName("extendedAddress")
    public final String extendedAddress;

    @SerializedName("locality")
    public final String locality;

    @SerializedName("postalCode")
    public final String postalCode;

    @SerializedName("region")
    public final String region;

    @SerializedName("countryName")
    public final String countryName;

    @SerializedName("countryCode")
    public final String countryCode;

    public ResultAddress(String streetAddress, String extendedAddress, String locality,
                         String postalCode, String region, String countryName, String countryCode) {
        this.streetAddress = streetAddress;
        this.extendedAddress = extendedAddress;
        this.locality = locality;
        this.postalCode = postalCode;
        this.region = region;
        this.countryName = countryName;
        this.countryCode = countryCode;
    }
}
