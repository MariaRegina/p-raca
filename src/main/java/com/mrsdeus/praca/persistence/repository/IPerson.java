package com.mrsdeus.praca.persistence.repository;

import com.mrsdeus.praca.persistence.entities.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface IPerson extends CrudRepository<Person, UUID> {
}
