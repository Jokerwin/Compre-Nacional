package com.dacs.comprenacional.model;

import org.hibernate.annotations.Cache;
import org.omnifaces.persistence.model.BaseEntity;
import org.omnifaces.persistence.model.TimestampedEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static org.hibernate.annotations.CacheConcurrencyStrategy.TRANSACTIONAL;

/**
 * Created by grego on 21/06/17.
 */
@Entity
public class Producto extends BaseEntity<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    private long id;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name="pedido_producto", joinColumns={@JoinColumn(name ="productoId", referencedColumnName ="id")},
            inverseJoinColumns={@JoinColumn(name ="pedidoId", referencedColumnName ="id")})
    private List<Pedido> pedidos;

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
