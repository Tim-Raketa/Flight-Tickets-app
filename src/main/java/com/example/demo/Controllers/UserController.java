package com.example.demo.Controllers;
import com.example.demo.DTO.UserRequest;
import com.example.demo.Model.Role;
import com.example.demo.Model.User;
import com.example.demo.Repository.RoleRepository;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/getAll")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/register")
    public Boolean registerUser(@RequestBody UserRequest newUser) throws Exception {
        Boolean created = false;
        String tempEmail = newUser.getEmail();
        Optional<User> user = userService.getUserByEmail(tempEmail);
        if (user.isEmpty()) {
            userService.registerUser(newUser);
            created = true;
        }
        return created;
    }

    @PostMapping("/createRole")
    public Boolean createRole(@RequestBody Role role) throws Exception {
        roleRepository.save(role);

        return true;
    }



}
