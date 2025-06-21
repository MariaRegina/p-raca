package com.mrsdeus.panel.user.persitence.repositories;

import com.mrsdeus.panel.user.persitence.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface IUser extends CrudRepository<User, Long> {
}
