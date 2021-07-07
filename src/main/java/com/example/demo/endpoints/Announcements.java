package com.example.demo.endpoints;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/api/announcements")
public class Announcements {


    @GetMapping
    public ResponseEntity announcements(@RequestParam("masterId") int masterId,
                                        @RequestParam("timeTableId") int timeTableId,
                                        @RequestParam("pageSize") int pageSize,
                                        @RequestParam("page") int page) {
        return null;
    }

    @PostMapping
    public ResponseEntity announcements(@RequestBody int timeTableId, @RequestBody String message) {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathParam("id") int id){return null;}


    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathParam("id") int id){return null;}

}
