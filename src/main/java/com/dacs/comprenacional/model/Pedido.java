package com.dacs.comprenacional.model;

import org.omnifaces.persistence.model.TimestampedEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.time.Instant;
import java.util.List;

import org.hibernate.annotations.Cache;

import static javax.persistence.GenerationType.IDENTITY;
import static org.hibernate.annotations.CacheConcurrencyStrategy.TRANSACTIONAL;

/**
 * Created by grego on 22/06/17.
 */
@Entity
public class Pedido extends TimestampedEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    @Cache(usage = TRANSACTIONAL)
    private User user;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name="pedido_producto", joinColumns={@JoinColumn(name ="pedidoId", referencedColumnName ="id")},
            inverseJoinColumns={@JoinColumn(name ="productoId", referencedColumnName ="id")})
    private List<Producto> productos;

    @Column
    private @NotNull Instant created;

    @Column
    private @NotNull Instant lastModified;

    @Override
    public Object getId() {
        return null;
    }

    @Override
    public void setId(Object o) {

    }

    @Override
    public void setCreated(Instant instant) {

    }

    @Override
    public Instant getCreated() {
        return null;
    }

    @Override
    public void setLastModified(Instant instant) {

    }

    @Override
    public Instant getLastModified() {
        return null;
    }
}
