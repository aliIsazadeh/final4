package com.example.demo.endpoints;


import com.example.demo.model.Bell;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/api/bells")
public class Bells {


    @GetMapping
    public ResponseEntity getBells(@RequestParam int pageSize, @RequestParam int page) {
        return null;
    }

    @PostMapping
    public ResponseEntity addBell(@RequestBody Bell bell) {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity getBell(@RequestParam int id) {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity getBell(@RequestParam int id, @RequestBody Bell bell) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBell(@RequestParam int id) {
        return null;
    }
}
