package com.mrsdeus.praca.persistence.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SoftDelete;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "product")
@SoftDelete
public class Product implements Serializable {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID id;

    private String name;

    @Column(unique = true)
    private String slug;

    private Double price;

    private Double discount;

    @Column(length = 500)
    private String description;

    @OneToMany
    private List<Attachment> images;

    @ManyToOne
    private Category category;

    @OneToMany
    private List<Color> colors;
}
