package com.mrsdeus.panel.persistence.services;

import com.mrsdeus.praca.persistence.entities.Product;
import com.mrsdeus.praca.persistence.repository.ProductRepository;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.QueryParam;

import java.util.List;

@RequestScoped
public class ProductService {

    private final static int SIZE_PAGINATION = 20;

    @Inject
    ProductRepository productRepository;

    public List<Product> findProducts(int page){
        PanacheQuery<Product> productPanacheQuery = productRepository.findAll();
        productPanacheQuery.page(page, SIZE_PAGINATION);
        return productPanacheQuery.list();
    }
}
