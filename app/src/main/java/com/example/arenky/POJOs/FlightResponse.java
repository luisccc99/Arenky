package com.example.arenky.POJOs;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FlightResponse {

    @SerializedName("success")
    Boolean success;

    @SerializedName("data")
    List<FlightData> dataList = null;

}
