
package com.example.deezersearch.Model;

import com.google.gson.annotations.Expose;

import java.util.List;

@SuppressWarnings("unused")
public class ArtistData {

    @Expose
    private List<Artist> data;
    @Expose
    private Long total;

    public List<Artist> getArtist() {
        return data;
    }

    public void setData(List<Artist> data) {
        this.data = data;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

}
