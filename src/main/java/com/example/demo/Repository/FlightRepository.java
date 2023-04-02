package com.example.demo.Repository;

import com.example.demo.Model.Flight;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FlightRepository extends MongoRepository<Flight, Integer> {
    List<Flight> findByBeginIsBetweenAndDestinationIsContainingIgnoreCaseAndStartingPlaceIsContainingIgnoreCaseAndFreeSeatsGreaterThan
            (LocalDateTime date1,LocalDateTime date2,String dest, String start, Integer seats);

    Optional<Flight> findById(Integer id);
}
