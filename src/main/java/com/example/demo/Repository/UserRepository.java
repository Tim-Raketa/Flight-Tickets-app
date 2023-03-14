package com.example.demo.Repository;

import com.example.demo.Model.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface UserRepository extends MongoRepository<User, String> {
    User findByName(String name);
    @Query("{'name' : ?0}")
    public User findBy(String param1);

}
