package com.example.demo.Repository;

import com.example.demo.Model.Flight;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FlightRepository extends MongoRepository<Flight, Integer> {

}
