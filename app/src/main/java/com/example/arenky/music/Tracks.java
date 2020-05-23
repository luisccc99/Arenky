package com.example.arenky.music;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Tracks {

    @SerializedName("track")
    public final List<TrackData> trackDataList;

    @SerializedName("@attr")
    public final TracksAttributes attributes;

    public Tracks(List<TrackData> trackDataList, TracksAttributes attributes) {
        this.trackDataList = trackDataList;
        this.attributes = attributes;
    }

    public List<TrackData> getTrackDataList() {
        return trackDataList;
    }

    public TracksAttributes getAttributes() {
        return attributes;
    }
}
