package com.mrsdeus.sale.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Base64;
import java.util.UUID;

@Entity
@Table(name = "attachment")
public class Attachment {

    @Id
    @GeneratedValue
    private UUID id;

    private String path;

    private Base64 base64;

    public UUID getId() {
        return id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Base64 getBase64() {
        return base64;
    }

    public void setBase64(Base64 base64) {
        this.base64 = base64;
    }
}
