package com.example.demo.Controllers;

import com.example.demo.DTO.NewTicketDTO;
import com.example.demo.DTO.TicketDTO;
import com.example.demo.Model.Ticket;
import com.example.demo.Service.SequenceGeneratorService;
import com.example.demo.Service.TicketService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.demo.Model.Ticket.SEQUENCE_NAME;

@RestController
@RequestMapping(value = "/Tickets", produces = MediaType.APPLICATION_JSON_VALUE)
public class TicketController {
    @Autowired
    private TicketService ticketService;
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @PostMapping(value = "/buy/ticket", consumes = "application/json")
    public Boolean NewTicket(@RequestBody NewTicketDTO ticket, HttpServletRequest request) {
        ticket.setId(sequenceGeneratorService.getSequenceNumber(SEQUENCE_NAME));
        return ticketService.CreateTicket(ticket,request);
    }
    @PostMapping(value = "/buy/ticket/unprotected", consumes = "application/json")
    public Boolean NewTickets(@RequestBody NewTicketDTO ticket) {
        ticket.setId(sequenceGeneratorService.getSequenceNumber(SEQUENCE_NAME));
        return ticketService.CreateTicket(ticket);
    }

    @GetMapping(value = "/user")
    public List<TicketDTO> getByUser(HttpServletRequest request) {
        return ticketService.getByUser(request);
    }
}
