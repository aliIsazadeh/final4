package com.example.demo.repositories;

import com.example.demo.model.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnouncementRepo extends JpaRepository<Announcement,Integer> {
}
