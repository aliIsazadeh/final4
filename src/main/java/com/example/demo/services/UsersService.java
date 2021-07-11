package com.example.demo.services;


import com.example.demo.model.User;
import com.example.demo.model.requestBodyModels.AddUser;
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
import java.util.Random;

import static com.example.demo.model.Roles.*;

@Service
public class UsersService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    private OTP otp;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    public UsersService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    public User addUser(AddUser addUser) throws Exception {
        User user = new User();
        user.setUsername(getNewUsername());
        String simplePassword = getNewPassword();
        user.setPassword(passwordEncoder.encode(simplePassword));
        user.setFirstName(addUser.getFirstname());
        user.setLastName(addUser.getLastname());
        user.setPhoneNum(addUser.getPhoneNumber());
        user.setRole(addUser.getRole());
        String smsText = "your username is %s and password is %s";
        smsText = String.format(smsText, user.getUsername(), simplePassword);
        otp.setPhoneNumber(user.getPhoneNum());
        otp.setMessage(smsText);
        try {
            otp.send();
        } catch (Exception e) {
            throw new Exception(e);
        }
        return userRepo.saveAndFlush(user);
    }

    public List<User> addUsers(List<User> users) {
        return userRepo.saveAll(users);

    }

    public User editUser(User newUser) {
        if (!userRepo.existsById(newUser.getId()))
            return null;
        return userRepo.save(newUser);
    }


    public User getUser(String username) {
        Optional<User> user = userRepo.findByUsername(username);
        return user.orElse(null);
    }

    public List<User> getUsers() {
        return userRepo.findAll();
    }

    public Page<User> getUsers(String name, int pageSize, int page) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return userRepo.findByFirstNameContainsOrLastNameContains(name, name, pageable);
    }

    public String getNewUsername() {
        long count = userRepo.count();
        long base = 985360000;
        return Long.toString(base + count + 1);
    }

    public String getNewPassword() {
        String password = "";
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            password += random.nextInt(10);
        }
        return password;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepo.findByUsername(s).orElseThrow(() -> new UsernameNotFoundException(String.format("User with Username: %s notfound!", s)));
    }

}