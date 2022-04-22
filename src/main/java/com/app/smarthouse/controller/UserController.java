package com.app.smarthouse.controller;

import com.app.smarthouse.model.User;
import com.app.smarthouse.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;
   /* @PostMapping("/addUser")
    public void save(@RequestBody User user)
    {

    }*/

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> findAll()
    {
        List<User> users = userService.getAll();
        return  ResponseEntity.ok(users);
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user)
    {
        return userService.addUser(user);
    }
}
