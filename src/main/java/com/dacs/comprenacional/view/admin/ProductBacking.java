package com.dacs.comprenacional.view.admin;

import com.dacs.comprenacional.business.dao.ProductDaoImpl;
import com.dacs.comprenacional.model.Producto;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.optimusfaces.model.PagedDataModel;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Jose on 7/7/2017.
 */
@Named
@RequestScoped
@Transactional
public class ProductBacking implements Serializable {
    private static final long serialVersionUID = 1L;

    @Inject
    private ProductDaoImpl dao;

    private List<Producto> products;

    @PostConstruct
    public void init() {
        products = dao.findAll();
    }

    public List<Producto> getProducts() {
        return products;
    }
}
