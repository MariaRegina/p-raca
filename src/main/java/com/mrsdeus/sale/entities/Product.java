package com.mrsdeus.sale.entities;

import com.mrsdeus.sale.enums.ClothesEnum;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private Double price;

    @Column(length = 500)
    private String description;

    @OneToMany
    private List<Attachment> images;

    private ClothesEnum category_product;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Attachment> getImages() {
        return images;
    }

    public void setImages(List<Attachment> images) {
        this.images = images;
    }

    public ClothesEnum getCategory_product() {
        return category_product;
    }

    public void setCategory_product(ClothesEnum category_product) {
        this.category_product = category_product;
    }
}
