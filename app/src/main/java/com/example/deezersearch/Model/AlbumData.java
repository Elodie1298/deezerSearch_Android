
package com.example.deezersearch.Model;

import com.google.gson.annotations.Expose;

import java.util.List;

@SuppressWarnings("unused")
public class AlbumData {

    @Expose
    private List<Album> data;
    @Expose
    private Long total;

    public List<Album> getAlbums() {
        return data;
    }

    public void setData(List<Album> data) {
        this.data = data;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

}
