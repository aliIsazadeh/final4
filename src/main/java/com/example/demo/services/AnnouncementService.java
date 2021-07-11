package com.example.demo.services;

import com.example.demo.model.Announcement;
import com.example.demo.model.User;
import com.example.demo.repositories.AnnouncementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncementService {

    @Autowired
    private AnnouncementRepo announcementRepo;

    public List<Announcement> getAnnouncements(int page, int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return announcementRepo.findAll(pageable).toList();
    }

    public Announcement getAnnouncementById(int id){
        return  announcementRepo.findById(id).orElseThrow(()
                -> null);
    }

    public Announcement deleteAnnouncementById(int id){
        announcementRepo.deleteById(id);
        return  announcementRepo.findById(id).orElseThrow(()
                -> null);
    }


    public Announcement addAnnouncement(int TT , String message){
        Announcement announcement = new Announcement(TT,message);
        announcementRepo.saveAndFlush(announcement);
        return announcement;
    }

    public Announcement getAnnouncement(int masterId, int timeTableId, int pageSize, int page){
        return  null;
    }
}
