package com.example.demo.DTO;

import com.example.demo.Model.Flight;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightDTO {
    private LocalDateTime dateTime;
    private String startingLocation;
    private String destination;
    private Float pricePerPerson;
    private Float totalPrice;

    public FlightDTO(LocalDateTime dateTime, String startingLocation, String destination, Float pricePerPerson, Float totalPrice) {
        this.dateTime = dateTime;
        this.startingLocation = startingLocation;
        this.destination = destination;
        this.pricePerPerson = pricePerPerson;
        this.totalPrice = totalPrice;
    }
    public FlightDTO(Flight flight,Integer numberOfPeople) {
        this.dateTime = flight.getBegin();
        this.startingLocation=flight.getStartingPlace();
        this.destination=flight.getDestination();
        this.pricePerPerson=flight.getSeatPrice();
        this.totalPrice=flight.getTotalPrice(numberOfPeople);
    }


    public FlightDTO() {
    }
}
