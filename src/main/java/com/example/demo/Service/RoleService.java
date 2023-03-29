package com.example.demo.Service;

import com.example.demo.Model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Repository.RoleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role findById(Long id) {
        Optional<Role> auth = this.roleRepository.findById(id);
        return auth.get();
    }

    public List<Role> findByName(String name) {
        List<Role> roles = this.roleRepository.findByName(name);
        return roles;
    }

}
