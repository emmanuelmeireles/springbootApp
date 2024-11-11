package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;

import jakarta.websocket.server.PathParam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    UserService userService;

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUserById(@PathVariable long id){
        userService.deleteUser(id);
    } 

    @DeleteMapping("/deleteUser")
    public void deleteUser(@RequestBody UserModel entity){
        userService.deleteUser(entity.getId());
    }
    
    @PutMapping("/updateUser/{id}")
    public UserModel putMethodNameById(@PathVariable long id, @RequestBody UserModel entity) {
        return userService.updateUser(id, entity);
    }

    @PutMapping("/updateUser")
    public UserModel putMethodName(@RequestBody UserModel entity) {
        return userService.updateUser(entity.getId(), entity);
    }

    @PostMapping("/newUser")
    public UserModel addNewUser(@RequestBody UserModel entity) {        
        return userService.createUser(entity);
    }
    
    @GetMapping("/getUsers/{id}")
    public UserModel getUserById(@PathVariable long id) {
        UserModel client = userService.getUserById(id);
        return client;
    }

    @GetMapping("/getAllUsers")
    public List<UserModel> getAllUsers() {
        List<UserModel> client = userService.getAllUsers();
        return client;
    } 

    @PostMapping("/statusOK")
    public ResponseEntity<String> returnStatus(@RequestBody UserModel entity) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/hello")
    public String helloString() {
        return "Hello World";
    }
}
