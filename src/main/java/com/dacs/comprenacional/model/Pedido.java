package com.dacs.comprenacional.model;

import org.omnifaces.persistence.model.TimestampedEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.time.Instant;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by grego on 22/06/17.
 */
@Entity
public class Pedido extends TimestampedEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

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
