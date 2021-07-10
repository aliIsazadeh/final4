package com.example.demo.services;

import com.example.demo.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserService1 implements UserDetailsService {

    private final UserRepo userRepo;

    @Autowired
    public ApplicationUserService1(@Qualifier("org")UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return (UserDetails) userRepo.findByUserName(userName)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("userName %s not found" , userName)));
    }
}
