package com.example.arenky.music;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TrackData {

    @SerializedName("name")
    private final String name;

    @SerializedName("duration")
    private final String duration;

    @SerializedName("listeners")
    private final String listeners;

    @SerializedName("mbid")
    private final String mBid;

    @SerializedName("url")
    private final String url;

    @SerializedName("streameable")
    private final Streamable streamable;

    @SerializedName("artist")
    private final Artist artist;

    @SerializedName("image")
    private final List<ImageArtist> image;

    @SerializedName("@attr")
    private final AttributeArtist attributeArtist;

    public TrackData(String name, String duration, String listeners, String mBid,
                     String url, Streamable streamable, Artist artist, List<ImageArtist> image,
                     AttributeArtist attributeArtist) {
        this.name = name;
        this.duration = duration;
        this.listeners = listeners;
        this.mBid = mBid;
        this.url = url;
        this.streamable = streamable;
        this.artist = artist;
        this.image = image;
        this.attributeArtist = attributeArtist;
    }

}
