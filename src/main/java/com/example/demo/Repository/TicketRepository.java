package com.example.demo.Repository;

import com.example.demo.Model.Ticket;
import com.example.demo.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface TicketRepository extends MongoRepository<Ticket, Integer> {
    Optional<List<Ticket>> findAllByUser(User user);

}
