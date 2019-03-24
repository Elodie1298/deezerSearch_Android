
package com.example.deezersearch.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Track {

    @Expose
    private Artist artist;
    @SerializedName("disk_number")
    private Long diskNumber;
    @Expose
    private Long duration;
    @SerializedName("explicit_content_cover")
    private Long explicitContentCover;
    @SerializedName("explicit_content_lyrics")
    private Long explicitContentLyrics;
    @SerializedName("explicit_lyrics")
    private Boolean explicitLyrics;
    @Expose
    private Long id;
    @Expose
    private String isrc;
    @Expose
    private String link;
    @Expose
    private String preview;
    @Expose
    private Long rank;
    @Expose
    private Boolean readable;
    @Expose
    private String title;
    @SerializedName("title_short")
    private String titleShort;
    @SerializedName("title_version")
    private String titleVersion;
    @SerializedName("track_position")
    private Long trackPosition;
    @Expose
    private String type;

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Long getDiskNumber() {
        return diskNumber;
    }

    public void setDiskNumber(Long diskNumber) {
        this.diskNumber = diskNumber;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Long getExplicitContentCover() {
        return explicitContentCover;
    }

    public void setExplicitContentCover(Long explicitContentCover) {
        this.explicitContentCover = explicitContentCover;
    }

    public Long getExplicitContentLyrics() {
        return explicitContentLyrics;
    }

    public void setExplicitContentLyrics(Long explicitContentLyrics) {
        this.explicitContentLyrics = explicitContentLyrics;
    }

    public Boolean getExplicitLyrics() {
        return explicitLyrics;
    }

    public void setExplicitLyrics(Boolean explicitLyrics) {
        this.explicitLyrics = explicitLyrics;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsrc() {
        return isrc;
    }

    public void setIsrc(String isrc) {
        this.isrc = isrc;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public Long getRank() {
        return rank;
    }

    public void setRank(Long rank) {
        this.rank = rank;
    }

    public Boolean getReadable() {
        return readable;
    }

    public void setReadable(Boolean readable) {
        this.readable = readable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleShort() {
        return titleShort;
    }

    public void setTitleShort(String titleShort) {
        this.titleShort = titleShort;
    }

    public String getTitleVersion() {
        return titleVersion;
    }

    public void setTitleVersion(String titleVersion) {
        this.titleVersion = titleVersion;
    }

    public Long getTrackPosition() {
        return trackPosition;
    }

    public void setTrackPosition(Long trackPosition) {
        this.trackPosition = trackPosition;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
