package com.example.demo.endpoints;

import com.example.demo.JWT.JwtUtil;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.services.UsersService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Initializer {

    private final UsersService usersService;

    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Autowired
    public Initializer(PasswordEncoder passwordEncoder, UsersService usersService, JwtUtil jwtUtil) {
        this.passwordEncoder = passwordEncoder;
        this.usersService = usersService;
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/init")
    public boolean init() {
        List<User> user = Lists.newArrayList(
                User.builder().firstName("ali").lastName("forghani")
                        .username("1")
                        .password(passwordEncoder.encode("1")).phoneNum("09145030651").role(Role.ADMIN).build(),
                User.builder().firstName("ali").lastName("isa").username("2").password(passwordEncoder.encode("2")).role(Role.MASTER).phoneNum("09145032221").build(),
                User.builder().firstName("fati").lastName("ghafouri").username("3").password(passwordEncoder.encode("3")).role(Role.ADMIN).phoneNum("09146633942").build()
        );
        usersService.addUsers(user);
        return true;
    }

    @GetMapping("/{id}/find")
    public User getUser(@PathVariable("id") String id) {
        return usersService.getUser(id);
    }

    @GetMapping("/all")
    public List<User> getAll(){
        return usersService.getUsers();
    }   @GetMapping("/test")
    public String getAll(@RequestHeader("authorization") String token){
        return jwtUtil.getUsernameFromToken(token);

    }
}
