package com.mrsdeus.praca.controller;

import com.mrsdeus.praca.persistence.entities.Cart;
import com.mrsdeus.praca.persistence.repository.ICart;
import com.mrsdeus.praca.persistence.services.CartService;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import java.util.UUID;

@Path("/cart")
public class CartController {

    @Inject
    ICart iCart;

//    @Inject
//    CartService cartService;

    @POST
    @Path("/new-item")
    public Cart insertItemCart(){
        UUID usuarioLogado = UUID.fromString("aa80e570-4258-4e00-9380-a8ada121f20a");
//        Cart cart = cartService.findByPerson_id(usuarioLogado);

        ////////////////
        //valida produto
        ////////////////

        return null;//iCart.save(cart);
    }
}
