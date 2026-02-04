package com.mrsdeus.panel.persistence.services;

import com.mrsdeus.panel.persistence.repositories.CategoryRepository;
import com.mrsdeus.praca.persistence.entities.Category;
import com.mrsdeus.praca.persistence.entities.Product;
import com.mrsdeus.praca.persistence.repository.ProductRepository;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.QueryParam;

import java.util.List;

@RequestScoped
public class CategoryService {
    private final static int SIZE_PAGINATION = 20;

    @Inject
    CategoryRepository categoryRepository;

    public List<Category> findAll(@QueryParam("page") @DefaultValue("0") int page){
        PanacheQuery<Category> productPanacheQuery = categoryRepository.findAll();
        productPanacheQuery.page(page, SIZE_PAGINATION);
        return productPanacheQuery.list();
    }

    @Transactional
    public Category newCategory(Category category){
        categoryRepository.persist(category);
        return category;
    }

    public void deleteCategory(String slug){
        categoryRepository.delete(slug);
    }
}
