package com.mrsdeus.praca.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "attachment")
public class Attachment {

    @Id
    @GeneratedValue
    private UUID id;

    private String path;

}
