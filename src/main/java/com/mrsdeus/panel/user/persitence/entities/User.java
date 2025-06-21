package com.mrsdeus.panel.user.persitence.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.SoftDelete;

import java.util.UUID;

@Entity
@Table(name = "users")
@SoftDelete
public class User{

    @Id
    @GeneratedValue
    private UUID id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private Boolean remember_me;

    private String path_avatar;

    private Boolean email_verified;

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getRemember_me() {
        return remember_me;
    }

    public void setRemember_me(Boolean remember_me) {
        this.remember_me = remember_me;
    }

    public String getPath_avatar() {
        return path_avatar;
    }

    public void setPath_avatar(String path_avatar) {
        this.path_avatar = path_avatar;
    }

    public Boolean getEmail_verified() {
        return email_verified;
    }

    public void setEmail_verified(Boolean email_verified) {
        this.email_verified = email_verified;
    }
}
