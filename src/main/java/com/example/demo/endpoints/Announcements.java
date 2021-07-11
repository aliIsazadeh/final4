package com.example.demo.endpoints;

import com.example.demo.model.Announcement;
import com.example.demo.services.AnnouncementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/api/announcements")
public class Announcements {
    AnnouncementService announcementService= new AnnouncementService();
    private ResponseEntity responseEntity;



    @GetMapping
    public ResponseEntity announcements(@RequestParam("masterId") int masterId,
                                        @RequestParam("timeTableId") int timeTableId,
                                        @RequestParam("pageSize") int pageSize,
                                        @RequestParam("page") int page) {
        return null;
    }

    @PostMapping
    public ResponseEntity announcements(@RequestBody int timeTableId, @RequestBody String message) {
        if (announcementService.addAnnouncement(timeTableId,message)==null){
            return (ResponseEntity) ResponseEntity.notFound();
        }else{
        return  ResponseEntity.ok(announcementService.addAnnouncement(timeTableId,message));}
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathParam("id") int id){
        if (announcementService.getAnnouncementById(id)==null){
            return (ResponseEntity) ResponseEntity.notFound();
        }else {
        return  ResponseEntity.ok(announcementService.getAnnouncementById(id));}
    }


    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathParam("id") int id){
        if (announcementService.deleteAnnouncementById(id)==null){
            return (ResponseEntity) ResponseEntity.notFound();
        }else {
            return ResponseEntity.ok(announcementService.deleteAnnouncementById(id));
        }
    }

}
