package com.mrsdeus.panel.controllers;

import com.mrsdeus.panel.persistence.services.CategoryService;
import com.mrsdeus.praca.persistence.entities.Category;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/panel/category")
public class CategoryController {

    @Inject
    CategoryService categoryService;

    @GET
    public List<Category> getPersonById(@QueryParam("page") @DefaultValue("0") int page){
        return categoryService.findAll(page);
    }

    @PUT
    public Response newCategory(Category category){
        category = categoryService.newCategory(category);
        return Response.status(Response.Status.CREATED).entity(category).build();
    }

    @DELETE
    public Response deleteCategory(@QueryParam("slug") String slug){
        categoryService.deleteCategory(slug);
        return Response.status(Response.Status.OK).build();
    }
}
