package com.example.demo.DTO;

import com.example.demo.Model.Ticket;

import java.time.LocalDateTime;

public class TicketDTO {
    private Integer flightId;
    private Integer numberOfPeople;
    private Integer ticketId;
    private String startDate;
    private String StartingLocation;
    private String Destination;

    public TicketDTO(Ticket ticket){
        this.flightId=ticket.getFlight().getId();
        this.ticketId=ticket.getId();
        this.numberOfPeople=ticket.getNumberOfSeats();
        this.startDate=ticket.getFlight().getBegin().toString();
        this.StartingLocation=ticket.getFlight().getStartingPlace();
        this.Destination=ticket.getFlight().getDestination();
    }
    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public Integer getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(Integer numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate.toString();
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }
}
