package com.mrsdeus.panel.entities;

import com.mrsdeus.sale.entities.Attachment;
import com.mrsdeus.sale.enums.ClothesEnum;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.hibernate.annotations.SoftDelete;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "product")
@SoftDelete
public class Product {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID id;

    private String name;

    private Double price;

    @Column(length = 500)
    private String description;

    @OneToMany
    private List<Attachment> images;

    private ClothesEnum category_product;
}
