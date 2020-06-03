package com.example.arenky.hotels;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HotelDataBody {

    @SerializedName("header")
    public final String header;

    @SerializedName("query")
    public final BodyQuery query;

    @SerializedName("searchResults")
    public final BodySearchResults searchResults;

    @SerializedName("sortResults")
    public final BodySortResults sortResults;

    @SerializedName("filters")
    public final BodyFilters filters;

    @SerializedName("pointOfSale")
    public final PointOfSale pointOfSale;

    @SerializedName("miscellaneous")
    public final Miscellaneous miscellaneous;

    @SerializedName("pageInfo")
    public final BodyPageInfo pageInfo;

    public HotelDataBody(String header, BodyQuery query, BodySearchResults searchResults,
                         BodySortResults sortResults, BodyFilters filters, PointOfSale pointOfSale,
                         Miscellaneous miscellaneous, BodyPageInfo pageInfo) {
        this.header = header;
        this.query = query;
        this.searchResults = searchResults;
        this.sortResults = sortResults;
        this.filters = filters;
        this.pointOfSale = pointOfSale;
        this.miscellaneous = miscellaneous;
        this.pageInfo = pageInfo;
    }
}
