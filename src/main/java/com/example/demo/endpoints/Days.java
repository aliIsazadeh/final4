package com.example.demo.endpoints;


import com.example.demo.model.Day;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/api/days")
public class Days {

    @GetMapping
    public ResponseEntity getAllDays(@RequestParam int pageSize, @RequestParam int page){return null;}


    @PostMapping()
    public ResponseEntity addDate(@RequestBody Day day){return null;}

    @GetMapping("/{id}")
    public ResponseEntity getDay(@PathVariable int id){return null;}
    @PutMapping("/{id}")
    public ResponseEntity editDay(@PathVariable int id, @RequestBody Day day){return null;}
    @DeleteMapping("/{id}")
    public ResponseEntity deleteDay(@PathVariable int id){return null;}
}
