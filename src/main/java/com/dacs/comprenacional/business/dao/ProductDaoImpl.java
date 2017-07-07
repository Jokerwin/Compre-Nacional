package com.dacs.comprenacional.business.dao;

import com.dacs.comprenacional.model.Producto;
import com.dacs.comprenacional.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Jose on 6/7/2017.
 */
public class ProductDaoImpl implements ProductDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Producto> findAll() {
        TypedQuery<Producto> query = em.createQuery("SELECT p FROM Producto p", Producto.class);
        List<Producto> result = query.getResultList();

        return result;
    }
}
