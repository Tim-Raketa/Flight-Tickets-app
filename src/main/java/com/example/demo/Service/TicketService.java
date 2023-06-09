package com.example.demo.Service;

import com.example.demo.DTO.NewTicketDTO;
import com.example.demo.DTO.TicketDTO;
import com.example.demo.Model.Flight;
import com.example.demo.Model.Ticket;
import com.example.demo.Model.User;
import com.example.demo.Repository.FlightRepository;
import com.example.demo.Repository.TicketRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class TicketService {
    @Autowired
    private UserService userService;
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private FlightRepository flightRepository;
    public Boolean CreateTicket(NewTicketDTO ticket, HttpServletRequest request){
        Optional<Flight> flight=flightRepository.findById(ticket.getFlightId());

        if(!flight.isPresent() || (flight.get().getFreeSeats()<ticket.getNumberOfPeople())) return false;

        User user = userService.getLoggedInUser(request);
        flight.get().takeUpSeats(ticket.getNumberOfPeople());

        flightRepository.save(flight.get());
        ticketRepository.save(new Ticket(ticket.getId(), flight.get(), user, ticket.getNumberOfPeople()));
        return true;
    }
    public List<TicketDTO> getByUser(HttpServletRequest request){
        User user = userService.getLoggedInUser(request);
        if(!ticketRepository.findAllByUser(user).isPresent()) return null;
        return TicketToDTO(ticketRepository.findAllByUser(user).get());
    }


    public List<TicketDTO> TicketToDTO(List<Ticket> tickets) {
        List<TicketDTO> ticketDTOS = new ArrayList<>();
        for (Ticket ticket : tickets) {
            ticketDTOS.add(new TicketDTO(ticket));
        }
        return ticketDTOS;
    }

    public Boolean CreateTicket(NewTicketDTO ticket) {
        Optional<Flight> flight=flightRepository.findById(ticket.getFlightId());

        if(!flight.isPresent() || (flight.get().getFreeSeats()<ticket.getNumberOfPeople())) return false;

        User user = userService.getUserByEmail(ticket.getEmail()).get();
        flight.get().takeUpSeats(ticket.getNumberOfPeople());

        flightRepository.save(flight.get());
        ticketRepository.save(new Ticket(ticket.getId(), flight.get(), user, ticket.getNumberOfPeople()));
        return true;
    }
}
