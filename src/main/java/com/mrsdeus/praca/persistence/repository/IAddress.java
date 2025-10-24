package com.mrsdeus.praca.persistence.repository;

import com.mrsdeus.praca.persistence.entities.Address;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface IAddress extends CrudRepository <Address, UUID>{
}
