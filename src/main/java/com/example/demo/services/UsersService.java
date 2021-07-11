package com.example.demo.services;


import com.example.demo.model.User;
import com.example.demo.repositories.UserRepo;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.demo.model.Roles.*;

@Service
public class UsersService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    public UsersService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    public User addUser(User user) {
        return userRepo.saveAndFlush(user);
    }

    public List<User> addUsers(List<User> users) {
        return userRepo.saveAll(users);

    }

    public User editUser(User newUser) {
        if (userRepo.existsById(newUser.getId()))
            return null;
        else
            return userRepo.save(newUser);
    }



    public User getUser(String username) {
        Optional<User> user = userRepo.findByUsername(username);
        System.out.println("tru to find user:"+username);
        System.out.println("found User:"+user.isPresent());
        user.ifPresent(System.out::println);

        return user.orElse(null);
    }

    public List<User> getUsers() {
        return userRepo.findAll();
    }

    public Page<User> getUsers(String name, int pageSize, int page) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return userRepo.findByFirstNameContainsOrLastNameContains(name, name, pageable);
    }
    public String getNewUsername(){
        long count = userRepo.count();
        long base = 985360000;
        return Long.toString(base+count+1);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepo.findByUsername(s).orElseThrow(() -> new UsernameNotFoundException(String.format("User with Username: %s notfound!", s)));
    }

}