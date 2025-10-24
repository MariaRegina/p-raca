package com.mrsdeus.praca.controller;

import com.mrsdeus.praca.persistence.entities.Order;
import com.mrsdeus.praca.persistence.repository.IOrder;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;


@Path("/order")
public class OrderController {

    @Inject
    IOrder iOrder;

    @POST
    @Path("/new-order")
    public Order newOrder(Order order){
        iOrder.save(order);
        return order;
    }
}
