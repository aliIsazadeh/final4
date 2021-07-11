package com.example.demo.repositories;

import com.example.demo.model.Bell;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface BellRepo extends JpaRepository<Bell, Integer > , PagingAndSortingRepository<Bell,Integer> {
}
