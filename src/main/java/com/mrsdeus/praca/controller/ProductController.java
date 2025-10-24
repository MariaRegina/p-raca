package com.mrsdeus.praca.controller;

import com.mrsdeus.praca.persistence.entities.Product;
import com.mrsdeus.praca.persistence.repository.IProduct;
import com.mrsdeus.praca.persistence.services.ProductService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Path("/product")
public class ProductController {

    @Inject
    IProduct iProduct;

    @Inject
    ProductService service;

    @GET
    public List<Product> getProducts(){
//        Pageable firstPageWithTwoElements = PageRequest.of(0, 50);
        return (List<Product>) iProduct.findAll();
    }

    @GET
    @Path("/{category}")
    public List<Product> getProductById(@Param("category") String category){
        Pageable firstPageWithTwoElements = PageRequest.of(0, 50);
        return iProduct.findByCategory_name(category, firstPageWithTwoElements);
    }

    @GET
    @Path("/{category}/{slug}")
    public Product findByCategoyAndSlug(@Param("category") String category, @Param("slug") String slug){
        return service.findByCategory_nameAndSlug(category, slug);
    }
}
