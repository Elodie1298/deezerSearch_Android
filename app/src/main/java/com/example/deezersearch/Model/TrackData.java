
package com.example.deezersearch.Model;

import java.util.List;
import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class TrackData {

    @Expose
    private List<Track> data;
    @Expose
    private Long total;

    public List<Track> getTracks() {
        return data;
    }

    public void setData(List<Track> data) {
        this.data = data;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

}
