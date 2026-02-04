package com.mrsdeus.praca.persistence.repository;

import com.mrsdeus.praca.persistence.entities.Product;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class ProductRepository implements PanacheRepository<Product> {
    public List<Product> findByCategory_name(String category_name) {
        //todo paginação
        return find("SELECT P FROM Product P WHERE P.category.name = ?1 ", category_name).list();
    }

    public Product findBySlug(String slug){
        return find("SELECT P FROM Product P WHERE P.slug = ?1 ", slug).singleResult();

    }
}
