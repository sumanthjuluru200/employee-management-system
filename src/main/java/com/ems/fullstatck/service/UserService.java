package com.ems.fullstatck.service;

import com.ems.fullstatck.entity.Users;

import java.util.List;

public interface UserService {

    Users register(Users users);
    List<Users> getAllUsers();
}
