package com.example.demo.services;


import com.example.demo.model.Roles;
import com.example.demo.model.User;
import com.example.demo.repositories.UserRepo;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.model.Roles.ADMIN;
import static com.example.demo.model.Roles.MASTER;


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



    public User getUser(String userName) {
        return userRepo.findByUserName(userName).stream().findFirst().orElse(null);
    }

    public List<User> getUsers() {
        List<User> user = Lists.newArrayList(
                new User("ali",
                         passwordEncoder.encode("password"),
                        ADMIN.getGrantedAuthority(),
                        "ali",
                        "forghani",
                        "0914914914"
                        )
                ,new User(
                        "aliIsassas",
                        passwordEncoder.encode("password"),
                        MASTER.getGrantedAuthority(),
                        "alitfhvg",
                        "isazadeh",
                        "0914vhj914914"

                )

        );
        return user;
    }

    public Page<User> getUsers(String name, int pageSize, int page) {
        Pageable pageable = PageRequest.of(page, pageSize);
        getUsers();
        return userRepo.findByFirstNameContainsOrLastNameContains(name, name, pageable);
    }

    private User setUsername(User user) {
        long count = userRepo.count();
        user.setUserName(Long.toString(985360000 + count + 1));
        return user;
    }

    public User deleteUser(String username) {
        User user = userRepo.findByUserName(username).orElse(null);
        if (user == null)
            return null;
        else
            userRepo.deleteById(user.getId());
        return user;
    }


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return (UserDetails) userRepo.findByUserName(userName)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("userName %s not found" , userName)));
    }
}