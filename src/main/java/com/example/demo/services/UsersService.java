package com.example.demo.services;


import com.example.demo.model.User;
import com.example.demo.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UserRepo userRepo;

    public User addUser(User user){
        return userRepo.saveAndFlush(user);
    }
    public List<User> addUsers(List<User> users){
        return userRepo.saveAll(users);
    }
    public User editUser(User newUser){
        if (userRepo.existsById(newUser.getId()))
            return null;
        else
            return userRepo.save(newUser);
    }
    public User getUser(int userid){
        return userRepo.findById(userid).stream().findFirst().orElse(null);
    }
    public List<User> getUsers(){
        return userRepo.findAll();
    }

}
