package com.dacs.comprenacional;

import com.dacs.comprenacional.business.service.ProductService;
import com.dacs.comprenacional.business.service.UserService;
import com.dacs.comprenacional.model.Producto;
import com.dacs.comprenacional.model.ProductoML;
import com.dacs.comprenacional.model.Picture;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Jose on 6/7/2017.
 */
@Path("/ml")
public class MLService {

    @EJB
    private ProductService productService;

    @GET
    @Path("/get")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getML() {

        Client client = ClientBuilder.newClient();

        WebTarget productosTarget = client.target("https://api.mercadolibre.com/items/MLA618295478/");

        Invocation.Builder invocationBuilder = productosTarget.request(MediaType.APPLICATION_JSON);

        ProductoML producto = invocationBuilder.get(ProductoML.class);

        return Response.ok().entity(producto).build();
    }

    @GET
    @Path("/get/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getML(@PathParam("id") String id) {

        Client client = ClientBuilder.newClient();

        WebTarget productosTarget = client.target("https://api.mercadolibre.com/items/"+id);

        Invocation.Builder invocationBuilder = productosTarget.request(MediaType.APPLICATION_JSON);

        ProductoML producto = invocationBuilder.get(ProductoML.class);

        return Response.ok().entity(producto).build();
    }

    @GET
    @Path("/save/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getMLProduct(@PathParam("id") Long id) {

        Client client = ClientBuilder.newClient();

        WebTarget productosTarget = client.target("https://api.mercadolibre.com/items/MLA"+id);

        Invocation.Builder invocationBuilder = productosTarget.request(MediaType.APPLICATION_JSON);

        ProductoML productoML = invocationBuilder.get(ProductoML.class);

        Producto p = new Producto();

        p.setNombre(productoML.getTitle());
        p.setPrecio((float) (productoML.getPrice()*1.2));
        p.setDescripcion(productoML.getPictures().getFirst().getUrl());
        p.setIDML(productoML.getId());

        productService.registerProduct(p);

        return Response.ok().entity(productoML).build();
    }
}
