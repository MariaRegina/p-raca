package com.mrsdeus.person.repositories;

import com.mrsdeus.person.entities.Address;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface IAddress extends CrudRepository <Address, UUID>{
}
