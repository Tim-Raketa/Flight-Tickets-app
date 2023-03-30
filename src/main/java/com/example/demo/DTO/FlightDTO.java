package com.example.demo.DTO;

import com.example.demo.Model.Flight;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
public class FlightDTO {
    private Integer id;
    private String dateTime;
    private String startingLocation;
    private String destination;
    private Float pricePerPerson;
    private Float totalPrice;

    public FlightDTO(Flight flight,Integer numberOfPeople) {
        this.id=flight.getId();
        this.dateTime = flight.getBegin().toString();
        this.startingLocation=flight.getStartingPlace();
        this.destination=flight.getDestination();
        this.pricePerPerson=flight.getSeatPrice();
        this.totalPrice=flight.getTotalPrice(numberOfPeople);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime.toString();
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
