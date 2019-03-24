
package com.example.deezersearch.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Album {

    @Expose
    private Artist artist;
    @Expose
    private String cover;
    @SerializedName("cover_big")
    private String coverBig;
    @SerializedName("cover_medium")
    private String coverMedium;
    @SerializedName("cover_small")
    private String coverSmall;
    @SerializedName("cover_xl")
    private String coverXl;
    @SerializedName("explicit_lyrics")
    private Boolean explicitLyrics;
    @SerializedName("genre_id")
    private Long genreId;
    @Expose
    private Long id;
    @Expose
    private String link;
    @SerializedName("nb_tracks")
    private Long nbTracks;
    @SerializedName("record_type")
    private String recordType;
    @Expose
    private String title;
    @Expose
    private String tracklist;
    @Expose
    private String type;

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getCoverBig() {
        return coverBig;
    }

    public void setCoverBig(String coverBig) {
        this.coverBig = coverBig;
    }

    public String getCoverMedium() {
        return coverMedium;
    }

    public void setCoverMedium(String coverMedium) {
        this.coverMedium = coverMedium;
    }

    public String getCoverSmall() {
        return coverSmall;
    }

    public void setCoverSmall(String coverSmall) {
        this.coverSmall = coverSmall;
    }

    public String getCoverXl() {
        return coverXl;
    }

    public void setCoverXl(String coverXl) {
        this.coverXl = coverXl;
    }

    public Boolean getExplicitLyrics() {
        return explicitLyrics;
    }

    public void setExplicitLyrics(Boolean explicitLyrics) {
        this.explicitLyrics = explicitLyrics;
    }

    public Long getGenreId() {
        return genreId;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Long getNbTracks() {
        return nbTracks;
    }

    public void setNbTracks(Long nbTracks) {
        this.nbTracks = nbTracks;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTracklist() {
        return tracklist;
    }

    public void setTracklist(String tracklist) {
        this.tracklist = tracklist;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
