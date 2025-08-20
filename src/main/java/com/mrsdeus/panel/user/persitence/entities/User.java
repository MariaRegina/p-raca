package com.mrsdeus.panel.user.persitence.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.hibernate.annotations.SoftDelete;

import java.util.UUID;

@Entity
@Table(name = "users")
@SoftDelete
@Data
public class User{

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private Boolean remember_me;

    private String path_avatar;

    private Boolean email_verified;

}
