package com.example.demo.endpoints;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/timetables")
public class TimeTables {

    @GetMapping
    public ResponseEntity getAll(@RequestParam int studentId,
                                 @RequestParam int courseId,
                                 @RequestParam int masterId,
                                 @RequestParam int pageSize,
                                 @RequestParam int page) {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity getTB(@PathVariable int id) {
        return null;
    }

    @PostMapping("/{id}/choose")
    public ResponseEntity selectTimeTable(@PathVariable int id) {
        return null;
    }

    @PostMapping("/startprocess")
    public ResponseEntity startProcess(@RequestParam int maxClassPerBell) {
        return null;
    }
}
