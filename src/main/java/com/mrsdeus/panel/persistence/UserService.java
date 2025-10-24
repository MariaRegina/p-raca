package com.mrsdeus.panel.persistence;

import com.mrsdeus.panel.persistence.entities.User;

public interface UserService {
    User findByEmail(String email);
}
