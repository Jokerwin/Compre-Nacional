package com.dacs.comprenacional.business.service;

import com.dacs.comprenacional.model.Producto;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Jose on 6/7/2017.
 */
@Stateless
public class ProductService extends BaseEntityService<Long, Producto> {
    @PersistenceContext
    private EntityManager entityManager;

    @Resource
    private SessionContext sessionContext;

    public void registerProduct(Producto product) {
        super.save(product);
    }
}
