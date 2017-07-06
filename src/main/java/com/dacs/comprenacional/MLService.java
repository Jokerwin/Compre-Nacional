package com.dacs.comprenacional;

import com.dacs.comprenacional.model.ProductoML;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
    @GET
    @Path("/get")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getML() {

        Client client = ClientBuilder.newClient();

        WebTarget productosTarget = client.target("https://api.mercadolibre.com/items/MLA618295478/");

        Invocation.Builder invocationBuilder = productosTarget.request(MediaType.APPLICATION_JSON);

        ProductoML productos = invocationBuilder.get(ProductoML.class);

        return Response.ok().entity(productos).build();
    }
}
