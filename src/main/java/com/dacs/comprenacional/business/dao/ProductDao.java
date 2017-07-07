package com.dacs.comprenacional.business.dao;

import com.dacs.comprenacional.model.Producto;

import java.util.List;

/**
 * Created by Jose on 6/7/2017.
 */
public interface ProductDao {
    public List<Producto> findAll();
}
