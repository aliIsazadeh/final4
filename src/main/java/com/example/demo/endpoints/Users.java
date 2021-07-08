package com.example.demo.endpoints;

import com.example.demo.model.User;
import com.example.demo.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class Users {

    @Autowired
    private UsersService usersService;

    @GetMapping
    public ResponseEntity getAll() {
        Map<String, Object> data = new HashMap<>();
        data.put("list", usersService.getUsers());
        data.put("pageSize",1);
        data.put("page",1);
        data.put("totalPage",1);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/{id}")
    public ResponseEntity getUser(@PathVariable int id) {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity editUser(@PathVariable int id, @RequestParam User user) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable int id) {
        return null;
    }

    @GetMapping("/profile")
    public ResponseEntity getMyProfile() {
        return null;
    }

    @PostMapping("/profile")
    public ResponseEntity editMyProfile() {
        return null;
    }

    @PostMapping("/profile/changePassword")
    public ResponseEntity changeMyPassword(@RequestBody String currentPassword, @RequestBody String newPassword) {
        return null;
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User added = usersService.addUser(user);
        return ResponseEntity.ok(added);
    }

    @PostMapping("/addList")
    public ResponseEntity addUsers(@RequestBody List<User> users) {
        return null;
    }
}
