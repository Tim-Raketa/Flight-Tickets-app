package com.example.demo.Controllers;
import com.example.demo.Model.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User newUser) throws Exception {
        String tempEmail = newUser.getEmail();
        Optional<User> user = userService.getUserByEmail(tempEmail);
        if (!user.isEmpty()) {
            throw new Exception("User with " + tempEmail + " already exists!");
        }
        return userService.registerUser(newUser);
    }

}
