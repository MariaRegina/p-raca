package com.mrsdeus.praca.persistence.services;

import com.mrsdeus.praca.persistence.entities.Product;

public interface ProductService {
    public Product findByCategory_nameAndSlug(String categoryName, String slug);
}
