package com.mrsdeus.praca.persistence.repository;

import com.mrsdeus.praca.persistence.entities.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface IProduct extends JpaRepository<Product, UUID> {
    public List<Product> findByCategory_name(@Param("name") String name, Pageable pageable);
    public Product findBySlug(String slug);
    public Product findByCategory_nameAndSlug(@Param("name") String name, @Param("slug")String slug);
}
