package com.example.demo.Service;

import com.example.demo.DTO.UserRequest;
import com.example.demo.Model.Role;
import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.Util.TokenUtils;

import java.util.ArrayList;
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
    @Autowired
    private TokenUtils tokenUtils;

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
        Role role = new Role(1, "ROLE_USER");
        List<Role> roles = new ArrayList<Role>();
        roles.add(role);
        newUser.setRoles(roles);

        return userRepository.save(newUser);
    }

    public User registerAdmin(UserRequest userRequest){
        User newUser = new User();

        newUser.setEmail(userRequest.getEmail());
        newUser.setUsername(userRequest.getEmail());
        newUser.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        newUser.setName(userRequest.getName());
        newUser.setSurname(userRequest.getSurname());

        // u primeru se registruju samo obicni korisnici i u skladu sa tim im se i dodeljuje samo rola USER
        newUser.setRole("ROLE_ADMIN");
        Role role = new Role(2, "ROLE_ADMIN");
        List<Role> roles = new ArrayList<Role>();
        roles.add(role);
        newUser.setRoles(roles);

        return userRepository.save(newUser);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findById(email);
    }

    public User getLoggedInUser(HttpServletRequest request) {
        String email = tokenUtils.getEmailDirectlyFromHeader(request);
        User user = userRepository.findByUsername(email);
        return user;
    }
}
