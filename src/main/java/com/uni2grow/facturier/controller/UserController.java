package com.uni2grow.facturier.controller;


import com.uni2grow.facturier.model.User;
import com.uni2grow.facturier.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        return userService.saveUser(user);
    }
    @GetMapping("/users")
    public Iterable<User> getUsers(){
      return userService.getUsers();
    }
}
