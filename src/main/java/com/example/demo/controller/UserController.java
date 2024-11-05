package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Client;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/statusOK")
    public ResponseEntity<String> postMethodName(@RequestBody Client entity) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/newUser")
    public Client newUser(@RequestBody Client client) {
        // System.out.println(client);
        return userService.createUser(client);
        // return new ResponseEntity<String>("Usuário cadastrado", HttpStatus.OK);
    }

    @GetMapping("/getUsers/{id}")
    public Client getMethodName(@PathVariable long id) {
        Client client = userService.getUserById(id);
        return client;
    }

    @GetMapping("/hello")
    public String helloString() {
        return "Hello World";
    }
}
