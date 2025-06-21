package com.mrsdeus.panel.user.controllers;

import com.mrsdeus.panel.user.dto.UserDto;
import com.mrsdeus.panel.user.persitence.entities.User;
import com.mrsdeus.panel.user.persitence.repositories.IUser;
import io.quarkus.security.Authenticated;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.jwt.JsonWebToken;

@Path("/panel/user")
@Authenticated
public class UserController {

    @Inject
    private JsonWebToken jwt;

    @Inject
    private IUser iUser;

    @GET
    public Iterable<User> findUser(){
        return iUser.findAll();
    }


    @POST
    public Response createUser(UserDto userDto){
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setRemember_me(userDto.getRemember_me());
        user.setPath_avatar(user.getPath_avatar());

        iUser.save(user);
        return Response.created(null).build();
    }

}
