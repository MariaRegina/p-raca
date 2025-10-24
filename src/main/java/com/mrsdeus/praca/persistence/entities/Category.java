package com.mrsdeus.praca.persistence.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SoftDelete;

import java.util.UUID;

@Data
@Entity
@Table(name = "category")
@SoftDelete
public class Category {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    @Column(unique = true)
    private String slug;

}
