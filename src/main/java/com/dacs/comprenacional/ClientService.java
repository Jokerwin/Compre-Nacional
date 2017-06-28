package com.dacs.comprenacional;

import com.dacs.comprenacional.model.User;
import com.dacs.comprenacional.business.dao.UserDaoImpl;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Jose on 23/6/2017.
 */

@Path("/client")
public class ClientService
{
    @Inject
    private UserDaoImpl dao;

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getBothResponse()
    {
        return dao.findAll();
    }
}