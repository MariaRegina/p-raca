package com.mrsdeus.security;

import com.mrsdeus.security.dto.UserDto;
import com.mrsdeus.security.service.AuthService;
import io.smallrye.jwt.build.Jwt;
import jakarta.annotation.security.PermitAll;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import java.time.Duration;
import java.util.Set;

@Path("/login")
@PermitAll
public class Login {

//    @Inject
    AuthService authService = new AuthService();

    @POST
    @Path("/login")
    public Response login(UserDto userDto) {
        if (authService.validate(userDto.email, userDto.password)) {
            String token = Jwt.issuer("quarkus-example")
                    .upn(userDto.email)
                    .groups(Set.of("user"))
                    .expiresIn(Duration.ofHours(1))
                    .sign();

            return Response.ok().entity("{\"token\": \"" + token + "\"}").build();
        }

        return Response.status(Response.Status.UNAUTHORIZED).entity("Credenciais inválidas").build();
    }
}
