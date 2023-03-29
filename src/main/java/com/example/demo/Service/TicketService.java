package com.example.demo.Service;

import com.example.demo.DTO.NewTicketDTO;
import com.example.demo.Model.Flight;
import com.example.demo.Model.Ticket;
import com.example.demo.Repository.FlightRepository;
import com.example.demo.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private FlightRepository flightRepository;
    public Ticket CreateTicket(NewTicketDTO ticket){
        Optional<Flight> flight=flightRepository.findById(ticket.getFlightId());
        if(flight.isPresent())
            return ticketRepository.save(new Ticket(1,flight.get(),null,1));
        return null;
    }
}
