package com.example.demo.repositories;

import com.example.demo.model.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface AnnouncementRepo extends JpaRepository<Announcement,Integer> ,  PagingAndSortingRepository<Announcement,Integer> {

}
