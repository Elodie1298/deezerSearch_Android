
package com.example.deezersearch.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Artist {

    @Expose
    private Long id;
    @Expose
    private String link;
    @Expose
    private String name;
    @SerializedName("nb_album")
    private Long nbAlbum;
    @SerializedName("nb_fan")
    private Long nbFan;
    @Expose
    private String picture;
    @SerializedName("picture_big")
    private String pictureBig;
    @SerializedName("picture_medium")
    private String pictureMedium;
    @SerializedName("picture_small")
    private String pictureSmall;
    @SerializedName("picture_xl")
    private String pictureXl;
    @Expose
    private Boolean radio;
    @Expose
    private String tracklist;
    @Expose
    private String type;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNbAlbum() {
        return nbAlbum;
    }

    public void setNbAlbum(Long nbAlbum) {
        this.nbAlbum = nbAlbum;
    }

    public Long getNbFan() {
        return nbFan;
    }

    public void setNbFan(Long nbFan) {
        this.nbFan = nbFan;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPictureBig() {
        return pictureBig;
    }

    public void setPictureBig(String pictureBig) {
        this.pictureBig = pictureBig;
    }

    public String getPictureMedium() {
        return pictureMedium;
    }

    public void setPictureMedium(String pictureMedium) {
        this.pictureMedium = pictureMedium;
    }

    public String getPictureSmall() {
        return pictureSmall;
    }

    public void setPictureSmall(String pictureSmall) {
        this.pictureSmall = pictureSmall;
    }

    public String getPictureXl() {
        return pictureXl;
    }

    public void setPictureXl(String pictureXl) {
        this.pictureXl = pictureXl;
    }

    public Boolean getRadio() {
        return radio;
    }

    public void setRadio(Boolean radio) {
        this.radio = radio;
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
