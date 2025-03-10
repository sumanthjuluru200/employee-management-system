package com.ems.fullstatck.serviceImpl;

import com.ems.fullstatck.entity.Users;
import com.ems.fullstatck.repository.UsersRepository;
import com.ems.fullstatck.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UserService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public Users register(Users users) {
        return usersRepository.save(users);
    }

    @Override
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }
}
