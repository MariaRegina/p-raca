package com.mrsdeus.praca.controller;

import com.mrsdeus.praca.persistence.entities.Category;
import com.mrsdeus.praca.persistence.entities.Product;
import com.mrsdeus.praca.persistence.repository.ICategory;
import com.mrsdeus.praca.persistence.repository.IProduct;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Path("/category")
public class CategoryController {

    @Inject
    ICategory iCategory;

    @GET
    public List<Category> getPersonById(){
        return (List<Category>) iCategory.findAll();
    }
}
