package com.mrsdeus.praca.controller;

import com.mrsdeus.praca.dto.OrderDto;
import com.mrsdeus.praca.persistence.entities.Cart;
import com.mrsdeus.praca.persistence.entities.CartItem;
import com.mrsdeus.praca.persistence.entities.Person;
import com.mrsdeus.praca.persistence.entities.Product;
import com.mrsdeus.praca.persistence.repository.ICart;
import com.mrsdeus.praca.persistence.repository.ICartItem;
import com.mrsdeus.praca.persistence.repository.IPerson;
import com.mrsdeus.praca.persistence.repository.IProduct;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.jwt.JsonWebToken;

import java.util.Optional;
import java.util.UUID;

@Path("/cart")
public class CartController {

    @Inject
    ICart cartService;

    @Inject
    IProduct iProduct;

    @Inject
    IPerson iPerson;

    @Inject
    ICartItem iCartItem;

    @Inject
    com.mrsdeus.praca.persistence.repository.ICart iCart;

    @Inject
    JsonWebToken jwt;

    @POST
    @Path("/add-item")
    public Cart insertItemCart(OrderDto dto){
//        UUID usuarioLogado = UUID.fromString(jwt.getClaim("user-id"));
        Optional<Person> person = iPerson.findByUser_email("santosdedeusm@gmail.com");
        if(!person.isPresent()){
            //todo
            throw new RuntimeException("Usuario nao encontrado");
        }

        Product product = iProduct.findBySlug(dto.getSlug());

        if(product == null){
            //todo
            throw new RuntimeException("Produto nao encontrado");
        }

        Cart cart = (Cart) cartService.findByPerson_id(person.get().getId());
        if(cart == null){
            cart = new Cart();
            cart.setPerson(person.get());
            iCart.save(cart);
        }

        CartItem cartItem = iCartItem.findByCart_idAndProduct_idAndClothingSize(cart.getId(), product.getId(), dto.getSize());

        if(cartItem == null){
            cartItem = new CartItem();
        }

        cartItem.setCart(cart);
        cartItem.setProduct(product);
        cartItem.setAmount(dto.getAmount());
        cartItem.setClothingSize(dto.getSize());

        iCartItem.save(cartItem);

        return cart;
    }

    @POST
    @Path("/get-cart")
    public Cart getCart(){
        UUID usuarioLogado = UUID.fromString(jwt.getClaim("user-id"));
        return cartService.findByPerson_id(usuarioLogado);
    }
}
