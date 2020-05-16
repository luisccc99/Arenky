package com.example.arenky.flight;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FlightResponse {

    @SerializedName("success")
    public final Boolean success;

    @SerializedName("data")
    List<FlightData> dataList = null;

    public FlightResponse(Boolean success) {
        this.success = success;
    }

    public Boolean getSuccess() {
        return success;
    }

    public List<FlightData> getDataList() {
        return dataList;
    }
}
