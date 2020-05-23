package com.example.arenky.music;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TrackData {

    @SerializedName("name")
    public final String name;

    @SerializedName("duration")
    public final String duration;

    @SerializedName("listeners")
    public final String listeners;

    @SerializedName("mbid")
    public final String mBid;

    @SerializedName("url")
    public final String url;

    @SerializedName("streameable")
    public final Streamable streamable;

    @SerializedName("artist")
    public final Artist artist;

    @SerializedName("image")
    public final List<ImageArtist> image;

    @SerializedName("@attr")
    public final AttributeArtist attributeArtist;

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
