package com.mrsdeus.person.entities;

import com.mrsdeus.panel.user.persitence.entities.User;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SoftDelete;

import java.sql.Date;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "person")
@SoftDelete
public class Person {

    @Id
    @GeneratedValue
    private UUID id;

    @OneToOne
    private User user;

    private String name;

    private Date birth_date;

    private String phone;

    private char gender;
}
