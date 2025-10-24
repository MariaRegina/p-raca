package com.mrsdeus.praca.persistence.dao;

import com.mrsdeus.praca.persistence.entities.Product;
import com.mrsdeus.praca.persistence.services.ProductService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@RequestScoped
public class ProductDao implements ProductService {

    @Inject
    EntityManager em;

    public Product findByCategory_nameAndSlug(String categoryName, String slug) {
        StringBuilder sql = new StringBuilder();

        sql.append(" SELECT P FROM Product P ");
        sql.append(" INNER JOIN Category C ON P.category.id = C.id ");
        sql.append(" AND C.slug = :categoryName ");
        sql.append(" AND P.slug = :slug ");

        Query query = em.createQuery(sql.toString());
        query.setParameter("categoryName", categoryName);
        query.setParameter("slug", slug);

        return (Product) query.getResultStream().findFirst().orElse(null);
    }
}
