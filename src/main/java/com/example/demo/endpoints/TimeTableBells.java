package com.example.demo.endpoints;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/api/timetablebells")
public class TimeTableBells {
    @GetMapping
    public ResponseEntity getAll(@RequestParam int pageSize, @RequestParam int page) {
        return null;
    }

    @PostMapping
    public ResponseEntity addTTB(@RequestBody int dayId, @RequestBody int bellId, @RequestBody int timeTableId) {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity getTBB(@PathVariable("id") int id) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTBB(@PathVariable("id") int id){return null;}
}
