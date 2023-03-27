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
    public FlightDTO() {
    }
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

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getStartingLocation() {
        return startingLocation;
    }

    public void setStartingLocation(String startingLocation) {
        this.startingLocation = startingLocation;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Float getPricePerPerson() {
        return pricePerPerson;
    }

    public void setPricePerPerson(Float pricePerPerson) {
        this.pricePerPerson = pricePerPerson;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }
}
