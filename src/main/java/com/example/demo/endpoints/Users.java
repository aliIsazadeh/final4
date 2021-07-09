package com.example.demo.endpoints;

import com.example.demo.model.User;
import com.example.demo.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class Users {

    @Autowired
    private UsersService usersService;

    @GetMapping
    public ResponseEntity getAll(@RequestParam(required = false, defaultValue = "") String name,
                                 @RequestParam(required = false, defaultValue = "10") int pageSize,
                                 @RequestParam(required = false, defaultValue = "0") int page) {
        Map<String, Object> data = new HashMap<>();
        Page<User> resultPage= usersService.getUsers(name,pageSize,page);
        List<User> users = resultPage.stream().collect(Collectors.toList());
        data.put("list", users);
        data.put("pageSize", resultPage.getNumberOfElements());
        data.put("page", resultPage.getNumber());
        data.put("totalPage", resultPage.getTotalPages());
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
