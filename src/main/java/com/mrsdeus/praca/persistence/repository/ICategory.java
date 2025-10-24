package com.mrsdeus.praca.persistence.repository;

import com.mrsdeus.praca.persistence.entities.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface ICategory extends CrudRepository<Category, UUID>{
//    public List<Category> findBy
}
