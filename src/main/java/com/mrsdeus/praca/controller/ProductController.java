package com.mrsdeus.praca.controller;

import com.mrsdeus.praca.persistence.entities.Product;
import com.mrsdeus.praca.persistence.repository.ProductRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Path("/product")
public class ProductController {

    @Inject
    ProductRepository productRepository;

    @GET
    public List<Product> getProductById(@QueryParam("category") String category){
        return productRepository.findByCategory_name(category);
    }

    @GET
    @Path("/{slug}")
    public Product findByCategoyAndSlug(@Param("category") String category, @Param("slug") String slug){
        return productRepository.findBySlug(slug);
    }
}
