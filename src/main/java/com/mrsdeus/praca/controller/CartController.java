package com.mrsdeus.praca.controller;

import com.mrsdeus.praca.dto.OrderDto;
import com.mrsdeus.praca.persistence.entities.Cart;
import com.mrsdeus.praca.persistence.entities.CartItem;
import com.mrsdeus.praca.persistence.entities.Person;
import com.mrsdeus.praca.persistence.entities.Product;
import com.mrsdeus.praca.persistence.repository.ICart;
import com.mrsdeus.praca.persistence.repository.ICartItem;
import com.mrsdeus.praca.persistence.repository.IPerson;
import com.mrsdeus.praca.persistence.repository.ProductRepository;
import com.mrsdeus.praca.persistence.services.CartService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.jwt.JsonWebToken;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Path("/cart")
public class CartController {

    @Inject
    ICart iCart;

    @Inject
    ProductRepository productRepository;

    @Inject
    IPerson iPerson;

    @Inject
    ICartItem iCartItem;

    @Inject
    CartService cartService;


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

        Product product = productRepository.findBySlug(dto.getSlug());

        if(product == null){
            //todo
            throw new RuntimeException("Produto nao encontrado");
        }

        Cart cart = iCart.findByPerson_id(person.get().getId());
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

    @GET
    @Path("/products")
    public List<Product> getProdutsInCart(){
        //todo
//        UUID usuarioLogado = UUID.randomUUID();
//        UUID usuarioLogado = UUID.fromString(jwt.getClaim("user-id"));
        UUID usuarioLogado = iPerson.findByUser_email("santosdedeusm@gmail.com").get().getId();
        if(usuarioLogado == null){
            throw new RuntimeException("Usuario nao encontrado");
        }
        return cartService.getProdutsInCart(usuarioLogado);
    }
}
