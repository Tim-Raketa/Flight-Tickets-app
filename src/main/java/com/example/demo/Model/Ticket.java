package com.example.demo.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("tickets")
public class Ticket {
    @Id
    private Integer Id;
    private Flight Flight;
    private User User;
    private Integer NumberOfSeats;

    public Ticket(Integer id, com.example.demo.Model.Flight flight, com.example.demo.Model.User user, Integer numberOfSeats) {
        Id = id;
        Flight = flight;
        User = user;
        NumberOfSeats = numberOfSeats;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public com.example.demo.Model.Flight getFlight() {
        return Flight;
    }

    public void setFlight(com.example.demo.Model.Flight flight) {
        Flight = flight;
    }

    public com.example.demo.Model.User getUser() {
        return User;
    }

    public void setUser(com.example.demo.Model.User user) {
        User = user;
    }

    public Integer getNumberOfSeats() {
        return NumberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        NumberOfSeats = numberOfSeats;
    }
}
