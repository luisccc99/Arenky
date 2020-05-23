package com.example.arenky.music;

import com.google.gson.annotations.SerializedName;

public class TracksAttributes {
    @SerializedName("country")
    private final String country;

    @SerializedName("page")
    private final String page;

    @SerializedName("perPage")
    private final String perPage;

    @SerializedName("totalPages")
    private final String totalPages;

    @SerializedName("total")
    private final String total;

    public TracksAttributes(String country, String page, String perPage, String totalPages, String total) {
        this.country = country;
        this.page = page;
        this.perPage = perPage;
        this.totalPages = totalPages;
        this.total = total;
    }
}
