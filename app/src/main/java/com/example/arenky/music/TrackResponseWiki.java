package com.example.arenky.music;

import com.google.gson.annotations.SerializedName;

public class TrackResponseWiki {

    @SerializedName("published")
    public final String published;

    @SerializedName("summary")
    public final String summary;

    @SerializedName("content")
    public final String content;

    public TrackResponseWiki(String published, String summary, String content) {
        this.published = published;
        this.summary = summary;
        this.content = content;
    }
}
