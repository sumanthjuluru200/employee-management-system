package com.ems.fullstatck.controller;

import com.ems.fullstatck.entity.Users;
import com.ems.fullstatck.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserService userService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @PostMapping("/register")
    public Users register(@RequestBody Users users) {
//        users.setPassword(encoder.encode(users.getPassword()));
        users.setPassword(NoOpPasswordEncoder.getInstance().encode(users.getPassword()));
        return userService.register(users);

    }
}
