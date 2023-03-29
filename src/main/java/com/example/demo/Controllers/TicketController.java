package com.example.demo.Controllers;

import com.example.demo.DTO.NewTicketDTO;
import com.example.demo.Model.Ticket;
import com.example.demo.Service.SequenceGeneratorService;
import com.example.demo.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.demo.Model.Ticket.SEQUENCE_NAME;

@RestController
@RequestMapping(value = "/Tickets", produces = MediaType.APPLICATION_JSON_VALUE)
public class TicketController {
    @Autowired
    private TicketService ticketService;
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;
    @PostMapping(value="/buy/ticket",consumes = "application/json")
    public Ticket NewTicket(@RequestBody NewTicketDTO ticket) {
        ticket.setId(sequenceGeneratorService.getSequenceNumber(SEQUENCE_NAME));
        return ticketService.CreateTicket(ticket);
    }
}
