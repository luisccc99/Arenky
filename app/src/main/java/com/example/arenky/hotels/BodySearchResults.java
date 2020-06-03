package com.example.arenky.hotels;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BodySearchResults {

    @SerializedName("totalCount")
    public final Integer totalCount;

    @SerializedName("results")
    public final List<SearchHotelsResult> hotelsResultsList;

    @SerializedName("pagination")
    public final SearchResultsPagination pagination;

    public BodySearchResults(Integer totalCount, List<SearchHotelsResult> hotelsResultsList, SearchResultsPagination pagination) {
        this.totalCount = totalCount;
        this.hotelsResultsList = hotelsResultsList;
        this.pagination = pagination;
    }
}
