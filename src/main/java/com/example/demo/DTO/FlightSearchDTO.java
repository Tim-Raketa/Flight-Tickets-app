package com.example.demo.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class FlightSearchDTO {
    private LocalDate date;
    private String startingLocation;
    private String destination;
    private Integer numberOfPeople;

    public FlightSearchDTO() {
    }

    public FlightSearchDTO(LocalDate Date, String startingLocation, String destination, Integer numberOfPeople) {
        this.date = Date;
        this.startingLocation = startingLocation;
        this.destination = destination;
        this.numberOfPeople = numberOfPeople;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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

    public Integer getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(Integer numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }
}
