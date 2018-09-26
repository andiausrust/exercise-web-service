package com.andi.exercisewebservice.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private UserDAOService userDAOService;

    @GetMapping("/users")
    public List<User> getUsers(){
        return userDAOService.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id){
        return userDAOService.findOne(id);
    }

    @PostMapping("/users")
    public void createUser(@RequestBody User user) {
        userDAOService.save(user);

    }
}
