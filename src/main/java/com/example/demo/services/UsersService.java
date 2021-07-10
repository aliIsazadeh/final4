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

@Repository("org")
public class UsersService implements UserRepo  {

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

                ,new User(
                        "hosseen",
                        passwordEncoder.encode("password"),
                        STUDENT.getGrantedAuthority(),
                        "hos",
                        "slslsl",
                        "0952624563"
                )
        );
        return user;
    }

    public Page<User> getUsers(String name, int pageSize, int page) {
        Pageable pageable = PageRequest.of(page, pageSize);
        getUsers();
        return userRepo.findByFirstNameContainsOrLastNameContains(name, name, pageable);
    }


    @Override
    public Page<User> findByFirstNameContainsOrLastNameContains(String firstName, String lastName, Pageable pageable) {
        return null;
    }

    @Override
    public Optional<User> findByUserName(String userName) {
        return getUsers()
                .stream()
                .filter(user -> userName.equals(user.getUserName()))
                .findFirst();
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public List<User> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<User> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends User> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends User> S save(S entity) {
        return null;
    }

    @Override
    public <S extends User> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<User> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends User> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<User> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public User getOne(Integer integer) {
        return null;
    }

    @Override
    public <S extends User> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends User> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends User> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends User> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends User> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends User> boolean exists(Example<S> example) {
        return false;
    }
}