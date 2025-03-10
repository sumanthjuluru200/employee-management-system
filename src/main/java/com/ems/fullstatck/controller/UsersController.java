package com.ems.fullstatck.controller;

import com.ems.fullstatck.entity.Users;
import com.ems.fullstatck.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserService userService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @PostMapping("/register")
    public Users register(@RequestBody Users users) {
        users.setPassword(encoder.encode(users.getPassword()));
        return userService.register(users);

    }

    @GetMapping("/getAll")
    public List<Users> getAllUsers(){
       return userService.getAllUsers();
    }
}
