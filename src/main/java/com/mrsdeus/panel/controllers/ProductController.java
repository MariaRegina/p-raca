package com.mrsdeus.panel.controllers;

import com.mrsdeus.panel.persistence.services.ProductService;
import com.mrsdeus.praca.persistence.entities.Product;
import com.mrsdeus.praca.persistence.repository.ProductRepository;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.inject.Inject;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

import java.util.List;

@Path("/panel/product")
public class ProductController {

    @Inject
    ProductService productService;

    @GET
    public List<Product> findProducts(@QueryParam("page") @DefaultValue("0") int page){
        return productService.findProducts(page);
    }
}
