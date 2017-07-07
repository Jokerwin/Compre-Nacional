package com.dacs.comprenacional.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.omnifaces.persistence.model.BaseEntity;
import org.omnifaces.persistence.model.TimestampedEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;
import static org.hibernate.annotations.CacheConcurrencyStrategy.TRANSACTIONAL;

/**
 * Created by José on 21/06/17.
 */
@Entity
public class Producto  extends TimestampedEntity<Long> {

    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = IDENTITY)
    private long id;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name="pedido_producto", joinColumns={@JoinColumn(name ="productoId", referencedColumnName ="id")},
            inverseJoinColumns={@JoinColumn(name ="pedidoId", referencedColumnName ="id")})
    private List<Pedido> pedidos;

    @Column
    private @NotNull String nombre;

    @Column
    private String descripcion;

    @Column
    private @NotNull float precio;

    @JsonIgnore
    @Column
    private @NotNull
    Instant created;

    @Column
    private int stock;

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

    @Override
    public Instant getCreated() {
        return created;
    }

    @Override
    public void setLastModified(Instant instant) {

    }

    @Override
    public Instant getLastModified() {
        return null;
    }

    @Override
    public void setCreated(Instant created) {
        this.created = created;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
