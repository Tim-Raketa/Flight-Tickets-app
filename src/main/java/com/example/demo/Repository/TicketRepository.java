package com.example.demo.Repository;

import com.example.demo.Model.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TicketRepository extends MongoRepository<Ticket, Integer> {
}
