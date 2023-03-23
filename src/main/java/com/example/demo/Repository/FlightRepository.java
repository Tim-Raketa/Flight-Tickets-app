package com.example.demo.Repository;

import com.example.demo.Model.Flight;
import com.example.demo.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface FlightRepository extends MongoRepository<Flight, Integer> {

}
