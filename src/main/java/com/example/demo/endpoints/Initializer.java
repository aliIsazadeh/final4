package com.example.demo.endpoints;

import com.example.demo.model.User;
import com.example.demo.services.UsersService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.example.demo.model.Roles.*;

@RestController
public class Initializer {

    private final UsersService usersService;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public Initializer(PasswordEncoder passwordEncoder,UsersService usersService) {
        this.passwordEncoder = passwordEncoder;
        this.usersService = usersService;
    }

    @GetMapping("/init")
    public boolean init(){
        List<User> user = Lists.newArrayList(
                new User("1",
                        passwordEncoder.encode("1"),
                        ADMIN.getGrantedAuthority(),
                        "ali",
                        "forghani",
                        "0914914914",
                        true,
                        true,
                        true,
                        true
                )
                ,new User(
                        "2",
                        passwordEncoder.encode("2"),
                        MASTER.getGrantedAuthority(),
                        "alitfhvg",
                        "isazadeh",
                        "09149149140",
                        true,
                        true,
                        true,
                        true
                )

                ,new User(
                        "hosseen",
                        passwordEncoder.encode("password"),
                        STUDENT.getGrantedAuthority(),
                        "hos",
                        "slslsl",
                        "0952624563",
                        true,
                        true,
                        true,
                        true

                )
        );
        usersService.addUsers(user);
        return true;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") String id){
        return usersService.getUser(id);
    }
}
