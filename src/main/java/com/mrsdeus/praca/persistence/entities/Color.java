package com.mrsdeus.praca.persistence.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.SoftDelete;

import java.util.UUID;

@Data
@Entity
@Table(name = "color")
@SoftDelete
public class Color {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    @Column(unique = true)
    private String code;

    @Column(length = 100)
    private String meaning;
}
