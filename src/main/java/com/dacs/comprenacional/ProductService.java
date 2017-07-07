package com.dacs.comprenacional;

import com.dacs.comprenacional.business.dao.ProductDaoImpl;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Jose on 6/7/2017.
 */
@Path("/product")
public class ProductService {
    @Inject
    private ProductDaoImpl dao;

    // expone todos los productos
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBothResponse()
    {
        return Response.ok().header("Access-Control-Allow-Origin", "*").entity(dao.findAll()).build();
    }
}
