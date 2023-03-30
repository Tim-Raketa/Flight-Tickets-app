package com.example.demo.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("tickets")
public class Ticket {
    @Transient
    public static final String SEQUENCE_NAME = "ticket_sequence";
    @Id
    private Integer id;
    private Flight flight;
    private User user;
    private Integer numberOfSeats;

    public Ticket(Integer id, com.example.demo.Model.Flight flight, com.example.demo.Model.User user, Integer numberOfSeats) {
        this.id = id;
        this.flight = flight;
        this.user = user;
        this.numberOfSeats = numberOfSeats;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public com.example.demo.Model.Flight getFlight() {
        return flight;
    }

    public void setFlight(com.example.demo.Model.Flight flight) {
        this.flight = flight;
    }

    public com.example.demo.Model.User getUser() {
        return user;
    }

    public void setUser(com.example.demo.Model.User user) {
        this.user = user;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
