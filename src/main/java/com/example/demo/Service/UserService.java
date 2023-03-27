package com.example.demo.Service;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User registerUser(User newUser){
        return userRepository.save(newUser);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findById(email);
    }
}