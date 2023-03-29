package com.example.demo.Repository;

import com.example.demo.Model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RoleRepository extends MongoRepository<Role, Long> {
    List<Role> findByName(String name);
}
