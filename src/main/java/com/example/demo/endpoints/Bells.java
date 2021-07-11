package com.example.demo.endpoints;


import com.example.demo.model.Bell;
import com.example.demo.repositories.BellRepo;
import com.example.demo.services.BellsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bells")
public class Bells {


    BellsService bellsService = new BellsService();

    @GetMapping
    public ResponseEntity getBells(@RequestParam int pageSize, @RequestParam int page) {
        return null;
    }

    @PostMapping
    public ResponseEntity addBell(@RequestBody Bell bell) {
        Bell bell1 = bellsService.addBell(bell);
        if ((bell1)==null){
            return (ResponseEntity) ResponseEntity.notFound();
        }else {
            return ResponseEntity.ok(bell1);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity getBell(@RequestParam int id) {
        Bell bell = bellsService.getBell(id);
        if (bell==null){
            return (ResponseEntity) ResponseEntity.notFound();
        }else {
            return ResponseEntity.ok(bell);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity UpdateBell(@RequestParam int id, @RequestBody Bell bell) {
        Bell bell1 = bellsService.updateBell(id, bell);
        if (bell1==null){
            return (ResponseEntity) ResponseEntity.notFound();
        }else {
            return ResponseEntity.ok(bell1);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBell(@RequestParam int id) {
        Bell bell = bellsService.deleteBell(id);
        if (bell==null){
            return (ResponseEntity) ResponseEntity.notFound();
        }else {
            return ResponseEntity.ok(bell);
        }
    }
}
