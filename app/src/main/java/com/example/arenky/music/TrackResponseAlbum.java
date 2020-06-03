package com.example.arenky.music;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TrackResponseAlbum {

    @SerializedName("artist")
    public final String artist;

    @SerializedName("title")
    public final String title;

    @SerializedName("mbid")
    public final String mbid;

    @SerializedName("url")
    public final String url;

    @SerializedName("image")
    public final List<AlbumImage> albumImage;

    @SerializedName("@attr")
    public final TrackResponseAttr attr;

    public TrackResponseAlbum(String artist, String title, String mbid, String url,
                              List<AlbumImage> albumImage, TrackResponseAttr attr) {
        this.artist = artist;
        this.title = title;
        this.mbid = mbid;
        this.url = url;
        this.albumImage = albumImage;
        this.attr = attr;
    }
}
