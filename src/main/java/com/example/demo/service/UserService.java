package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Client;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    UserRepository userRepository;
    
    public Client getUserById(Long id){
        Client client = userRepository.findById(id).get();
        return client;
    }

    public Client createUser(Client client){
        return userRepository.save(client);
    }

}
