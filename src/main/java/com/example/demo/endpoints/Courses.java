package com.example.demo.endpoints;


import com.example.demo.model.Course;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController("/api/courses")
public class Courses {
    @GetMapping()
    public ResponseEntity getCourses(@RequestParam String search,
                                     @RequestParam int unitCount,
                                     @RequestParam int pageSize,
                                     @RequestParam int page) {
        return null;
    }

    @PostMapping
    public ResponseEntity addCourse(@RequestBody Course course) {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity getCourse(@PathVariable int id) {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity editCourse(@PathVariable int id, @RequestBody Course course) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCourse(@PathVariable int id) {
        return null;
    }

    @GetMapping("/{id}/timetables")
    public ResponseEntity getTimeTablesOfCourse(@PathVariable int id,
                                                @RequestParam int pageSize,
                                                @RequestParam int page) {
        return null;
    }

    @GetMapping("/{id}/masters")
    public ResponseEntity getMastersOfCourse(@PathVariable int id,
                                             @RequestParam int pageSize,
                                             @RequestParam int page) {
        return null;
    }

    @PostMapping("/{id}/choose")
    public ResponseEntity chooseCourseFromMaster(@PathVariable int id) {
        return null;
    }
}
