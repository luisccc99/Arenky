package com.example.arenky.hotels;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SuggestionsFromSearch {

    @SerializedName("group")
    public final String group;

    @SerializedName("entities")
    public final List<EntitySuggestion> entitiesList;

    SuggestionsFromSearch(String group, List<EntitySuggestion> entitiesList) {
        this.group = group;
        this.entitiesList = entitiesList;
    }
}
