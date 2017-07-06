package com.dacs.comprenacional;

import com.dacs.comprenacional.business.dao.UserDaoImpl;
import com.dacs.comprenacional.model.User;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Jose on 23/6/2017.
 */
@Path("/client")
public class ClientService
{
    @Inject
    private UserDaoImpl dao;

    // expone todos los usuarios
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBothResponse()
    {
        return Response.ok().entity(dao.findAll()).build();
    }

    // consume del que expone y los vuelve a exponer
    @GET
    @Path("/getAll")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getOne() {

        Client client = ClientBuilder.newClient();

        WebTarget productosTarget = client.target("http://localhost:8080/api/client/get");

        Invocation.Builder invocationBuilder = productosTarget.request(MediaType.APPLICATION_JSON);

        List<User> productos = invocationBuilder.get(new GenericType<List<User>>(){});

        return Response.ok().entity(productos).build();
    }

    // consume del que expone y expone el id deseado
    @GET
    @Path("/get/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getOne(@PathParam("id") Long id) {

        Client client = ClientBuilder.newClient();

        WebTarget productosTarget = client.target("http://localhost:8080/api/client/get");

        Invocation.Builder invocationBuilder = productosTarget.request(MediaType.APPLICATION_JSON);

        List<User> productos = invocationBuilder.get(new GenericType<List<User>>() {
        });

        for (User p : productos) {
            if (id.equals(p.getId())) {
                return Response.ok().entity(p).build();
            }
        }

        return Response.status(404).entity("Product not found").build();
    }
}