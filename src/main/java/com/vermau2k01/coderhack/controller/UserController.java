package com.vermau2k01.coderhack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vermau2k01.coderhack.service.UserService;

import jakarta.validation.Valid;

import com.vermau2k01.coderhack.entity.MarksRequest;
import com.vermau2k01.coderhack.entity.UserRequest;
import com.vermau2k01.coderhack.entity.Users;
import java.util.*;



@RestController
@RequestMapping("/api/v1")
public class UserController {
    
    @Autowired
    private UserService userService;
    


    @GetMapping("/users")
    public ResponseEntity<List<Users>> getAllUsers()
    {
        List<Users> users =  userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.FOUND);
        
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable String id)
    {
    return new ResponseEntity<>(userService.getUserById(id),HttpStatus.FOUND);
    }
    

    @PostMapping("/users")
    public ResponseEntity<Users> addUsers(@Valid @RequestBody UserRequest userRequest)
    {
        return new ResponseEntity<>(userService.addUser(userRequest),HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id)
    {
        userService.deleteUser(id);
        return new ResponseEntity<>("User Deleted Successfully", HttpStatus.NO_CONTENT);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Users> updateMarks(@PathVariable String id,@Valid @RequestBody MarksRequest marksRequest)
    {
        return new ResponseEntity<>(userService.updateMarks(id, marksRequest), HttpStatus.OK);
    }

}
