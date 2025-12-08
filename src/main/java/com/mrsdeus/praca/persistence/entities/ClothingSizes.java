package com.mrsdeus.praca.persistence.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.SoftDelete;

import java.util.UUID;

@Data
@Entity
@Table(name = "clothing_size")
public class ClothingSizes {

    @Id
    @GeneratedValue
    private UUID id;

    private int size;

    private int amount;
}
