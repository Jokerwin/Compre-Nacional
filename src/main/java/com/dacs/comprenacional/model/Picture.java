package com.dacs.comprenacional.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Created by Jose on 6/7/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "url"
})
public class Picture {
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return url;
    }
}
