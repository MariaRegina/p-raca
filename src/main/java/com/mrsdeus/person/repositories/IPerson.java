package com.mrsdeus.person.repositories;

import com.mrsdeus.person.entities.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface IPerson extends CrudRepository<Person, UUID> {
}
