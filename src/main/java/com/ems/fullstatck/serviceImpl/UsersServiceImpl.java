package com.ems.fullstatck.serviceImpl;

import com.ems.fullstatck.entity.Users;
import com.ems.fullstatck.repository.UsersRepository;
import com.ems.fullstatck.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UserService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public Users register(Users users) {
        return usersRepository.save(users);
    }

    @Override
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public String verify(Users users) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(users.getUsername(), users.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(users.getUsername());
        }
        return "Fail";
    }
}
