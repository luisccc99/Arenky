package com.example.arenky.hotels;

import com.google.gson.annotations.SerializedName;

import java.util.List;

class Suggestion {

    @SerializedName("group")
    public final String group;

    @SerializedName("entities")
    public final List<Entity> entitiesList;

    Suggestion(String group, List<Entity> entitiesList) {
        this.group = group;
        this.entitiesList = entitiesList;
    }
}
