//package com.mrsdeus.security.service;
//
//import com.mrsdeus.panel.persistence.UserService;
//import com.mrsdeus.panel.persistence.entities.User;
//import io.quarkus.elytron.security.common.BcryptUtil;
//import jakarta.enterprise.context.RequestScoped;
//import jakarta.inject.Inject;
//
//public class AuthService {
//
//    @Inject
//    UserService userService;
//
//    public boolean validate(String email, String password) {
//        User user = userService.findByEmail(email);
//        if (user == null) return false;
//        String passwordAux = BcryptUtil.bcryptHash(password, 15);
//        return passwordAux.equals(user.getPassword());
//    }
//}
