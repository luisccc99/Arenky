package com.example.arenky.hotels;

import com.google.gson.annotations.SerializedName;

public class SearchResponse {

    @SerializedName("term")
    public final  String term;

    @SerializedName("moresuggestions")
    public final Integer  more;

    @SerializedName("autoSuggestInstance")
    public final Object auto;

    @SerializedName("trackingID")
    public final String trackingId;

    @SerializedName("misspellingfallback")
    public final Boolean misspelling;

    public SearchResponse(String term, Integer more, Object auto, String trackingId, Boolean misspelling) {
        this.term = term;
        this.more = more;
        this.auto = auto;
        this.trackingId = trackingId;
        this.misspelling = misspelling;
    }
}
