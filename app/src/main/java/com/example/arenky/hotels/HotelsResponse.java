package com.example.arenky.hotels;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HotelsResponse {

    @SerializedName("result")
    public final String result;

    @SerializedName("data")
    public final HotelsResponseData data;

    public HotelsResponse(String result, HotelsResponseData data) {
        this.result = result;
        this.data = data;
    }
}
