package com.ems.fullstatck.serviceImpl;

import com.ems.fullstatck.entity.UserPrincipal;
import com.ems.fullstatck.entity.Users;
import com.ems.fullstatck.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users users = usersRepository.findByUsername(username);
        if (users == null) {
            System.out.println("USER NOT FOUND");
            throw new UsernameNotFoundException("User Not Found");
        }

        return new UserPrincipal(users);
    }
}
