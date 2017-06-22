package com.dacs.comprenacional.model;

import org.omnifaces.persistence.model.BaseEntity;
import org.omnifaces.persistence.model.TimestampedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by grego on 21/06/17.
 */
@Entity
public class Producto extends BaseEntity<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    private long id;

    @Column
    private @NotNull String nombre;

    @Column
    private @NotNull String descripcion;

    @Column
    private @NotNull float precio;

    @Column
    private @NotNull int stock;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long aLong) {
        this.id = id;
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
