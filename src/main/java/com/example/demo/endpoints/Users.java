package com.example.demo.endpoints;

import com.example.demo.JWT.JwtUtil;
import com.example.demo.model.User;
import com.example.demo.model.requestBodyModels.AddUser;
import com.example.demo.model.requestBodyModels.ChangePasswordUser;
import com.example.demo.model.requestBodyModels.EditProfileUser;
import com.example.demo.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public ResponseEntity getAll(@RequestParam(required = false, defaultValue = "") String name,
                                 @RequestParam(required = false, defaultValue = "10") int pageSize,
                                 @RequestParam(required = false, defaultValue = "0") int page) {
        Map<String, Object> data = new HashMap<>();
        Page<User> resultPage = usersService.getUsers(name, pageSize, page);
        List<User> users = resultPage.stream().collect(Collectors.toList());
        data.put("list", users);
        data.put("pageSize", resultPage.getNumberOfElements());
        data.put("page", resultPage.getNumber());
        data.put("totalPage", resultPage.getTotalPages());
        return ResponseEntity.ok(data);

    }

    @GetMapping("/{id}")
    public ResponseEntity getUser(@PathVariable int id) {
        User user = usersService.getUser(String.valueOf(id));
        if (user == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity editUser(@PathVariable int id, @RequestBody User user) {
        User userResult = usersService.getUser(String.valueOf(id));
        if (userResult == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        else
            return ResponseEntity.ok(usersService.editUser(user));
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity deleteUser(@PathVariable int id) {
//        User user = null;
//        if((user=usersService.deleteUser(String.valueOf(id)))==null)
//            return ResponseEntity.ok(user);
//        else
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(user);
//
//    }

    @GetMapping("/profile")
    public ResponseEntity getMyProfile(@RequestHeader("Authorization") String token) {
        String username = jwtUtil.getUsernameFromToken(token);
        User user = usersService.getUser(username);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/profile")
    public ResponseEntity editMyProfile(@RequestHeader("authorization") String token, @RequestBody EditProfileUser body) {
        String username = jwtUtil.getUsernameFromToken(token);
        User user = usersService.getUser(username);
        if (user == null) {
            System.out.println("nikdnscjnsdkjncksdjncs");
            return ResponseEntity.notFound().build();
        } else {
            user.setFirstName(body.getFirstName());
            user.setLastName(body.getLastName());
            user.setPhoneNum(body.getPhoneNumber());
        }
        return ResponseEntity.ok(usersService.editUser(user));
    }

    @PostMapping("/profile/changePassword")
    public ResponseEntity changeMyPassword(@RequestHeader("authorization") String token,
                                           @RequestBody ChangePasswordUser body) {
        String username = jwtUtil.getUsernameFromToken(token);
        User user = usersService.getUser(username);
        System.out.println("username = " + username);
        if (user == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        if (passwordEncoder.matches(body.getCurrentPassword(), user.getPassword())) {
            user.setPassword(passwordEncoder.encode(body.getNewPassword()));
            return ResponseEntity.ok(usersService.editUser(user));
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody AddUser user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        User added = usersService.addUser(user);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/addList")
    public ResponseEntity addUsers(@RequestBody List<User> users) {
        return ResponseEntity.ok(usersService.addUsers(users));
    }
}
