package com.example.demo.Service;

import com.example.demo.DTO.UserRequest;
import com.example.demo.Model.Role;
import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleService roleService;


    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User registerUser(UserRequest userRequest){
        User newUser = new User();

        newUser.setEmail(userRequest.getEmail());
        newUser.setUsername(userRequest.getEmail());
        newUser.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        newUser.setName(userRequest.getName());
        newUser.setSurname(userRequest.getSurname());

        // u primeru se registruju samo obicni korisnici i u skladu sa tim im se i dodeljuje samo rola USER
        newUser.setRole("ROLE_USER");

        return userRepository.save(newUser);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findById(email);
    }
}
