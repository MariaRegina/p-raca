package com.mrsdeus.panel.persistence.repositories;

import com.mrsdeus.panel.persistence.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface IUser extends CrudRepository<User, UUID> {
}
