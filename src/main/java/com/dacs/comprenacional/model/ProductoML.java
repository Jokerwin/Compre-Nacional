package com.dacs.comprenacional.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.Instant;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;
import static org.hibernate.annotations.CacheConcurrencyStrategy.TRANSACTIONAL;

/**
 * Created by Jose on 4/7/2017.
 */
@Entity
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
