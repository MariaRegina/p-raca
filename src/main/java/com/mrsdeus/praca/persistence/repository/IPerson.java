package com.mrsdeus.praca.persistence.repository;

import com.mrsdeus.praca.persistence.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface IPerson extends JpaRepository<Person, UUID> {
    public Optional<Person> findByUser_email(String email);
}