package com.example.demo.Service;

import com.example.demo.DTO.NewTicketDTO;
import com.example.demo.Model.Flight;
import com.example.demo.Model.Ticket;
import com.example.demo.Model.User;
import com.example.demo.Repository.FlightRepository;
import com.example.demo.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private FlightRepository flightRepository;
    public Ticket CreateTicket(NewTicketDTO ticket){
        Optional<Flight> flight=flightRepository.findById(ticket.getFlightId());
        if(!flight.isPresent() || (flight.get().getFreeSeats()<ticket.getNumberOfPeople())) return null;
        User user = new User("moc", "123","Bo", "Moc", "1231231231233");
        flight.get().takeUpSeats(ticket.getNumberOfPeople());
        flightRepository.save(flight.get());
        return ticketRepository.save(new Ticket(ticket.getId(), flight.get(), user, ticket.getNumberOfPeople()));
    }
   

}
