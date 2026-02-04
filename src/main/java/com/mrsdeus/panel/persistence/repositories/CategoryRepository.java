package com.mrsdeus.panel.persistence.repositories;

import com.mrsdeus.praca.persistence.entities.Category;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CategoryRepository implements PanacheRepository<Category> {

    @Transactional
    public void delete(String slug){
        delete("FROM Category C WHERE C.slug = ?1", slug);
    }
}
