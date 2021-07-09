package com.example.demo.services;


import com.example.demo.model.Roles;
import com.example.demo.model.User;
import com.example.demo.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UserRepo userRepo;

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

    public User getUser(int userid) {
        return userRepo.findById(userid).stream().findFirst().orElse(null);
    }

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        users.add(User.builder().firstName("fatemeh").lastName("ghafouri").phoneNum("09146633942").Role(Roles.ADMIN).build());
        users.add(User.builder().firstName("ali").lastName("forghani").phoneNum("09145030651").Role(Roles.MASTER).build());
        users.add(User.builder().firstName("amme").lastName("ghafouri").phoneNum("09140099000").Role(Roles.STUDENT).build());
        users.add(User.builder().firstName("komeil").lastName("ghafouri").phoneNum("09140000000").Role(Roles.STUDENT).build());
        userRepo.saveAll(users);
//        return userRepo.findAll();

        return userRepo.findAll();
    }

    public Page<User> getUsers(String name, int pageSize, int page) {
        Pageable pageable = PageRequest.of(page, pageSize);
        getUsers();
        return userRepo.findByFirstNameContainsOrLastNameContains(name, name, pageable);
    }
}