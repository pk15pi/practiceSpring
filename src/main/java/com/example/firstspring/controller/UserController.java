package com.example.firstspring.controller;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private List<String> users = new ArrayList<>();

    //    curl http://localhost:8080/api/users
    @GetMapping
    public List<String> getAllUsers() {
        return users;
    }

    //    curl -X POST -H "Content-Type: application/json" -d '{"name":"John Doe"}' http://localhost:8080/api/users
    @PostMapping
    public String createUser(@RequestBody String user) {
        users.add(user);
        return "User created: " + user;
    }

    //    curl http://localhost:8080/api/users/John%20Doe
    @DeleteMapping("/{user}")
    public String deleteUser(@PathVariable String user) {
        if (users.contains(user)) {
            users.remove(user);
            return "User deleted: " + user;
        }
        return "User not found";
    }

}
