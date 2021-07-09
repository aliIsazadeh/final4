package com.example.demo.repositories;

import com.example.demo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface UserRepo extends JpaRepository<User,Integer>, PagingAndSortingRepository<User,Integer> {
    Page<User> findByFirstNameContainsOrLastNameContains(String firstName, String lastName ,Pageable pageable);
}
