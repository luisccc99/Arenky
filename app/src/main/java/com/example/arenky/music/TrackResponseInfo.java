package com.example.arenky.music;

import com.google.gson.annotations.SerializedName;

public class TrackResponseInfo {

    @SerializedName("name")
    public final String name;

    @SerializedName("mbid")
    public final String mbid;

    @SerializedName("duration")
    public final Integer duration; // milliseconds

    @SerializedName("streamable")
    public final TrackResponseStreamable streamable;

    @SerializedName("listeners")
    public final String listeners;

    @SerializedName("playcount")
    public final String playcount;

    @SerializedName("artist")
    public final TrackResponseArtist artist;

    @SerializedName("album")
    public final TrackResponseAlbum album;

    @SerializedName("topTags")
    public final TrackResponseTopTags topTags;

    @SerializedName("wiki")
    public final TrackResponseWiki wiki;

    public TrackResponseInfo(String name, String mbid, Integer duration,
                             TrackResponseStreamable streamable, String listeners,
                             String playcount, TrackResponseArtist artist, TrackResponseAlbum album,
                             TrackResponseTopTags topTags, TrackResponseWiki wiki) {
        this.name = name;
        this.mbid = mbid;
        this.duration = duration;
        this.streamable = streamable;
        this.listeners = listeners;
        this.playcount = playcount;
        this.artist = artist;
        this.album = album;
        this.topTags = topTags;
        this.wiki = wiki;
    }
}
