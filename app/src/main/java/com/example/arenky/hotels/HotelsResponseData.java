package com.example.arenky.hotels;

import com.google.gson.annotations.SerializedName;

public class HotelsResponseData {

    @SerializedName("body")
    public final HotelDataBody body;

    @SerializedName("common")
    public final HotelDataCommon common;

    public HotelsResponseData(HotelDataBody body, HotelDataCommon common) {
        this.body = body;
        this.common = common;
    }
}
