package com.mrsdeus.person.entities;

import com.mrsdeus.panel.user.persitence.entities.User;
import jakarta.persistence.*;
import org.hibernate.annotations.SoftDelete;

import java.sql.Date;
import java.util.UUID;

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

    public UUID getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
}
