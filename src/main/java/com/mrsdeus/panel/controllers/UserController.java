package com.mrsdeus.panel.controllers;

import com.mrsdeus.panel.persistence.entities.User;
import com.mrsdeus.panel.persistence.repositories.IUser;
import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.jwt.JsonWebToken;

import java.util.List;
import java.util.UUID;

@Path("/user")
@PermitAll
public class UserController {

    @Inject
    private JsonWebToken jwt;

    @Inject
    private IUser iUser;

//    @GET
//    public Iterable<User> findUsers(){
//        return iUser.findAll();
//    }


    @POST
    @PermitAll
    public Response createUser(User user){
        iUser.save(user);
        //envia email
        return Response.created(null).build();
    }
}
