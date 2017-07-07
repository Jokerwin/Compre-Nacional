package com.dacs.comprenacional.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.LinkedList;

/**
 * Created by Jose on 4/7/2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "id",
        "title",
        "price"
})
public class ProductoML {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Column
    private @NotNull
    String title;

    @Column
    private LinkedList<Picture> pictures;

    public LinkedList<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(LinkedList<Picture> pictures) {
        this.pictures = pictures;
    }

    @Column
    float price;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "ProductoML{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
